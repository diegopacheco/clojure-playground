(ns core.main
  (:gen-class))

(defmacro unless [test & body]
  `(if ~test nil (do ~@body)))

(defmacro timed [label & body]
  `(let [start# (System/nanoTime)
         result# (do ~@body)]
     (println ~label "took" (quot (- (System/nanoTime) start#) 1000) "us")
     result#))

(defmacro infix [[a op b]]
  (list op a b))

(defn -main
  [& args]
  (unless false (println "unless runs when test is false"))
  (unless true (println "this never prints"))
  (println "infix expansion:" (macroexpand-1 '(core.main/infix (3 + 4))))
  (println "infix result:" (infix (3 + 4)))
  (println "timed result:" (timed "sum-1M" (reduce + (range 1000000))))
  (println "unless expansion:" (macroexpand-1 '(core.main/unless x (println "hi")))))
