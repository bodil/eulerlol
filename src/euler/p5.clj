(ns euler.p5
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (defn first-divisible-by [ns ds]
    "Find the first number in ns divisible by all numbers in ds."
    (if (seq ns)
      (let [n (first ns)]
        (if (divisible-by? n ds) n
            (recur (rest ns) ds)))
      nil))

  (test/is (= (first-divisible-by (range 1 10) [2 3])) 6)
  (test/is (= (first-divisible-by (range 2 5000 2) (range 2 11)) 2520)))

;; Save search time by only evaluating increments of 20, because we
;; know the answer must be divisible by 20.
(defn euler-p5 []
  (first-divisible-by (range 20 Double/POSITIVE_INFINITY 20) (range 2 21)))

