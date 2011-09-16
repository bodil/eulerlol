(ns euler.p4
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (defn palindrome? [n]
    "True if the number is a palindrome."
    (= (seq (str n)) (reverse (str n))))

  (test/is (palindrome? 1337331))
  (test/is (not (palindrome? 1337))))

(defn n-digit-numbers [n]
  "List of all numbers with n digits."
  (range (int (Math/pow 10 (- n 1))) (int (Math/pow 10 n))))

(defn products-of-n-digit-numbers [n]
  (set (for [x (n-digit-numbers n) y (n-digit-numbers n)] (* x y))))

(defn euler-p4 []
  (apply max (filter palindrome? (products-of-n-digit-numbers 3))))

