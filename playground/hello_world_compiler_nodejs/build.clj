(require 'cljs.closure)

(cljs.closure/build "src"
 {:output-to "main.js"
  :main 'myapp.core
  :target :nodejs})
