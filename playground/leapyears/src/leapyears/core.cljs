(ns leapyears.core
  (:require [goog.dom :as dom]
            [goog.events :as events]
            [cuerdas.core :as str]
            [leapyears.util :as util]
            [cljs.reader :refer (read-string)]))

(enable-console-print!)

(def input (dom/getElement "year"))
(def result (dom/getElement "result"))

(defn leap?
  [year]
  (util/isLeap year))

(defn on-change
  [event]
  (let [target (.-target event)
        value (read-string (.-value target))]

    (if (str/blank? value)
      (set! (.-innerHTML result) "----")
      (if (leap? value)
        (set! (.-innerHTML result) "YES")
        (set! (.-innerHTML result) "NO")))))

(events/listen input "keyup" on-change)
