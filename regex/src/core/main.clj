(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])
        
(defn -main
  "clojure doc here"
  [& _]
  (println (re-seq #"[0-9]+" "abs123def345ghi567"))
  (println (re-find #"([-+]?[0-9]+)/([0-9]+)" "22/7"))
)
