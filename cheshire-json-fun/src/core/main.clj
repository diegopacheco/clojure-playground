(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

(require '[cheshire.core :refer :all :as cheshire])  
  
(defn -main
  "clojure doc here"
  [& args]
  (println "Cheshire Json")
  (prn (cheshire/generate-string {:foo "bar" :baz 5}))
  (prn (cheshire/parse-string "{\"foo\":\"bar\"}" true))
)
