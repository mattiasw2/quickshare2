(ns quickshare2.app
  (:require [quickshare2.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
