all: build
build: html

html:
	mkdir -p dist/
	asciidoctor -b xhtml -a stylesheet=../assets/stylesheet.css -a numbered  src/index.adoc -o dist/index.html
