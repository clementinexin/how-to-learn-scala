(ns functionalthinking.ch2.Process)
(defn process [list-of-emps]
      (reduce str (interpose ","
                             (map s/capitalize (filter #(< 1 (count %)) list-of-emps)))))


(defn process2 [list-of-emps]
      (->> list-of-emps
        (filter #(< 1 (count %)))
           (map s/capitalize)
           (interpose ",")
           (reduce str)))

(defn classify [num]
      (let [factors (->> (range 1 (inc num))
                         (filter #(zero? (rem num %))))
            sum (reduce + factors)
            aliquot-sum (- sum num)])
      (cond
        (= aliquot-sum num) :perfect
        (> aliquot-sum num) :abundant
        (< aliquot-sum num) :deficient)
      )

(def numbers (range 1 11))

(filter (fn [x] (zero? (rem x 3))) numbers)
(filter #(zero? (rem % 3)) numbers)

(map inc numbers)

(map #(count %) words)

(flatten [[1 2 3] [4 5 6] [7 8 9]])

(def substract-from-100 (partial - 100))

(substract-from-100 10)

(substract-from-100 10 20)


