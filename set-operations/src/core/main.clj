(ns core.main
  (:require [clojure.set :as set])
  (:gen-class))

(def backend #{"diego" "ana" "caio"})
(def oncall #{"ana" "bruno"})

(def devs #{{:name "diego" :team :platform}
            {:name "ana" :team :data}})
(def teams #{{:team :platform :floor 3} {:team :data :floor 5}})

(defn -main
  [& args]
  (println "Union:" (set/union backend oncall))
  (println "Intersection:" (set/intersection backend oncall))
  (println "Difference:" (set/difference backend oncall))
  (println "Subset?" (set/subset? #{"ana"} backend))
  (println "Superset?" (set/superset? backend #{"ana" "caio"}))
  (println "\nRelational join:" (set/join devs teams))
  (println "Projection:" (set/project devs [:name]))
  (println "Rename:" (set/rename devs {:name :dev}))
  (println "Index by team:" (set/index devs [:team]))
  (println "\nSelect data team:" (set/select #(= :data (:team %)) devs)))
