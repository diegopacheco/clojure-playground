(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

(def names (ref []))

(defn change [newname]
  (dosync
   (alter names conj newname)))

(defn -main
  "clojure doc here"
  [& _]
  (change "John")
  (change "Marry")
  (change "Peter")
  (println @names)
)
