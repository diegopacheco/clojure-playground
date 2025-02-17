(ns core.main
  (:gen-class))

(defprotocol Animal
  (make-sound [this])
  (move [this distance]))

(deftype Cat [name color]
  Animal
  #_{:clj-kondo/ignore [:unused-binding]}
  (make-sound [this]
    (str name " says: Meow!"))
  #_{:clj-kondo/ignore [:unused-binding]}
  (move [this distance]
    (str name " the " color " cat walked " distance " meters")))  

(defn -main
  "protocol and type"
  #_{:clj-kondo/ignore [:unused-binding]}
  [& args]
  (let [my-cat (Cat. "Garfield" "orange")]
    (println (make-sound my-cat))
    (println (move my-cat 5))))
