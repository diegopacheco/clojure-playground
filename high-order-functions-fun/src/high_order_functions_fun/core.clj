(ns high-order-functions-fun.core
  (:gen-class))

(defn get-numbers [] 
  (lazy-seq (take 10 
    (range 10))))

(defn compute [col]
  (filter #(odd? %1) 
    (map inc col)))

(defn mycompose [f & col]
  (apply f col))

(defn -main
  "Doing some high-order functions here"
  [& args]
  (mycompose compute (get-numbers)))