(ns adventofcode.utils
  (:require [clojure.string :as str]))

(defn input-file
  "Uses the current ns to construct the name of the current input file"
  []
  (let [curr-ns (second (str/split (str *ns*) #"\."))]
    (str "data/" curr-ns ".txt")))

(defn get-input
  "Dual-arity function that reads the appropriate input file"
  ([] (str/split-lines (slurp (input-file))))
  ([separator] (str/split (str/trim (slurp (input-file))) separator)))

(defn convert-num
  "Converts a string collection into an Integer collection"
  [inp]
  (map #(Integer/parseInt %) inp))

(defn slice
  "Returns a slice of length n starting from index i"
  [i n coll]
  (let [last (+ i n)]
    (take-last n (take last coll))))

(defn inplace
  "Returns a new coll with value at index i replaced by v"
  [i v coll]
  (if (>= i (count coll))
    (list v)
    (concat (take i coll) (list v) (drop (inc i) coll))))
