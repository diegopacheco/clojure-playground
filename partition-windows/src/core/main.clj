(ns core.main
  (:gen-class))

(def temps [18 19 21 24 27 26 22 20 19 17])

(defn moving-average [n coll]
  (map #(double (/ (reduce + %) n)) (partition n 1 coll)))

(defn -main
  [& args]
  (println "Readings:" temps)
  (println "\nFixed chunks of 3:" (partition 3 temps))
  (println "Chunks of 3 with leftovers:" (partition-all 3 temps))
  (println "Sliding windows of 3:" (take 3 (partition 3 1 temps)))
  (println "Stepping by 4:" (partition 2 4 temps))
  (println "\n3-point moving average:" (moving-average 3 temps))
  (println "\nRuns of rising/falling:")
  (doseq [run (partition-by #(apply < %) (partition 2 1 temps))]
    (println " " (if (apply < (first run)) "rising" "falling") (count run)))
  (println "\nSplit at peak:" (split-with #(< % 27) temps)))
