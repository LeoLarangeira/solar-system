(ns inserts.inserts
  (:gen-class)
  (:require [clojure.data.csv :as csv] 
            [clojure.java.io :as io]
            [clojure.string :as s]))

(defn format_entry
  [entry]
  (clojure.string/join "," entry))


(defn to_csv
  "Grava a entrada em um arquivo csv"
  [filename planets]
  (with-open [writer (io/writer filename :append true)]
    (csv/write-csv writer (vec (map #(vector (:name %)
                                             (:diameter %)
                                             (:mass %)
                                             (:gravity %)
                                             (:distance-from-sun %)
                                             (:rotation-period %)
                                             (:orbit-period %)
                                             (:moons %)
                                             (clojure.string/join "," (:geographic-features %))
                                             (clojure.string/join "," (:fun-facts %)))
                                    planets)))))

