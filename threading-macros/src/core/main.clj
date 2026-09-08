(ns core.main
  (:require [clojure.string :as str])
  (:gen-class))

(def order {:id 7 :items [{:price 30 :qty 2} {:price 10 :qty 1}] :coupon "SAVE10"})

(defn -main
  [& args]
  (println "thread-first:"
           (-> order :items first :price (* 3)))
  (println "thread-last:"
           (->> order :items (map #(* (:price %) (:qty %))) (reduce +)))
  (println "as->:"
           (as-> order o
                 (:coupon o)
                 (str/lower-case o)
                 (str "coupon-" o "-applied")))
  (println "some-> on missing key:"
           (some-> order :shipping :address str/upper-case))
  (println "some->> on present key:"
           (some->> order :items (map :qty) (reduce +)))
  (println "cond->:"
           (cond-> {:total 70}
                   (:coupon order) (assoc :discount 7)
                   (> (count (:items order)) 1) (assoc :bulk true)
                   (nil? (:gift order)) (assoc :gift false))))
