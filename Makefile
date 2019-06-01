all: build

setup:
	mkdir -p docs/

copy: setup
	cp -r ./images docs/
	cp -r ./assets docs/

html: setup
	asciidoctor -b xhtml -a docinfo -a stylesheet! src/index.adoc -o docs/index.html

htmlcljsinfo: setup
	asciidoctor -b xhtml -a docinfo -a stylesheet=../assets/stylesheet.cljsinfo.css  src/index.adoc -o docs/index.html

git:
	git submodule init
	git submodule update

docbook: setup
	asciidoctor -b docbook45 -a numbered -d book -a data-uri!  src/index.adoc -o docs/clojurescript-unraveled.xml

pdf: docbook
	./asciidoctor-fopub/fopub -t docbook-xsl docs/clojurescript-unraveled.xml
	gs -dBATCH -dNOPAUSE -q -sDEVICE=pdfwrite -sOutputFile=docs/_clojurescript-unraveled.pdf cover/cover.pdf docs/clojurescript-unraveled.pdf
	mv docs/_clojurescript-unraveled.pdf docs/clojurescript-unraveled.pdf

rawpdf:
	./asciidoctor-fopub/fopub -t docbook-xsl docs/clojurescript-unraveled.xml

epub: docbook copy
	./docbook-xsl/bin/dbtoepub -s xsl-styleshets/epub/docbook.xsl  docs/clojurescript-unraveled.xml -o docs/_clojurescript-unraveled.epub
	ebook-convert docs/_clojurescript-unraveled.epub docs/clojurescript-unraveled.epub --chapter="/" --no-chapters-in-toc --cover=cover/cover.png --authors="Andrey Antukh & Alejandro Gomez"

mobi: epub
	ebook-convert docs/_clojurescript-unraveled.epub docs/clojurescript-unraveled.mobi --output-profile=kindle --chapter="/" --no-chapters-in-toc --cover=cover/cover.png --mobi-ignore-margins --margin-left=2 --margin-right=2

github: html
	ghp-import -m "Generate book" -b gh-pages docs/
	git push origin gh-pages

clean:
	rm -r docs/

build: copy html

buildcljsinfo: copy htmlcljsinfo

watch: build
	sh ./watch.sh

watchcljsinfo: buildcljsinfo
	sh ./watch.sh htmlcljsinfo

release: clean pdf epub mobi html github
