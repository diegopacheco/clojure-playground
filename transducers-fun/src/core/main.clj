(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

(def xf
  (comp
   (filter odd?)
   (map inc)
   (take 5)))

(def xf2 (comp (filter odd?) (map inc)))  

(defn -main
  "clojure doc here"
  [& _]
  (def result (->> (range 1 10)
                   (filter odd?)
                   (map inc)
                   (take 5)))
  (println result)

  (println (transduce xf + (range 5)))

  (println (transduce xf2 + (range 2)))
)
