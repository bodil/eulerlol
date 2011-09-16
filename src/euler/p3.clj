(ns euler.p3
  (:require [clojure [test :as test]])
  (:use euler.lib))

(defn euler-p3 []
  (apply max (prime-factor 600851475143)))

