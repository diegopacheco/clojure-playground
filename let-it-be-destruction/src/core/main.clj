(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])
        
(defn -main
  "clojure doc here"
  [& args]
  (def my-line [[5 10] [10 20]])
  (let [p1 (first my-line)
        p2 (second my-line)
        x1 (first p1)
        y1 (second p1)
        x2 (first p2)
        y2 (second p2)]
    (println "Line from (" x1 "," y1 ") to (" x2 ", " y2 ")")))
