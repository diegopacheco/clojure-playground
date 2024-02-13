(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

(defn get-last-of3 [sequence]
   (let [[_ _ last] sequence] last)
)
  
(defn get-first [sequence] 
  (let [[first _ _] sequence] first)
)
  
(defn -main
  "clojure doc here"
  [& _]
  (println "Let me show power of let")
  (prn (get-last-of3 [1 2 3]))          ;; get 3rd position
  (prn (get-last-of3 [1 2 3 4 5 6]))    ;; get 3rd position
  (prn (get-first    [1 2 3]))          ;; get 1st position
  (prn (get-first    [1 2 3 4 5 6]))    ;; get 1st position
)
