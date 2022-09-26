(ns multi-arity-funcs.core
  (:gen-class))

(defn messenger
  ([]     (messenger "Hello world!"))
  ([msg]  (println (str "Hello : " msg))))
  
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (messenger)
  (messenger "Diego"))
