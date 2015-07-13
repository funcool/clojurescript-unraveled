(require
  '[cljs.repl :as repl]
  '[cljs.repl.node :as node])

(repl/repl (node/repl-env)
 :output-dir "out"
 :cache-analysis true)
