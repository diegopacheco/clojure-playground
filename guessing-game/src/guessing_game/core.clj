(ns guessing-game.core
  (:gen-class))

  (defn guess-game [upper-limit]
    (let [my-number (inc (rand-int upper-limit))]
      (println "I have number between 1 and " upper-limit ", guess it: ")
      (loop [times 1]
        (let [guess (Integer/parseInt (read-line))]
          (if (= guess my-number)
            (do
              (println "You have found it in " times " tries!")
              times)
  
            (do
              (cond
               (< guess my-number) (println "My number is bigger, guess again: ")
               (> guess my-number) (println "My number is smaller, guess again: "))
              (recur (inc times))))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (guess-game 3))
