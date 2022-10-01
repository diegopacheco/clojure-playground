(ns ref-basics.core
  (:gen-class))

(defn fun []
  (def r (ref '(1 2 3 4 5 6)))
  (dosync (ref-set r '(6 5 4 3 2 1)))
  (prn (deref r)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print "ref r should be (6 5 4 3 2 1) == ")
  (fun))
