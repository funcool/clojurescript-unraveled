(require '[cljs.build.api :as b]
         '[cljs.closure]
         '[clojure.java.io :as io])

;; (extend-protocol cljs.closure/Inputs
;;   clojure.lang.PersistentVector
;;   (-paths [inputs]
;;     (println inputs)
;;     (mapv io/file inputs)))

(println "Building ...")

(let [start (System/nanoTime)]
  (b/build "test"
    {:main 'appfortesting.core-tests
     :output-to "out/appfortesting.js"
     :output-dir "out"
     :target :nodejs
     :verbose true})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))


