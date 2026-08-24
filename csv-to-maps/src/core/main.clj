(ns core.main
  (:require [clojure.string :as str])
  (:gen-class))

(def raw
  "name,role,salary\ndiego,architect,9000\nana,developer,7000\ncaio,sre,7500")

(defn parse [csv]
  (let [[header & rows] (str/split-lines csv)
        cols (map keyword (str/split header #","))]
    (map #(zipmap cols (str/split % #",")) rows)))

(defn -main
  [& args]
  (let [records (map #(update % :salary parse-long) (parse raw))]
    (println "Records:")
    (doseq [r records] (println " " r))
    (println "\nPayroll:" (reduce + (map :salary records)))
    (println "Roles:" (map :role records))
    (println "Above 7200:" (map :name (filter #(> (:salary %) 7200) records)))
    (println "By role:" (into {} (map (juxt :role :name) records)))
    (println "\nBack to CSV:")
    (println (str/join "\n"
                       (cons "name,role,salary"
                             (map #(str/join "," ((juxt :name :role :salary) %))
                                  (sort-by :salary > records)))))))
