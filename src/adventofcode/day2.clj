(ns adventofcode.day2
  (:require [adventofcode.utils :as utils])
  (:gen-class))

(defn main-
  []
  (println "Day 2: 1202 Program Alarm"))

;; IntCode program rules
;; Opcode 1 adds together numbers read from two positions and stores the result in a third position
;; Opcode 2 - same as opcode 1 but mults instead of add
;; Opcode 99 Halts the program

(defn intcode [pair]
  (let [noun (first pair)
        verb (second pair)
        inp (utils/convert-num (utils/get-input #","))]
    (loop [program (utils/inplace 2 verb (utils/inplace 1 noun inp))
           curpos 0]
      (let [ops (utils/slice curpos 4 program)
            x (nth program (nth ops 1))
            y (nth program (nth ops 2))
            newpos (nth ops 3)]
        ;; (println ops x y)
        (case (nth program curpos)
          1  (recur (utils/inplace newpos (+ x y) program) (+ curpos 4))
          2  (recur (utils/inplace newpos (* x y) program) (+ curpos 4))
          99 (first program))))))

(defn input-pair []
  (let [pairs (for [noun (range 99)
                    verb (range 99)]
                [noun verb])]
    (loop [curpos 0]
      (if (= 19690720 (intcode (nth pairs curpos)))
        (nth pairs curpos)
        (recur (inc curpos))))))
;; [67 18]
