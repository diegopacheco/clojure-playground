(ns core.main
  (:require [clojure.spec.alpha :as s])
  (:gen-class))

(s/def ::name string?)
(s/def ::age (s/and int? #(> % 0)))
(s/def ::email (s/and string? #(re-matches #".+@.+\..+" %)))
(s/def ::person (s/keys :req [::name ::age ::email]))

(defn -main
  [& args]
  (let [valid-person {::name "Diego" ::age 30 ::email "diego@test.com"}
        invalid-person {::name "John" ::age -5 ::email "invalid"}]
    (println "Valid person:")
    (println (s/valid? ::person valid-person))
    (println (s/explain-str ::person valid-person))
    (println "\nInvalid person:")
    (println (s/valid? ::person invalid-person))
    (println (s/explain-str ::person invalid-person))))
