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

(defroutes app-routes
  (GET "/" [] (
               (time (def v (vrange 1000000)))    ;; 73.7 ms
               (time (def v2 (vrange2 1000000)))  ;; 19.7 ms
               "Hello World Clojure"
               ))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
