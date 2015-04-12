all: build
build: html

html:
	mkdir -p dist/
	asciidoctor -b xhtml -a stylesheet=../assets/stylesheet.css -a numbered  src/index.adoc -o dist/index.html

docbook:
	mkdir -p dist/
	asciidoctor -b docbook45 -a stylesheet=../assets/stylesheet.css -a numbered  src/index.adoc -o dist/index.xml


pdf: docbook
	./asciidoctor-fopub/fopub -t docbook-xsl dist/index.xml
