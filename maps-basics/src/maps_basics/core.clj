(ns maps-basics.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  ;;
  ;; Sets
  ;; 
  (def players #{"Alice", "Bob", "Kelly"})
  (prn  (contains? players "Kelly"))

  (def new-players ["Tim" "Sue" "Greg"])
  (def players (into players new-players))

  (def players (conj players "Fred"))
  (prn players)

  ;;
  ;; Maps
  ;;
  (def scores {"Fred"  1400
               "Bob"   1240
               "Angela" 1024})
  (def scores (assoc scores "Sally" 0))
  (def scores (dissoc scores "Bob"))
  
  (prn (get scores "Angela"))  
  (prn scores)
)
