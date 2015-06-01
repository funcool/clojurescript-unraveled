(require 'cljs.repl)
(require 'cljs.closure)
(require 'cljs.repl.browser)

(cljs.closure/build
 "src"
 {:output-to "main.js"
  :output-dir "out/"
  :source-map "main.js.map"
  :main 'myapp.core
  :optimizations :none})

(cljs.repl/repl
 (cljs.repl.browser/repl-env)
 :watch "src"
 :output-dir "out/")
