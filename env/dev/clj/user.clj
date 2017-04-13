(ns user
  (:require [mount.core :as mount]
            [quickshare2.figwheel :refer [start-fw stop-fw cljs]]
            quickshare2.core))

(defn start []
  (mount/start-without #'quickshare2.core/repl-server))

(defn stop []
  (mount/stop-except #'quickshare2.core/repl-server))

(defn restart []
  (stop)
  (start))


