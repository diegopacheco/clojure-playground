(ns core.main
  (:gen-class))

(declare my-odd? my-even?)

(defn my-even? [n]
  (if (zero? n) true #(my-odd? (dec n))))

(defn my-odd? [n]
  (if (zero? n) false #(my-even? (dec n))))

(defn walk-states [state steps]
  (if (zero? steps)
    state
    #(walk-states (case state :idle :running :running :paused :paused :idle)
                  (dec steps))))

(defn -main
  [& args]
  (println "trampoline my-even? 100000:" (trampoline my-even? 100000))
  (println "trampoline my-odd? 99999:" (trampoline my-odd? 99999))
  (println "state after 7 steps:" (trampoline walk-states :idle 7))
  (println "state after 300000 steps:" (trampoline walk-states :idle 300000))
  (println "\nCalling my-even? directly returns a thunk:")
  (println (fn? (my-even? 10))))
