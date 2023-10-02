(ns utils.read
  (:gen-class)
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :as str]))


(defn read-csv
  [filename]
  (with-open [reader (io/reader filename)]
    (doall
     (csv/read-csv reader))))


(defn planet-map [row]
  (let [[id name diameter mass gravity distance rotation orbit moons features facts] row]
    {:id id
     :name name
     :diameter diameter
     :mass mass
     :gravity gravity
     :distance-from-sun distance
     :rotation-period rotation
     :orbit-period orbit
     :moons moons
     :geographic-features (str/split features #", ")
     :fun-facts (str/split facts #", ")}))

(defn planet-search
  [planets id-planet] 
  ;(println "planets:" planets) ; Imprime os planetas para depuração
  ;(println "id-planet:" id-planet) ; Imprime o ID do planeta para depuração
  (println (filter #(= id-planet (:id %)) planets)))
