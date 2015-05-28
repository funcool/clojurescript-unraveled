#!/bin/sh

if [ -r cljs.jar ]; then
    rm cljs.jar;
fi

wget https://github.com/clojure/clojurescript/releases/download/r3269/cljs.jar
