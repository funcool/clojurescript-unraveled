(require '[cljs.build.api :as b]
         '[cljs.closure]
         '[clojure.java.io :as io])

(println "Building ...")

(let [start (System/nanoTime)]
  (b/build "test"
    {:main 'mytestingapp.core-tests
     :output-to "out/mytestingapp.js"
     :output-dir "out"
     :target :nodejs
     :verbose true})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))


