(ns transducers.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn lets-do-it [] 
  (def xf (comp (filter odd?) (map inc)))
  (let [result (transduce xf + (range 6))]
    (str "Result is " result) ;; Result is 12
  )
)

(defroutes app-routes
  (GET "/" [] (lets-do-it))
  (route/not-found "Not Found")
)

(def app
  (wrap-defaults app-routes site-defaults))
