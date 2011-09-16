(ns euler.p2)

(defn fib-range [max]
  (if (= max 0) '(0)
      (if (= max 1) '(0 1)
          (loop [r '(0 1), n 1, p-2 0, p-1 1]
            (if (< n max)
              (let [f (+ p-2 p-1)]
                (recur (concat r (list f)) (+ n 1) p-1 f))
              r)))))

(defn euler-p2 []
  (reduce + (for [f (fib-range 50) :while (< f 4000000) :when (even? f)] f)))

