(require '[cljs.build.api :as b])

(b/build "src"
 {:output-to "main.js"
  :output-dir "out/"
  :source-map "main.js.map"
  :main 'myapp.core
  :verbose true
  :optimizations :none})
