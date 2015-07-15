(ns appfortesting.core)

(defn leap?
  [year]
  (and (zero? (js-mod year 4))
       (pos? (js-mod year 100))
       (pos? (js-mod year 400))))

(defn async-leap?
  [year callback]
  (js/setImmediate
   (fn []
     (let [result (and (zero? (js-mod year 4))
                       (pos? (js-mod year 100))
                       (pos? (js-mod year 400)))]
       (callback result)))))
