(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])
        
(defn -main
  "clojure doc here"
  [& args]
  (println "Equality in Clojure")
  (prn (= 2 (+ 1 1)))
  (prn (= (str "fo" "od") "food"))
  (prn (= (float 314.0) (double 314.0)))
)
