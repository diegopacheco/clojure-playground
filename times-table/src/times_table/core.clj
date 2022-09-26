(ns times-table.core
  (:gen-class))

(defn times-table [n]
  (map #(* n %1) (range 11)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [result (times-table 9)]
    (println (str "Times table 9: " (into '() result)))))