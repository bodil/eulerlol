(ns euler.p1
  (:require [clojure [test :as test]])
  (:use euler.lib))

(defn euler-p1 []
  (reduce + (filter #(divisible-by? %1 [3 5]) (range 1000))))
