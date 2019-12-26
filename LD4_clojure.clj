(ns LD4_clojure)

(require '[clojure.string :as string])

;;Write function which calculate average mark
(defn average [collection]
  (float (/ (reduce + collection) (count collection))))

;;Define list of students with marks
(def studentList {"Inese" 10 "Vasja" 8 "Petja" 4 "Natasha" 7
               "Anja" 10 "Lauris" 6 "Sandra" 8 "Krišjanis" 9})

;;write function averageMark which filter students and calculate average mark
(defn avgMark [students]
  (average (for [[a b] (filter (fn [[c d]] (string/ends-with? c "a")) students)] b)))

(avgMark studentList)


;;WARNING: That program will not work probably, if add one more student to the list with the same name.
;; That duplicate problem, and I don't know how to solve it.
