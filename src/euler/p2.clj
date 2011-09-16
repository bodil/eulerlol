(ns euler.p2
  (:require [clojure [test :as test]])
  (:use euler.lib))

(test/with-test
  (defn fib-range [max]
    (if (= max 0) '(0)
        (if (= max 1) '(0 1)
            (loop [r '(0 1), n 1, p-2 0, p-1 1]
              (if (< n max)
                (let [f (+ p-2 p-1)]
                  (recur (concat r (list f)) (+ n 1) p-1 f))
                r)))))
  (test/is (= '(0 1 1 2 3 5 8 13) (fib-range 7))))

(defn euler-p2 []
  (reduce + (for [f (fib-range 50) :while (< f 4000000) :when (even? f)] f)))

