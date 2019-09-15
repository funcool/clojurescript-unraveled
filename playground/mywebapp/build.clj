(require '[cljs.build.api :as b])

(b/build "src" {:output-to "main.js"
                :source-map true
                :output-dir "out/"
                :main 'mywebapp.core
                :verbose true
                :optimizations :none})
