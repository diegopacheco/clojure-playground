(ns core.main
  (:gen-class))

(derive ::cat ::animal)
(derive ::dog ::animal)
(derive ::parrot ::animal)

(defmulti speak :type)

(defmethod speak ::cat [_]
  "Meow!")

(defmethod speak ::dog [_]
  "Woof!")

(defmethod speak ::animal [_]
  "Some animal sound")

(defn -main
  [& args]
  (println "Cat says:" (speak {:type ::cat}))
  (println "Dog says:" (speak {:type ::dog}))
  (println "Parrot says:" (speak {:type ::parrot}))
  (println "\nHierarchy:")
  (println "Is cat an animal?" (isa? ::cat ::animal))
  (println "Is dog an animal?" (isa? ::dog ::animal)))
