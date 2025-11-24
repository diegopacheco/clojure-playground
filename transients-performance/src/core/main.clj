(ns core.main
  (:gen-class))

(defn build-persistent [n]
  (time
   (persistent!
    (reduce conj! (transient []) (range n)))))

(defn build-normal [n]
  (time
   (reduce conj [] (range n))))

(defn -main
  [& args]
  (let [n 100000]
    (println "Building vector with" n "elements using transient:")
    (let [result1 (build-persistent n)]
      (println "Size:" (count result1)))
    (println "\nBuilding vector with" n "elements using persistent:")
    (let [result2 (build-normal n)]
      (println "Size:" (count result2)))))
