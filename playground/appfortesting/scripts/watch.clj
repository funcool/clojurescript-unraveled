(require '[cljs.build.api :as b])

(b/watch (b/inputs "test" "src")
  {:main 'appfortesting.core_tests
   :target :nodejs
   :output-to "out/appfortesting.js"
   :output-dir "out"
   :verbose true})
