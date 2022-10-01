(ns atom-basics.core
  (:gen-class))

(defn fun []
  (def a (atom 1))
  (compare-and-set! a 1 99)
  (swap! a inc)
  (println @a))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "atom a should be 100 ")
  (fun))
