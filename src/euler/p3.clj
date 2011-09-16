(ns euler.p3
  (:require clojure.test))

(test/with-test
  (defn prime-factor
    ;; Uncle Bob wrote this function
    ([n]
       (prime-factor [] n 2))
    ([factors n candidate]
       (cond
        (= n 1) factors

        (= 0 (rem n candidate))
        (recur (conj factors candidate) (quot n candidate) candidate)

        (> candidate (Math/sqrt n)) (conj factors n)

        :else (recur factors n (inc candidate)))))
  
  (test/is (= '(5 7 13 29) (prime-factor 13195))))

(defn euler-p3 []
  (apply max (prime-factor 600851475143)))

