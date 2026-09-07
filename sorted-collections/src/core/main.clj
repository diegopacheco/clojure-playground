(ns core.main
  (:gen-class))

(def scores (sorted-map "ana" 90 "diego" 75 "bruno" 88 "carla" 61))

(def by-length (sorted-set-by #(compare [(count %) %] [(count %2) %2])
                              "clj" "java" "go" "kotlin" "rust"))

(defn -main
  [& args]
  (println "Sorted map:" scores)
  (println "First entry:" (first scores))
  (println "Keys from 'b' to 'd':" (subseq scores >= "b" < "d"))
  (println "Reverse walk:" (rsubseq scores >= "b"))
  (println "\nSorted set by length then name:" by-length)
  (println "Shortest:" (first by-length))
  (println "Longest:" (last by-length))
  (let [desc (into (sorted-map-by #(compare (get scores %2) (get scores %))) scores)]
    (println "\nRanking by score:")
    (doseq [[n s] desc] (println " " n s)))
  (println "\nAfter dissoc bruno:" (dissoc scores "bruno")))
