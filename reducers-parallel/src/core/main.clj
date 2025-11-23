(ns core.main
  (:require [clojure.core.reducers :as r])
  (:gen-class))

(defn -main
  [& args]
  (let [numbers (vec (range 1 1000000))]
    (println "Using regular map/reduce:")
    (time
     (let [result (->> numbers
                       (map inc)
                       (filter even?)
                       (reduce +))]
       (println "Result:" result)))
    (println "\nUsing reducers:")
    (time
     (let [result (->> numbers
                       (r/map inc)
                       (r/filter even?)
                       (r/fold +))]
       (println "Result:" result)))))
