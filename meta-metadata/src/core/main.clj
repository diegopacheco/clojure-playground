(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

(defn ^{:tag String} shout [^{:tag String} s]
  (clojure.string/upper-case s)
)

(defn -main
  "clojure doc here"
  [& _]
  (println "upper case clojure")
  (prn (shout "Clojure"))
  (prn (meta #'shout))
)