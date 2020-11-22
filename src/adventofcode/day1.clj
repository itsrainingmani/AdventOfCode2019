(ns adventofcode.day1
  (:require [adventofcode.utils :as utils])
  (:gen-class))

(defn -main
  []
  (println "Advent of Code 2019 - Day 1"))

(defn fuel-math [fuel]
  (-> fuel
      (/ 3)
      int
      (- 2)))

(defn calc-intermediate-fuel [fuel]
  (loop [inter-fuel (list fuel)]
    ;; (println inter-fuel)
    (if (<= (first inter-fuel) 0)
      (->> inter-fuel
           (filter #(> % 0))
           reverse
           rest
           (reduce +))
      (recur (conj inter-fuel (fuel-math (first inter-fuel)))))))

(defn calc-weight []
  (let [inp (utils/get-input)]
    (->> inp
         (map #(Integer/parseInt %))
         (map calc-intermediate-fuel)
         (reduce +))))
