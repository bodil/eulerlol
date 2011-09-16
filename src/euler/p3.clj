(ns euler.p3
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (defn prime-factor [n]
    ;; This function owes more than a little to Uncle Bob's implementation:
    ;; http://blog.objectmentor.com/articles/2010/05/15/clojure-prime-factors
    (loop [factors [], n n, candidate 2]
       (cond
        (= n 1) factors
        (divisible-by? n [candidate]) (recur (conj factors candidate) (quot n candidate) candidate)
        (> candidate (Math/sqrt n)) (conj factors n)
        :else (recur factors n (inc candidate)))))
  
  (test/is (= '(5 7 13 29) (prime-factor 13195))))

(defn euler-p3 []
  (apply max (prime-factor 600851475143)))

