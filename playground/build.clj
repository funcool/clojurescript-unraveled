(require 'cljs.closure)

(cljs.closure/build "src"
 {:output-to "out/main.js"
  :main 'myapp.core
  :target :nodejs})
