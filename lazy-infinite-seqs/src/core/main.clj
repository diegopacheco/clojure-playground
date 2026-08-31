(ns core.main
  (:gen-class))

(defn fibs []
  ((fn step [a b] (lazy-seq (cons a (step b (+ a b))))) 0 1))

(def powers-of-two (iterate #(* 2 %) 1))

(defn -main
  [& args]
  (println "First 10 fibs:" (take 10 (fibs)))
  (println "Fibs under 100:" (take-while #(< % 100) (fibs)))
  (println "Powers of two:" (take 8 powers-of-two))
  (println "Cycling:" (take 7 (cycle [:red :green :blue])))
  (println "Repeating:" (take 4 (repeat "clj")))
  (println "Repeatedly:" (take 3 (repeatedly #(count "lazy"))))
  (println "Dropping while small:" (take 3 (drop-while #(< % 50) (fibs))))
  (let [realized (atom 0)
        tracked (map (fn [x] (swap! realized inc) x) (range 1000))]
    (doall (take 5 tracked))
    (println "\nOnly realized (chunked):" @realized)))
