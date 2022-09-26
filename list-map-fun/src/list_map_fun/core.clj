(ns list-map-fun.core
  (:gen-class))

(def scenes [{:subject  "Frankie"
              :action   "say"
              :object   "relax"}
             {:subject  "Lucy"
              :action   "❤s"
              :object   "Clojure"}
             {:subject  "Rich"
              :action   "tries"
              :object   "a new conditioner"}])

(defn people-in-scenes [scenes]
  (->> scenes
       (map :subject)
       (interpose ", ")
       (reduce str)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "People:" (people-in-scenes scenes)))
