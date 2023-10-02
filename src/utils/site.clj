(ns utils.site
  (:gen-class)
   (:require [clj-http.client :as client]
             [clojure.java.browse :as browse]))

(def site-adrress "https://en.wikipedia.org/wiki/")

(defn site_name
  [name]
  (str site-adrress name))

(defn open_site
  [site-name]
  (browse/browse-url site-name) 
  )