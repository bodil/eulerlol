(ns euler.lib
  (:require [clojure [test :as test]]))

(test/with-test
  (defn divisible-by? [n ds]
    "True if n is divisible by all numbers in ds."
    (every? #(= 0 (rem n %1)) ds))

  (test/is (divisible-by? 6 [2 3]))
  (test/is (divisible-by? 15 [3 5]))
  (test/is (not (divisible-by? 15 [3 5 10]))))

