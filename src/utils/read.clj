(ns utils.read
  (:gen-class)
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [planets.planets :as planets]))

; aqui eu vou fazer um mapa, assim eu posso transformar cada linha em um mapa 

(defn parse-planet [line]
  (let[[id name diameter mass gravity distance rotation orbit moons feature facts] line]
   {
    :id (Integer. id)
    :name name 
    :diameter (Double. diameter)
    :mass (Double. mass)
    :gravity (Double. gravity)
    :distance (Double. distance)
    :rotation (Double. rotation)
    :orbit (Double. orbit)
    :moons (Integer. moons)
    :feature feature
    :facts facts
    }))

(defn read-csv
  [filename]
  (with-open [file (io/reader filename)]
    (doall
     (map parse-planet (rest (csv/read-csv file))))))



(defn planet-search
  [planets id-planet]
  (let [result (first (filter #(= id-planet (:id %)) planets))]
    (if result
      (str "Name: " (:name result) " || greographic features: " (:feature result) " || fun facts:" (:facts result))
      "Não encontrado!")))

