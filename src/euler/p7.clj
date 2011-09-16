(ns euler.p7
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (defn next-prime [n]
    "Returns the first prime greater than n."
    (loop [n (inc n)]
      (if (prime? n) n
          (recur (inc n)))))
  (test/is (= 1321 (next-prime 1319)))
  (test/is (= 1327 (next-prime 1321))))

(test/with-test
  (defn nth-prime [n]
    "Returns the nth prime."
    (loop [i n, prime 1]
      (if (zero? i) prime
          (recur (dec i) (next-prime prime)))))
  (test/is (= 13 (nth-prime 6))))

(defn euler-p7 []
  (nth-prime 10001))

