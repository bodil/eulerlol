(ns euler.lib
  (:require [clojure [test :as test]]))

(test/with-test
  (defn divisible-by? [n ds]
    "True if n is divisible by all numbers in ds."
    (every? #(= 0 (rem n %1)) ds))

  (test/is (divisible-by? 6 [2 3]))
  (test/is (divisible-by? 15 [3 5]))
  (test/is (not (divisible-by? 15 [3 5 10]))))

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

(test/with-test
  (defn prime? [n]
    "True if n is a prime."
    (= 1 (count (prime-factor n))))

  (test/is (not (prime? 1)))
  (test/is (prime? 2))
  (test/is (prime? 3))
  (test/is (not (prime? 4)))
  (test/is (prime? 5))
  (test/is (not (prime? 6)))
  (test/is (prime? 1327))
  (test/is (not (prime? 1337))))

