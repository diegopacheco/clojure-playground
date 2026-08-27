(ns core.main
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:gen-class))

(def path "/tmp/clj-access.log")

(def content
  (str "200 /home\n404 /missing\n200 /about\n"
       "500 /checkout\n200 /home\n404 /ghost\n"))

(defn -main
  [& args]
  (spit path content)
  (println "Wrote" (count content) "bytes to" path)
  (with-open [rdr (io/reader path)]
    (let [lines (doall (line-seq rdr))
          parsed (map #(let [[code url] (str/split % #" ")] {:code code :url url}) lines)]
      (println "Lines:" (count lines))
      (println "Status counts:" (frequencies (map :code parsed)))
      (println "Errors:" (map :url (remove #(= "200" (:code %)) parsed)))))
  (spit path "500 /payment\n" :append true)
  (println "After append:" (count (str/split-lines (slurp path))) "lines")
  (io/delete-file path)
  (println "Deleted:" (not (.exists (io/file path)))))
