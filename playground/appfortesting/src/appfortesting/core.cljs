(ns appfortesting.core)

(defn leap?
  [year]
  (or (zero? (js-mod year 400))
      (and (pos? (js-mod year 100))
           (zero? (js-mod year 4)))))

(defn async-leap?
  [year callback]
  (js/setImmediate
   (fn []
     (let [result (or (zero? (js-mod year 400))
                      (and (pos? (js-mod year 100))
                           (zero? (js-mod year 4))))]
       (callback result)))))
