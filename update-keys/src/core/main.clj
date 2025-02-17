(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])
        
(defn -main
  "clojure doc here"
  [& args]
  (prn (update-keys {"foo" 42 "bar" 1337} keyword))
  (prn (update-keys {:foo 42 :bar 1337} name))
  )
