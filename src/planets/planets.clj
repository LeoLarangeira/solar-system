(ns planets.planets
  (:gen-class))


(defrecord planet
           [
            id ; int
            name ; String
            diameter ; Double km
            mass ; Double kg
            gravity ; Double m/s^2
            distance-from-sun ; Double kilometers
            rotation-period ; Double dias
            orbit-period ; Double dias
            moons ; Integer
            geographic-features ; vec de string
            fun-facts ; vec de string
            ])
            


