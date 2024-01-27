(ns transients.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn vrange [n]
  (loop [i 0 v []]
    (if (< i n)
      (recur (inc i) (conj v i))
      v)))

(defn vrange2 [n]
  (loop [i 0 v (transient [])]
    (if (< i n)
      (recur (inc i) (conj! v i))
      (persistent! v))))

(defn bench []
  (time (def v (vrange 1000000)))    ;; 127.76 ms
  (time (def v2 (vrange2 1000000)))  ;; 67.14  ms
)

(defroutes app-routes
  (GET "/" [] (bench) "Hello World Clojure" )
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
