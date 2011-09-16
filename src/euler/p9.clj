(ns euler.p9
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (defn pythagorean-triplet? [triplet]
    "True if a² + b² = c² in [a b c]."
    (let [[a b c] triplet] (= (+ (sqr a) (sqr b)) (sqr c))))
  (test/is (true? (pythagorean-triplet? [3 4 5])))
  (test/is (false? (pythagorean-triplet? [13 3 7]))))

(test/with-test
  (defn pythagorean-triplets [n]
    "Return all Pythagorean triplets of natural numbers where a < b < c and a + b + c = n."
    (for [a (range 1 n), b (range (inc a) (- n a))
          :let [c (- n (+ a b))] ;; given a and b, c can only be n-(a+b)
          :when (and (> c b) (pythagorean-triplet? [a b c]))]
      [a b c]))
  (test/is (= '([3 4 5]) (pythagorean-triplets 12)))
  (test/is (= '([9 40 41] [15 36 39]) (pythagorean-triplets 90))))

(defn euler-p9 []
  (apply * (first (pythagorean-triplets 1000))))

