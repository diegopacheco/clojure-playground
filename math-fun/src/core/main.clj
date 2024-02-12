(ns core.main
  (:gen-class))
 (import '[java.util.concurrent SynchronousQueue])
'(import Math/floor)

(defn -main
  "clojure doc here"
  [& _]
  (println (Math/floor 42.1))
  (println (Math/ceil (double 3/2)))
  (println (with-precision 10 :rounding FLOOR (/ 1 3M)))
)