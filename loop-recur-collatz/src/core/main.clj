(ns core.main
  (:gen-class))

(defn next-term [x]
  (if (even? x) (quot x 2) (inc (* 3 x))))

(defn collatz-path [n]
  (loop [x n path [n]]
    (if (= x 1) path (recur (next-term x) (conj path (next-term x))))))

(defn steps [n]
  (loop [x n c 0]
    (if (= x 1) c (recur (next-term x) (inc c)))))

(defn -main
  [& args]
  (println "Path for 27:" (collatz-path 27))
  (println "Steps for 27:" (steps 27))
  (println "\nSteps for 1..15:")
  (doseq [n (range 1 16)]
    (println (format " %2d -> %2d steps" n (steps n))))
  (let [worst (loop [n 2 best [1 0]]
                (if (> n 10000)
                  best
                  (recur (inc n) (max-key second best [n (steps n)]))))]
    (println "\nLongest chain under 10000:" worst)))
