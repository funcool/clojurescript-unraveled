(require '[cljs.build.api :as b])

(b/watch (b/inputs "test" "src")
  {:main 'mytestingapp.core_tests
   :target :nodejs
   :output-to "out/mytestingapp.js"
   :output-dir "out"
   :verbose true})
