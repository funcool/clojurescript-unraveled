all: build

build: copy html

copy:
	mkdir -p dist/
	cp -r ./images dist/

html:
	mkdir -p dist/
	asciidoctor -b xhtml -a docinfo -a stylesheet=../assets/stylesheet2.css  src/index.adoc -o dist/index.html

git:
	git submodule init
	git submodule update

docbook:
	mkdir -p dist/
	asciidoctor -b docbook45 -a numbered  src/index.adoc -o dist/index.xml

pdf: docbook git
	./asciidoctor-fopub/fopub -t docbook-xsl dist/index.xml

epub: docbook
	dbtoepub -s xsl-styleshets/epub/docbook.xsl  dist/index.xml -o dist/index.epub

pdfraw:
	./asciidoctor-fopub/fopub -t docbook-xsl dist/index.xml

github: html
	ghp-import -m "Generate book" -b gh-pages dist/
	git push origin gh-pages

watch: build
	sh ./watch.sh
