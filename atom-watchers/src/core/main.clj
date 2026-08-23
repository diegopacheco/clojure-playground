(ns core.main
  (:gen-class))

(def account (atom 100))
(def history (atom []))

(defn -main
  [& args]
  (set-validator! account #(>= % 0))
  (add-watch account :audit
             (fn [k _ old new]
               (swap! history conj [old new])
               (println " watch" k ":" old "->" new)))
  (println "Deposits and withdrawals:")
  (swap! account + 50)
  (swap! account - 30)
  (println "\nRejected by validator:"
           (try (swap! account - 500)
                (catch IllegalStateException e (.getMessage e))))
  (println "Balance still:" @account)
  (remove-watch account :audit)
  (swap! account inc)
  (println "\nAfter remove-watch balance:" @account)
  (println "History:" @history)
  (println "compare-and-set!:" (compare-and-set! account 121 200) @account))
