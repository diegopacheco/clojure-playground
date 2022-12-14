;
; (load-file "main.clj")
;
(def myMap {
    "john" "Developer",
    "mary" "PM",
    "Travor" "Architect"
})

(def mysum 
    (reduce + [1,2,3,4,5,6,7,8,9,10])
)

(def x (
    map + '(1, 2, 3, 4, 5, 6, 7)
))

; (myInc #(* 3 %1) [1, 2, 3])
(defn myInc [f, xs]
   (map f xs)
)

(def y
    (filter #(even? %1)
        (map inc [1,2,3,4,5,6])
    )
)

(def a (atom 10))

(defn dowork [a]
   (println "atom a == ") 
   (print @a) 
   (swap! a inc)
   (println "atom a == ") 
   (print @a) 
   '(@a)
)

(def result 
    (apply max-key second {
        "metallica" 10
        "iron maiden" 9
        "motorhead" 8
    })
)