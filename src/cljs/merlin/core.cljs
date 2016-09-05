(ns merlin.core
  (:require [reagent.core :as r]
            [ajax.core :refer [GET]]))

(defonce state (r/atom {:weather 0}))

(defonce server-url "http://localhost:3000")

(defn get-weather []
  (GET (str server-url "/api/weather")
       {:handler #(swap! state assoc :weather (get % "temp"))}))

(defn home-page []
  [:div [:h2 "Merlin Home"]
   [:div (get @state :weather)]])

(defn ^:export run []
  (get-weather)
  (r/render [home-page]
                  (.getElementById js/document "app")))
