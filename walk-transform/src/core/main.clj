(ns core.main
  (:require [clojure.walk :as w])
  (:gen-class))

(def config
  {"server" {"host" "localhost" "port" 8080}
   "pools" [{"name" "db" "size" 10} {"name" "http" "size" 4}]})

(defn -main
  [& args]
  (println "Raw:" config)
  (let [kw (w/keywordize-keys config)]
    (println "\nKeywordized:" kw)
    (println "Back to strings:" (w/stringify-keys kw))
    (println "\nDoubled every number:"
             (w/postwalk #(if (number? %) (* 2 %) %) kw))
    (println "\nAll leaf values:"
             (let [acc (atom [])]
               (w/postwalk #(do (when-not (coll? %) (swap! acc conj %)) %) kw)
               @acc))
    (println "\nPrewalk pruning before descending:"
             (w/prewalk #(if (and (map? %) (:host %)) :redacted %) kw))
    (println "\nTree seq node count:" (count (tree-seq coll? seq kw)))))
