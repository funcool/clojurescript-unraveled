(ns leapyears.test.main
  (:require [cljs.test :as t]
            [leapyears.util :as util]))

(enable-console-print!)

(defn async-leap?
  [year callback]
  (js/setImmediate #(callback (util/isLeap year))))

(t/deftest my-first-test
  (t/is (= 2 2)))

(t/deftest my-second-test
  (t/is (util/isLeap 1980))
  (t/is (not (util/isLeap 1981))))

(t/deftest my-async-test
  (t/async done
    (async-leap? 1980 (fn [result]
                        (t/is (true? result))
                        (done)))))

(set! *main-cli-fn* #(t/run-tests))

;; This extension is required for correctly set the return code
;; depending if the test passes or not.
(defmethod t/report [:cljs.test/default :end-run-tests]
  [m]
  (if (t/successful? m)
    (set! (.-exitCode js/process) 0)
    (set! (.-exitCode js/process) 1)))
