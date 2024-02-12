(ns default.main
  (:gen-class))

(import '[java.util.concurrent SynchronousQueue])
        
(defn relay [x i]
  (when (:next x)
    (send (:next x) relay i))
  (when (and (zero? i) (:report-queue x))
    (.put (:report-queue x) i))
  x)

(defn run [m n]
  (let [q (new SynchronousQueue)
        hd (reduce (fn [next _] (agent {:next next}))
                   (agent {:report-queue q}) (range (dec m)))]
    (doseq [i (reverse (range n))]
      (send hd relay i))
    (.take q)))

(defn -main
  "clojure doc here"
  [& args]
  ; 1 million message sends ~ "Elapsed time: 1356.018773 msecs"
  (time (run 1000 1000))
)