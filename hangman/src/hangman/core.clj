(ns hangman.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn is_char_in_words?
  "Is the char in the words?"
  [ch words]
  (if (= ch "")
    false
    (> (.indexOf words ch) -1)))

(defn char_to_draw
  "Chooses whether to draw a _ or a char"
  [ch guesses]
  (if (is_char_in_words? ch guesses)
    (str ch " ")
    (str "_ ")))

(defn get_board
  "Gets the current board"
  [words guesses]
  (str/join (map #(char_to_draw (str %) guesses) (seq words))))

(defn draw_board
  "Draws the current board"
  [words guesses]
  (println (get_board words guesses)))

(defn have-a-go
  "Has a go"
  [words guesses chances]
  (draw_board words (str/join guesses))
  (if (is_char_in_words? "_" (get_board words guesses))
    (if (= 0 chances)
      (println "FAIL!!!!")
      (do
        (println (str "Guesses: " guesses))
        (println (str "Chances: " chances))
        (println "Enter your guess:")
        (let [guess (read-line)]

          (let [new-guesses (conj guesses guess)]
            (if (is_char_in_words? guess words)
              (have-a-go words new-guesses chances)
              (have-a-go words new-guesses (- chances 1)))))))

    (println "AWESOME!")))

(defn game
  "Runs a game of hangman"
  []
  (do
    (print "Enter your words: ")
    (flush)
    (have-a-go (read-line) [] 5)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (game))