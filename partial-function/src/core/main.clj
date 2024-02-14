(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])
  
(defn -main
  "clojure doc here"
  [& _]
  (println (map (partial + 2) [1 2 3]) )
)
