(ns bober228777.core)

(defn ferma [n]
  (if (or ( = n 0) (> n 2)) "-1"
      (if ( = n 1) "1 2 3" "3 4 5")
   )
  )

(defn getIndexByName [name]
  (let [firstCloset #{"Alice", "Ariel", "Aurora", "Phil", "Peter", "Olaf", "Phoebus", "Ralph", "Robin"}
        secondCloset #{"Bambi", "Belle", "Bolt", "Mulan", "Mowgli", "Mickey", "Silver", "Simba", "Stitch"}
        thirdCloset #{"Dumbo", "Genie", "Jiminy", "Kuzko", "Kida", "Kenai", "Tarzan", "Tiana", "Winnie"}
        ]
    (if (= (conj firstCloset name) firstCloset) 0
     (if (= (conj secondCloset name) secondCloset) 1 2))
    )
  )

(def ^:dynamic sum 0)(def ^:dynamic cur 0)
(defn donaldPotchtalion [] (binding [sum sum]  (binding [cur cur]
(let [n (read-string (read-line))]
    (doseq [i (for [i (range n)] (int i))]
      (let [closetIndex (getIndexByName (read-line))]
            (set! sum (+ sum (abs (- closetIndex cur))))
            (set! cur closetIndex)
          ))
        ))
    (println sum)
))

;(println (reduce + (map read-string(clojure.string/split (read-line) #" "))))
;(println (ferma (read-string (read-line))))
;(donaldPotchtalion)

(defn oboroten [] (let [n (read-string (read-line)) l (vec (repeat 1010 []))]
  (loop [cnt 0]
    (let [s (read-line)]
      (if (not= s "BLOOD") (recur
            (let [uv (clojure.string/split s #" ")]
              (println (conj (get l (nth uv 0)) (nth uv 1)))
            )
          )
        )
      )
    )
  (dotimes [i 5]
    (println (get l i)))
  )
)

(oboroten)