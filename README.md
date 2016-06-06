# ClojureScript Unraveled #

[![](https://licensebuttons.net/l/by-sa/4.0/80x15.png "License")](http://creativecommons.org/licenses/by-sa/4.0/)

An open source ClojureScript book. Read an HTML version [here](http://funcool.github.io/clojurescript-unraveled/).
A version for ebook readers (epub, mobi) is available [on Leanpub](http://leanpub.com/clojurescript-unraveled), where
you have the opportunity to make a donation and buy us a beer.

This books aims to serve as:
- A comprehensive introduction to the ClojureScript language and its idiomatic usage,
  assuming no previous experience with Clojure or functional programming;
- a detailed guide of the ClojureScript compiler and the tooling around it; and
- a mixed bag of topics that are useful in day-to-day ClojureScript programming.

As such, it is divided into three main sections: Language, Tooling & Compiler, and
Mixed Bag.


## Status ##

At this moment the book is still being written and is mostly incomplete.

We are not native English speakers, so language improvements and typo fixes are very, very
welcome!


## How to Contribute ##

This is a quick and dirty FAQ:

- If you found some typo or wording improvements (that do not imply any structural
  changes) open a pull-request directly.
- If you want to propose a new chapter, please open an issue for discussing it.
- If you want to propose a structural change, please open an issue for discussing it.
- If you want to suggest an additional topic, please open an issue for discussing it.

Please, maintain the commit size small for easy commits picking.

**Rules for text formatting**:

- Use correct asciidoctor syntax.
- Max line width should be 84 chars.

**General note**:

At this moment, we do not have plans to accept new chapters until the the basic book
structure is finished. This is not because we don't want to, but because it's very
difficult to handle that at this stage of the book. That being said, proposals are very
welcome.


## How to build ##

The book is written using asciidoctor, so you should install the last version of
asciidoctor using your package manager. The asciidoctor is responsible of the generation
of the online html format. So if you are happy with a local copy in html format, this
is a unique dependency that you need.

This is a command for generate the html:

```bash
make html
chromium dist/index.html
```

If you want to generate a pdf. Some additional depencies are needed. For this process
we are using fopub tool (included in the repo) that requires the JDK 7 or 8.

For generate pdf, having jdk installed, execute this:

```bash
make git
make pdf
# This will generate dist/clojurescript-unraveled.pdf
```

And finally, if you want to generate epub or mobi, you should install `calibre` and
`docbook-xsl` using the package manager of you distribution. Once you have this installed,
execute the following commands:

```bash
make epub
make mobi
```


## License ##

This book is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License.
