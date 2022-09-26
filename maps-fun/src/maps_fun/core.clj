(ns maps-fun.core
  (:gen-class))

(def scores {"Fred"  1400
             "Bob"   1240
             "Angela" 1024})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (assoc scores "Sally" 0)
  (assoc scores "Bob" 0)
  (prn (get scores "Angela"))
  (prn (contains? scores "Fred"))
  (prn (keys scores))
  (prn (vals scores))
)
