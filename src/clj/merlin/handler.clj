(ns merlin.handler
  (:require [clj-http.client :as client]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]))

(defn weather []
  (let [url "http://api.openweathermap.org/data/2.5/weather?q=san_francisco,ca&appid=67e7bf3c28af8c8707d707b23a9296b7"]
    (get-in (client/get url {:as :json-strict}) [:body :main])))

(defroutes app-routes
  (GET "/api/weather" [] {:headers {"Content-Type" "application/json;charset=utf-8"}
               :body (weather)})
  (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults app-routes site-defaults)
      wrap-json-response))
