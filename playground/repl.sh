if [ ! -e cljs.jar ]; then
    wget https://github.com/clojure/clojurescript/releases/download/r1.7.228/cljs.jar
fi
rlwrap java -jar cljs.jar hello_world_repl_nodejs/repl.clj
