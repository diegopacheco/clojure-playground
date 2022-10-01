(ns defmulti-basics.core
  (:gen-class))

(defmulti greeting
  (fn[x] (get x "language")))
  
(defmethod greeting "English" [params] "Hello!")
  
(defmethod greeting "French" [params] "Bonjour!")
  
;; default handling
(defmethod greeting :default [params]
  (throw (IllegalArgumentException. 
          (str "I don't know the " (get params "language") " language"))))
  
  ;then can use this like this:
(def english-map {"id" "1", "language" "English"})
(def french-map  {"id" "2", "language" "French"})
(def spanish-map {"id" "3", "language" "Spanish"})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (prn (greeting english-map))
  (prn (greeting french-map))
  ;; would give: Execution error (IllegalArgumentException) at defmulti-basics.core/eval179$fn (core.clj:14).
  ;; I don't know the  language
  ;; (greeting 0)
)

