(ns clojure-basics.core
  (:use [clojure-basics.loops])
  (:gen-class))

;; Generic function to call any function and print the result
(defn call-n-print [f args] ((let [result (apply f args)]
                        (println result))))

;; Basic IF in clojure
(defn cljif [] (if (= 2 2)
                 "Values are equal"
                 "Values are not equal"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (call-n-print cljif []))