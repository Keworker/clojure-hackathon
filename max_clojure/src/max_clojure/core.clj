(ns max-clojure.core)

(defn problem1000 []
  (let [ab (read-line)]
    (println (reduce + (map read-string (.split ab " "))))))

(defn problem1349 []
  (let [n (read-string (read-line))]
    (println
      (cond
        (= n 1) "1 2 3"
        (= n 2) "3 4 5"
        :else "-1"))))

(defn problem1242 []
  (defn input [stop]
    (loop [arr []]
      (let [s (read-line)]
        (if (not= s stop)
          (recur (conj arr (map read-string (.split s " "))))
          arr))))

  (let [n (read-string (read-line)) edge_list (input "BLOOD") infected (input nil) graph (vec (repeat (+ n 1) (transient [])))]
    (println edge_list)
    (println infected)
    (for [edge edge_list :let [x (get edge 0) y (get edge 1)]]
      (conj! (get graph x) y))))

(problem1242)

(defn A [n m]
  (let [n_ (- n 1) m_ (- m 1)]
    (cond
      (= n 0) (+ m 1)
      (= m 0) (A n_ 1)
      :else (A n_ (A n m_)))))
