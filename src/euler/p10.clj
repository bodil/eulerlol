(ns euler.p10
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (defn true-false-seq [bool]
    "An endless sequence of alternating booleans."
    (lazy-seq
     (cons bool (true-false-seq (not bool)))))
  (test/is (= [true false true false true] (take 5 (true-false-seq true))))
  (test/is (= [false true false true false] (take 5 (true-false-seq false)))))

(test/with-test
  (defn primes-below [limit]
    "Find all primes below limit, which must be > 3."
    ;; Ugly code is ugly because of the Java boolean-array.
    ;; Make this more functional pls?
    (let [sieve (boolean-array (inc limit) (true-false-seq true))
          crosslimit (Math/sqrt limit)]
      (aset sieve 2 false)
      (loop [n 3]
        (when (<= n crosslimit)
          (when (not (aget sieve n))
            (loop [m (sqr n)]
              (when (<= m limit)
                (aset sieve m true)
                (recur (+ m (* 2 n))))))
          (recur (+ n 2))))
      (cons 2 (for [n (range 3 limit 2) :when (not (aget sieve n))] n))))
  (test/is (= [2 3 5 7 11 13] (primes-below 15))))

;; Still takes ~15 secs to run.
(defn euler-p10 []
  (reduce + (primes-below 2000000)))

