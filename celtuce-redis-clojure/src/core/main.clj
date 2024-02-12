(ns core.main
  (:gen-class)
)
(import '[java.util.concurrent SynchronousQueue])
(require '[celtuce.connector :as conn])
(require '[celtuce.commands :as redis])

(def connector (conn/redis-server "redis://localhost:6379"))
(def cmds (conn/commands-sync connector))

(defn -main
  "clojure doc here"
  [& args] 
  (prn "setting value in Redis. ")
  (redis/set cmds :foo "bar")

  (prn "Getting :foo from Redis. Result is: ")
  (prn (redis/get cmds :foo))

  (prn "Shutting down connection with Redis!")
  (conn/shutdown connector)
)
