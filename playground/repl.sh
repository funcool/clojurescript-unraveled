if [ ! -e cljs.jar ]; then
    wget https://github.com/clojure/clojurescript/releases/download/r3211/cljs.jar
fi
rlwrap java -jar cljs.jar repl.clj
