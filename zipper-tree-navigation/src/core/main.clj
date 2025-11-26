(ns core.main
  (:require [clojure.zip :as z])
  (:gen-class))

(defn -main
  [& args]
  (let [tree [:root [:a 1 2] [:b 3 4]]
        zipper (z/vector-zip tree)]
    (println "Original tree:" tree)
    (println "\nNavigating:")
    (println "Root:" (z/node zipper))
    (println "Down:" (z/node (z/down zipper)))
    (println "Right:" (z/node (z/right (z/down zipper))))
    (println "\nModifying tree:")
    (let [modified (-> zipper
                       z/down
                       z/right
                       (z/replace [:modified 99])
                       z/root)]
      (println "Modified tree:" modified))))
