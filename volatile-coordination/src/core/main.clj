(ns core.main
  (:gen-class))

(defn -main
  [& args]
  (let [v (volatile! 0)
        a (atom 0)]
    (println "Initial volatile:" @v)
    (println "Initial atom:" @a)
    (vswap! v + 10)
    (swap! a + 10)
    (println "\nAfter adding 10:")
    (println "Volatile:" @v)
    (println "Atom:" @a)
    (vreset! v 100)
    (reset! a 100)
    (println "\nAfter reset to 100:")
    (println "Volatile:" @v)
    (println "Atom:" @a)))
