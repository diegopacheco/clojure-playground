(ns core.main
  (:gen-class))

(def empty-queue clojure.lang.PersistentQueue/EMPTY)

(defn enqueue-all [q items] (reduce conj q items))

(defn drain [q]
  (loop [q q acc []]
    (if (seq q) (recur (pop q) (conj acc (peek q))) acc)))

(defn -main
  [& args]
  (let [q (enqueue-all empty-queue [:build :test :package :deploy])]
    (println "Queue size:" (count q))
    (println "Front:" (peek q))
    (println "After pop front:" (peek (pop q)))
    (println "As seq:" (seq q))
    (println "\nFIFO drain:" (drain q))
    (println "LIFO for comparison:" (drain (into '() [:build :test :package :deploy])))
    (let [q2 (conj (pop q) :rollback)]
      (println "\nAfter pop + enqueue rollback:" (seq q2))
      (println "Original untouched:" (seq q)))
    (println "\nEmpty queue peek:" (peek empty-queue))
    (println "Empty queue pop stays empty:" (seq (pop (conj empty-queue :x))))))
