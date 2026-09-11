(ns core.main
  (:require [clojure.string :as str])
  (:gen-class))

(def text
  "Clojure is a Lisp. Clojure runs on the JVM and the JVM runs everywhere.
   Lisp code is data and data is code in Clojure.")

(def stop-words #{"is" "a" "on" "the" "and" "in"})

(defn words [s]
  (re-seq #"[a-z]+" (str/lower-case s)))

(defn -main
  [& args]
  (let [all (words text)
        freq (frequencies (remove stop-words all))
        top (take 5 (sort-by (juxt (comp - val) key) freq))]
    (println "Total words:" (count all))
    (println "Distinct words:" (count (set all)))
    (println "Stop words removed:" (- (count all) (count (remove stop-words all))))
    (println "\nTop 5:")
    (doseq [[w n] top]
      (println (format " %-12s %s" w (str/join (repeat n "*")))))
    (println "\nLongest word:" (apply max-key count all))
    (println "Words seen once:" (sort (map key (filter #(= 1 (val %)) freq))))))
