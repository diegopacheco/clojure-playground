(ns core.main
  (:gen-class))

(def ^:dynamic *log-level* :info)
(def ^:dynamic *tenant* "default")

(defn log [level msg]
  (when-not (and (= level :debug) (= *log-level* :info))
    (println (str "[" *tenant* "/" (name level) "] " msg))))

(defn charge [amount]
  (log :debug (str "computing tax for " amount))
  (str "charged " amount " on " *tenant*))

(defn -main
  [& args]
  (log :info "root binding in place")
  (charge 10)
  (binding [*log-level* :debug *tenant* "acme"]
    (log :info "inside binding")
    (println (charge 20)))
  (log :debug "suppressed again")
  (println "\nRoot value restored:" *log-level* *tenant*)
  (with-redefs [charge (fn [a] (str "stubbed " a))]
    (println "with-redefs:" (charge 99)))
  (println "after redef:" (charge 99)))
