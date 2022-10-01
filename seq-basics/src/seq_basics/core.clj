(ns seq-basics.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def s (seq [1 2]))
  (prn s)

  ;; Convert map list of into vectors
  (prn (seq {:key1 "value1" :key2 "value2"}))

  ;; everyboddy is not empty right? yes.
  (prn (every? not-empty ["1" [1] '(1) {:1 1} #{1}]))
)
