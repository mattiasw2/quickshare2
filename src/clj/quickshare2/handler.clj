(ns quickshare2.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [quickshare2.layout :refer [error-page]]
            [quickshare2.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [quickshare2.env :refer [defaults]]
            [mount.core :as mount]
            [quickshare2.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
