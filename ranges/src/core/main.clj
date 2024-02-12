(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

(defn get-ten [] (range 10))  

(defn -main
  "clojure doc here"
  [& args]
  (println "Range in Clojure")
  (prn (get-ten))
  (prn (range 20 25) )
)
