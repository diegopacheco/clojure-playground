(ns core.main
  (:require [clojure.data.json :as json])
  (:gen-class))

(def payload
  "{\"team\":\"platform\",\"members\":[{\"name\":\"diego\",\"commits\":42},
    {\"name\":\"ana\",\"commits\":17},{\"name\":\"caio\",\"commits\":93}]}")

(defn -main
  [& args]
  (let [parsed (json/read-str payload :key-fn keyword)
        members (:members parsed)
        total (reduce + (map :commits members))]
    (println "Team:" (:team parsed))
    (println "Members:" (count members))
    (println "Total commits:" total)
    (println "\nTop contributor:" (:name (apply max-key :commits members)))
    (let [enriched (map #(assoc % :share (format "%.1f%%"
                                                 (* 100.0 (/ (:commits %) total))))
                        members)]
      (println "\nBack to JSON:")
      (println (json/write-str {:team (:team parsed) :members enriched}
                              :indent true)))))
