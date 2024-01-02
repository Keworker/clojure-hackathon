(ns cli.core)

(defn helloWorld []
  (println "Hello, World!"))

(defn problem1000 []
  (println (reduce + (map read-string (.split (read-line) " ")))))

(defn problem1349 []
  (let [n (read-string (read-line))]
    (println (cond
               (= n 1) "1 2 3"
               (= n 2) "3 4 5"
               :else "-1"))))

(def ^:dynamic position 0)
(defn problem2023 []
  (let [first #{"Alice" "Ariel" "Aurora" "Phil" "Peter" "Olaf" "Phoebus" "Ralph" "Robin"}
        second #{"Bambi" "Belle" "Bolt" "Mulan" "Mowgli" "Mickey" "Silver" "Simba" "Stitch"}
        third #{"Dumbo" "Genie" "Jiminy" "Kuzko" "Kida" "Kenai" "Tarzan" "Tiana" "Winnie"}
        result (transient [0])
        n (read-string (read-line))]
    (binding [position position]
      (doseq [i (for [i (range n)] (inc i))]
        (let [cur (read-line)]
          (conj! result (cond
                          (or (and (= position 0) (.contains first cur))
                              (and (= position 1) (.contains second cur))
                              (and (= position 2) (.contains third cur))) 0
                          (or (and (= position 0) (.contains third cur))
                              (and (= position 2) (.contains first cur))) 2
                          :else 1))
          (set! position (cond
                           (.contains first cur) 0
                           (.contains second cur) 1
                           :else 2)))))
    (println (reduce + (persistent! result)))))

(def x2indexes (hash-map))
(defn problem1613 []
  (let [n (read-string (read-line))
        arr (map read-string (.split (read-line) " "))
        q (read-string (read-line))
        ]
    (loop [a arr i 1]
      (if a
        (do (if (.containsKey x2indexes (first a))
           (conj! (get x2indexes (first a)) i)
           (update x2indexes merge (hash-map (first a) (transient [i]))))
         (recur (next a) (+ i 1)))
        nil))
    (println x2indexes)))
