(defn add [x y]
  (+ x y))

(defn mul [x y]
  (* x y))

(defn div [x y]
  (/ x y))

(defn sub [x y]
  (- x y))

#_{:clj-kondo/ignore [:missing-else-branch :clojure-lsp/unused-public-var]}
(defn run-with-strategy [op x y]
  (case op
     "+" (add x y)  
     "*" (mul x y) 
     "-" (sub x y)
     "/" (div x y)
     ""  (add x y)
  )
)