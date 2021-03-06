(ns quickshare2.routes.home
  (:require [quickshare2.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            quickshare2.db.core
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render "home.html"))

(defn users-page []
  (layout/render "users.html" {:users (quickshare2.db.core/get-users)}))

(defroutes home-routes
  (GET "/" []
       (home-page))
  (GET "/docs" []
       (layout/render "docs.html" {:docs (-> "docs/docs.md" io/resource slurp)})
       ;; (-> (response/ok (-> "docs/docs.md" io/resource slurp))
       ;;     (response/header "Content-Type" "text/plain; charset=utf-8"))
       )
  (GET "/about2" []
       (layout/render "about2.html"))
  (GET "/users" []
       (users-page))
  )
