(require 'cljs.closure)

(cljs.closure/watch "src"
 {:output-to "main.js"
  :output-dir "out/"
  :source-map "main.js.map"
  :main 'myapp.core
  :optimizations :none})
