(ns clojure-basics.loops
  (:gen-class))

;; Basic IF in While in Clojure
(defn cljwhile [] ((def x (atom 1))
                   (while (<= @x 10)
                     (do
                       (println @x)
                       (swap! x inc)))
                   "printed 10 items"))