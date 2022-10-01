(ns records-basics.core
  (:gen-class))

(defrecord Person [first last email])

(def diego (Person. "Diego" "Pacheco" "my-email@email.com"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Records on: ")
  
  (prn (:first diego))
  (prn (:last diego))
  (prn (assoc diego :email "email@email.mail"))

  ;; why did not change here? because is immutable
  (prn diego)
  
  ;; Many interfaces on a Record Person :-) 
  (prn (map #(println %) (.getInterfaces Person)))
)
