all: build

setup:
	mkdir -p dist/

copy: setup
	cp -r ./images dist/

html: setup
	asciidoctor -b xhtml -a docinfo -a stylesheet=../assets/stylesheet2.css  src/index.adoc -o dist/index.html

git:
	git submodule init
	git submodule update

docbook: setup
	asciidoctor -b docbook45 -a numbered -d book -a data-uri!  src/index.adoc -o dist/clojurescript-unraveled.xml

pdf: docbook
	./asciidoctor-fopub/fopub -t docbook-xsl dist/clojurescript-unraveled.xml
	gs -dBATCH -dNOPAUSE -q -sDEVICE=pdfwrite -sOutputFile=dist/_clojurescript-unraveled.pdf cover/cover.pdf dist/clojurescript-unraveled.pdf
	mv dist/_clojurescript-unraveled.pdf dist/clojurescript-unraveled.pdf

rawpdf:
	./asciidoctor-fopub/fopub -t docbook-xsl dist/clojurescript-unraveled.xml

epub: docbook copy
	dbtoepub -s xsl-styleshets/epub/docbook.xsl  dist/clojurescript-unraveled.xml -o dist/_clojurescript-unraveled.epub
	ebook-convert dist/_clojurescript-unraveled.epub dist/clojurescript-unraveled.epub --chapter="/" --no-chapters-in-toc --cover=cover/cover.png --authors="Andrey Antukh & Alejandro Gomez"

mobi: epub
	ebook-convert dist/_clojurescript-unraveled.epub dist/clojurescript-unraveled.mobi --output-profile=kindle --chapter="/" --no-chapters-in-toc --cover=cover/cover.png --mobi-ignore-margins --margin-left=2 --margin-right=2

github: html
	ghp-import -m "Generate book" -b gh-pages dist/
	git push origin gh-pages

clean:
	rm -r dist/

build: copy html

watch: build
	sh ./watch.sh

release: clean pdf epub mobi html github
