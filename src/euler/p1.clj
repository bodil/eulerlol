(ns euler.p1)

(defn euler-p1 []
  (reduce + (filter #(or (= (rem %1 3) 0) (= (rem %1 5) 0)) (range 1000))))
