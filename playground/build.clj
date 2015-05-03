(require 'cljs.closure)

(cljs.closure/build "src"
 {:output-to "main.js"
  :output-dir "out/"
  :source-map "main.js.map"
  :main 'myapp.core
  :optimizations :whitespace})
