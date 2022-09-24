(ns clojure-basics.core
  (:use [clojure-basics.loops])
  (:gen-class))

;; Basic IF in clojure
(defn cljif [] (if (= 2 2)
                 "Values are equal"
                 "Values are not equal"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [result (cljif)]
    (println result)))