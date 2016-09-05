(ns merlin.core
  (:require [reagent.core :as reagent :refer [atom]]))

(defn home-page []
  [:div [:h2 "Merlin Home"]])

(defn ^:export run []
  (reagent/render [home-page]
                  (.getElementById js/document "app")))
