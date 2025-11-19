(ns core.main
  (:require [clojure.core.logic :as l]
            [clojure.core.logic.pldb :as pldb])
  (:gen-class))

(pldb/db-rel parent p c)

(def family-db
  (pldb/db
   [parent :john :mary]
   [parent :john :tom]
   [parent :mary :susan]))

(defn grandparent [g c]
  (l/fresh [p]
    (parent g p)
    (parent p c)))

(defn -main
  [& args]
  (pldb/with-db family-db
    (println "Parents of mary:")
    (println (l/run* [q] (parent q :mary)))
    (println "\nChildren of john:")
    (println (l/run* [q] (parent :john q)))
    (println "\nGrandparents of susan:")
    (println (l/run* [q] (grandparent q :susan)))))
