#!/usr/bin/env bb

(println (str "Clojure Agents"))

(defn increment [curr num] (+ curr num))

(def smith (agent 1))

(send smith increment 5)
(send smith increment 5)
(print @smith)            ;; sometimes you will get 5 others will get 11 (is async)