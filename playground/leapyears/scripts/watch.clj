(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'leapyears.core
   :output-to "out/leapyears.js"
   :output-dir "out"})
