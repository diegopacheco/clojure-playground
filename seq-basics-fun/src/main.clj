#!/usr/bin/env bb

(println (seq '(1)))   ;; (1)        - clojure.lang.PersistentList
(println (seq [1 2]))  ;; (1 2)      - clojure.lang.PersistentVector$ChunkedSeq
(println (seq "abc"))  ;; (\a \b \c) - clojure.lang.StringSeq


(println (first (seq '(1 2 3 4 5 6 7))))   ;; 1
(println (rest (seq '(1 2 3 4 5 6 7))))    ;; (2 3 4 5 6 7)
(println (cons 8 (seq '(1 2 3 4 5 6 7))))  ;; (8 2 3 4 5 6 7)