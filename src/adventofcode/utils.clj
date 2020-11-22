(ns adventofcode.utils
  (:require [clojure.string :as str]))

(defn input-file []
  (let [curr-ns (second (str/split (str *ns*) #"\."))]
    (str "data/" curr-ns ".txt")))

(defn get-input
  ([] (str/split-lines (slurp (input-file))))
  ([separator] (str/split (str/trim (slurp (input-file))) separator)))

(defn convert-num [inp]
  (map #(Integer/parseInt %) inp))

(defn slice [i n coll]
  (let [last (+ i n)]
    (take-last n (take last coll))))

(defn inplace [i v coll]
  (if (>= i (count coll))
    (list v)
    (concat (take i coll) (list v) (drop (inc i) coll))))
