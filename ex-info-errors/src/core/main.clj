(ns core.main
  (:gen-class))

(defn withdraw [balance amount]
  (when (neg? amount)
    (throw (ex-info "Amount must be positive" {:type :validation :amount amount})))
  (when (> amount balance)
    (throw (ex-info "Insufficient funds"
                    {:type :business :balance balance :requested amount})))
  (- balance amount))

(defn safe-withdraw [balance amount]
  (try
    {:ok (withdraw balance amount)}
    (catch clojure.lang.ExceptionInfo e
      {:error (ex-message e) :data (ex-data e)})
    (catch Exception e
      {:error (.getMessage e)})
    (finally
      (println "  audit logged for amount" amount))))

(defn -main
  [& args]
  (doseq [amount [50 -10 500]]
    (println "Withdraw" amount)
    (println "  =>" (safe-withdraw 100 amount)))
  (println "\nCause chain:"
           (ex-message (ex-cause (ex-info "outer" {} (ex-info "inner" {}))))))
