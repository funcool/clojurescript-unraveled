(ns myapp.core
 (:require [clojure.browser.repl :as repl]))

(defonce conn
  (repl/connect "http://localhost:9001/repl"))

(enable-console-print!)

(println "Hello, world!")
