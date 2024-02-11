
(ns is_blank_string_fun.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn blank? [str]
  (every? #(Character/isWhitespace %) str)
)

(defroutes app-routes
  (GET "/" [] (str "Clojure blank? " (blank? "Clojure")) )
  (route/not-found "Not Found")
)

(def app
  (wrap-defaults app-routes site-defaults))