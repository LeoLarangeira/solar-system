(ns utils.read
  (:gen-class)
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))


(defn read-csv 
  [filename]
  (with-open [reader (io/reader filename)]
    (doall
     (csv/read-csv reader))))

(defn planet-map 
  [planet]
  (let [[id name diameter-mass gravity distance rotation orbit moons features facts] planet] 
    {:id (Integer. id)
     :name name
     :diameter-mass (Double.  diameter-mass)
     :gravity (Double. gravity)
     :distance (Double. distance)
     :rotation (Double. rotation)
     :orbit (Double. orbit)
     :moons (Integer. moons) 
     :features (str/split features #",")
     :fun-facts (str/split facts #",")}))