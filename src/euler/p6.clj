(ns euler.p6
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (def sqr #(* %1 %1))
  (test/is (= 25 (sqr 5))))

(test/with-test
  (defn sum-of-squares [ns]
    "Return the sum of the squares of all numbers in ns."
    (reduce + (map sqr ns)))
  (test/is (= 385 (sum-of-squares (range 11)))))

(test/with-test
  (defn square-of-sums [ns]
    "Return the square of the sum of all numbers in ns."
    (sqr (reduce + ns)))
  (test/is (= 3025 (square-of-sums (range 11)))))

(defn euler-p6 []
  (- (square-of-sums (range 101)) (sum-of-squares (range 101))))
