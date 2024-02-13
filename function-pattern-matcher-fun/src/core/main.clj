(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

;; multiple arriety  
(defn greetings
  ([] "Hello World stranger!")
  ([name] (str "Hello world " name))
  ([first second] (str "Hello world " first " and " second))
)
  
;; cant have varargs [& names] and multiple arriety together on sam function   
(defn greetings-va
  ([& names] (str "Hello world folks : " (reduce str names " ")))
)  

(defn -main
  "clojure doc here"
  [& args]
  (prn (greetings))
  (prn (greetings "John Doe"))
  (prn (greetings "John Doe" "Marry"))
  (prn (greetings-va "John Doe" "Marry" "Scott"))
)
