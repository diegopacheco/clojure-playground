(ns main.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn get-me-string-baby []
  (map (fn [x] (str (.toUpperCase x) " ")) (.split "Clojure Java Lisp Take" " "))
)

(defroutes app-routes
  (GET "/" [] (get-me-string-baby))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
