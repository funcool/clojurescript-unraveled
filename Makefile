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

docbook45:
	mkdir -p dist/
	asciidoctor -b docbook45 -a numbered -d book -a data-uri!  src/index.adoc -o dist/index.xml

docbook5:
	mkdir -p dist/
	asciidoctor -b docbook -a numbered -d book -a data-uri!  src/index.adoc -o dist/index5.xml

pdf: docbook5
	./asciidoctor-fopub/fopub -t docbook-xsl dist/index5.xml

epub3: docbook5 copy
	dbtoepub -s xsl-styleshets/epub3/docbook.xsl  dist/index5.xml -o dist/index5.epub

epub: docbook45 copy
	dbtoepub -s xsl-styleshets/epub/docbook.xsl  dist/index.xml -o dist/index.epub

pdfraw:
	./asciidoctor-fopub/fopub -t docbook-xsl dist/index5.xml

github: html
	ghp-import -m "Generate book" -b gh-pages dist/
	git push origin gh-pages

watch: build
	sh ./watch.sh
