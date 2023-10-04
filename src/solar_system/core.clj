(ns solar-system.core
  (:gen-class)
   (:require [planets.planets :as planets]
             [utils.inserts :as i]
             [utils.read :as r]
             [utils.site :as site]
             [clojure.string :as str]))


;; definindo o nome do arquivo 
(def filename "resources/solar-system.csv")
;; criando os planetas
(def mercury (planets/->planet 1 "Mercury" 4880 3.3e23 3.7 0.39 58.6 88 0 ["Caloris Basin" "Scarps" "Craters"] ["Test"]))
(def venus (planets/->planet 2 "Venus" 12104 4.9e24 8.87 0.72 243 225 0 ["Volcanic plains" "Mountains" "Impact craters"] ["Test"]))
(def earth (planets/->planet 3 "Earth" 12742 5.97e24 9.81 1 24 365.25 1 ["Nitrogen" "Oxygen" "Trace Gases"] ["test"]))
(def mars (planets/->planet 4 "Mars" 6779 6.42e23 3.71 1.52 1.03 687 2 ["Olympus Mons" "Valles Marineris" "Polar ice caps"] []))
(def jupiter (planets/->planet 5 "Jupiter" 139820 1.9e27 24.79 5.2 0.41 4333 79 ["Great Red Spot" "Jupiter's rings" "Galilean moons"] []))
(def saturn (planets/->planet 6 "Saturn" 116460 5.7e26 10.44 9.58 0.45 10759 83 ["Saturn's rings" "Cassini Division" "Titan's lakes"] []))
(def uranus (planets/->planet 7 "Uranus" 50724 8.7e25 8.69 19.22 0.72 30687 27 ["Uranus's axial tilt" "Rings of Uranus"] []))
(def neptune (planets/->planet 8 "Neptune" 49244 1.02e26 11.15 30.05 0.67 60190 14 ["Great Dark Spot" "Neptune's rings"] []))
















(defn -main
  []
  (i/to_csv filename [mercury venus earth mars jupiter saturn uranus neptune]) 
  (def planets (r/read-csv filename))


  (println "Enter with  some planet id ")
  (def planet-id (read-line))
  (println (r/planet-search planets (Integer. planet-id)))
  
  
  
  (println "Insert the name of the planet if you want to open the web-site")
  (def planet-name (read-line))
  (if (empty? (str/trim planet-name))
    (println "No planet name provided, skipping...")
    (println (site/open_site (site/site_name planet-name))))
  )
