(ns core.main
  (:gen-class))

(defn slow-fib [n]
  (if (< n 2) n (+ (slow-fib (- n 1)) (slow-fib (- n 2)))))

(def fast-fib
  (memoize (fn [n] (if (< n 2) n (+ (fast-fib (- n 1)) (fast-fib (- n 2)))))))

(defn elapsed-ms [f n]
  (let [start (System/currentTimeMillis)
        v (f n)]
    [v (- (System/currentTimeMillis) start)]))

(defn -main
  [& args]
  (let [[v1 t1] (elapsed-ms slow-fib 32)
        [v2 t2] (elapsed-ms fast-fib 32)
        [v3 t3] (elapsed-ms fast-fib 32)]
    (println "slow-fib 32 =" v1 "in" t1 "ms")
    (println "fast-fib 32 =" v2 "in" t2 "ms")
    (println "fast-fib 32 cached =" v3 "in" t3 "ms")
    (println "\nfast-fib 90 =" (fast-fib 90))
    (println "memoized calls are pure lookups after the first pass")))
