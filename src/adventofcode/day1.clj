(ns adventofcode.day1
  (:require [clojure.string :as str])
  (:gen-class))

(defn -main
  [& args]
  (println "Advent of Code 2019 - Day 1"))

(def input-file "data/day1.txt")

(defn get-input []
  (str/split-lines (slurp input-file)))

(defn calc-weight []
  (let [inp (get-input)]
    (->> inp
         (map #(Integer/parseInt %))
         (map #(/ % 3))
         (map int)
         (map #(- % 2))
         (reduce +))))