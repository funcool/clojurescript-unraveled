(ns init-repl-test
  (:require [cljs.repl]
            [cljs.repl.nashorn]))

(cljs.repl/repl
 (cljs.repl.nashorn/repl-env)
 :output-dir "out"
 :cache-analysis true)
