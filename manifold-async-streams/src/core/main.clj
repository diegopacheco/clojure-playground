(ns core.main
  (:require [manifold.deferred :as d]
            [manifold.stream :as s])
  (:gen-class))

(defn -main
  [& args]
  (println "Deferred values:")
  (let [deferred (d/deferred)]
    (d/on-realized deferred
                   (fn [x] (println "Success:" x))
                   (fn [x] (println "Error:" x)))
    (d/success! deferred 42))

  (println "\nStreams:")
  (let [stream (s/stream)]
    (s/consume #(println "Received:" %) stream)
    (s/put! stream 1)
    (s/put! stream 2)
    (s/put! stream 3)
    (s/close! stream)
    (Thread/sleep 100))

  (println "\nChain:")
  @(d/chain (d/success-deferred 10)
            #(* % 2)
            #(+ % 5)
            #(do (println "Final result:" %) %)))
