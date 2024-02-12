(ns core.main
  (:gen-class))
  (import '[java.util.concurrent SynchronousQueue])

;; reciving and returning functions
(def bands [{:name "Brown Beaters"   :genre :rock}
            {:name "Sunday Sunshine" :genre :blues}
            {:name "Foolish Beaters" :genre :rock}
            {:name "Monday Blues"    :genre :blues}
            {:name "Friday Fewer"    :genre :blues}
            {:name "Saturday Stars"  :genre :jazz}
            {:name "Sunday Brunch"   :genre :jazz}])

(def rock-bands
  (filter
   (fn [band] (= :rock (:genre band)))
   bands))
(defn adder [x]
  (fn [a] (+ x a)))
(def add-five (adder 5))

;; filtering  
(def pets [{:name "Fluffykins" :type :cat}
           {:name "Sparky" :type :dog}
           {:name "Tibby" :type :dog}
           {:name "Al" :type :fish}
           {:name "Victor" :type :bear}])
(defn dog? [pet] (= :dog (:type pet)))
(defn filter-dogs [pets] (filter dog? pets))
  
(defn -main
  "clojure doc here"
  [& args]
  (println rock-bands)
  (println (add-five 100))
  (prn (filter-dogs pets))
)
