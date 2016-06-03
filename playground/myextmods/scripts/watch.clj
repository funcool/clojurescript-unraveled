(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'myextmods.core
   :output-to "out/myextmods.js"
   :output-dir "out"})
