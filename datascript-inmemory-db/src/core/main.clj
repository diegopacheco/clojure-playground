(ns core.main
  (:require [datascript.core :as d])
  (:gen-class))

(defn -main
  [& args]
  (let [schema {:person/name {:db/unique :db.unique/identity}
                :person/age {}
                :person/friends {:db/cardinality :db.cardinality/many
                                 :db/valueType :db.type/ref}}
        conn (d/create-conn schema)]

    (d/transact! conn [{:person/name "Diego"
                        :person/age 30}
                       {:person/name "John"
                        :person/age 25}
                       {:person/name "Mary"
                        :person/age 28}])

    (println "All people:")
    (println (d/q '[:find ?name ?age
                    :where
                    [?e :person/name ?name]
                    [?e :person/age ?age]]
                  @conn))

    (println "\nPeople over 27:")
    (println (d/q '[:find ?name
                    :where
                    [?e :person/name ?name]
                    [?e :person/age ?age]
                    [(> ?age 27)]]
                  @conn))))
