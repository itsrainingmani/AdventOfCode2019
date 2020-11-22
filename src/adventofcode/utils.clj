(ns adventofcode.utils
  (:require [clojure.string :as str]))

(defn input-file []
  (let [curr-ns (second (str/split (str *ns*) #"\."))]
    (str "data/" curr-ns ".txt")))

(defn get-input []
  (str/split-lines (slurp (input-file))))
