(ns core.main
  (:gen-class))

(def suits [:hearts :spades])
(def ranks [:ace :king :queen])

(defn -main
  [& args]
  (println "Deck:")
  (doseq [c (for [s suits r ranks] [r s])]
    (println " " c))
  (println "\nPythagorean triples with a and b under 25:")
  (println (for [a (range 1 25)
                 b (range a 25)
                 :let [c2 (+ (* a a) (* b b))
                       c (int (Math/sqrt c2))]
                 :when (= c2 (* c c))
                 :while (< b 25)]
             [a b c]))
  (println "\nPairs while under limit:")
  (println (for [x (range 10) :while (< x 5) :when (odd? x)] (* x x)))
  (println "\nNested with index:")
  (println (for [[i word] (map-indexed vector ["clojure" "is" "fun"])]
             (str i ":" word))))
