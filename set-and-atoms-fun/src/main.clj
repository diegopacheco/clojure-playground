#!/usr/bin/env bb

;; Create a set and add Diego likes Clojure to set
(println (conj #{} "Diego" "likes" "Clojure" ))

;; create set with atom for logged users
(def users (atom #{}))

;; added users into the atom/set
(defn login [user]
  (swap! users conj user)
)

(login "Diego")
(login "Rich")

;; show all users
(print @users)