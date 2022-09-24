(ns clojure-basics.loops
  (:gen-class))

;; Basic IF in While in Clojure
(defn looping []
  (def y (atom 1))
  (while (< @y 9)
    (do
      (println @y)
      (swap! y inc)))
  (str "done. loop over 8 items"))
