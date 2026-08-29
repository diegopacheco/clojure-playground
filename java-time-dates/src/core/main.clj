(ns core.main
  (:import [java.time LocalDate Period]
           [java.time.format DateTimeFormatter])
  (:gen-class))

(def br-format (DateTimeFormatter/ofPattern "dd/MM/yyyy"))

(defn age-in [birth today]
  (.getYears (Period/between birth today)))

(defn -main
  [& args]
  (let [birth (LocalDate/parse "1984-03-17")
        today (LocalDate/of 2026 8 16)]
    (println "Birth:" (.format birth br-format))
    (println "Today:" (.format today br-format))
    (println "Age:" (age-in birth today))
    (println "Day of week:" (str (.getDayOfWeek birth)))
    (println "Leap year?" (.isLeapYear birth))
    (println "\nNext 5 anniversaries:")
    (doseq [y (range 1 6)]
      (let [d (.plusYears birth (+ (age-in birth today) y))]
        (println " " (.format d br-format) "->" (str (.getDayOfWeek d)))))
    (println "\nDays until end of year:"
             (.until today (LocalDate/of 2026 12 31) java.time.temporal.ChronoUnit/DAYS))))
