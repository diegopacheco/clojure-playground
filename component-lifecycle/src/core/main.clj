(ns core.main
  (:require [com.stuartsierra.component :as component])
  (:gen-class))

(defrecord Database [host port connection]
  component/Lifecycle
  (start [this]
    (println "Starting database connection to" host ":" port)
    (assoc this :connection {:host host :port port :status :connected}))
  (stop [this]
    (println "Stopping database connection")
    (assoc this :connection nil)))

(defrecord WebServer [port database server]
  component/Lifecycle
  (start [this]
    (println "Starting web server on port" port)
    (println "Database connection:" (:connection database))
    (assoc this :server {:port port :running true}))
  (stop [this]
    (println "Stopping web server")
    (assoc this :server nil)))

(defn create-system []
  (component/system-map
   :database (map->Database {:host "localhost" :port 5432})
   :web-server (component/using
                (map->WebServer {:port 8080})
                [:database])))

(defn -main
  [& args]
  (let [system (create-system)]
    (println "Starting system:")
    (let [started (component/start system)]
      (println "\nSystem started!")
      (println "\nStopping system:")
      (component/stop started)
      (println "\nSystem stopped!"))))
