(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

(defn count-down [result i]
  (if (zero? i)
      result
      (recur (conj result i) (dec i))
  )
)  

(defn -main
  "clojure doc here"
  [& _]
  (println "Control flow count down ")
  (prn (count-down [] 10))                          ;; [10 9 8 7 6 5 4 3 2 1]
  (prn (into [] (take 10 (iterate dec 10))))        ;; [10 9 8 7 6 5 4 3 2 1]
  (prn (into [] (drop-last (reverse (range 11)))))  ;; [10 9 8 7 6 5 4 3 2 1]
  (prn (vec (reverse (range 1 11))))                ;; [10 9 8 7 6 5 4 3 2 1]
)
