(ns quickshare2.db.core
  (:require
   [clojure.tools.logging :as log]
   [clojure.java.jdbc :as jdbc]
   [conman.core :as conman]
   [quickshare2.config :refer [env]]
   [mount.core :refer [defstate]])
  (:import [java.sql
            BatchUpdateException
            PreparedStatement]))

(defstate ^:dynamic *db*
  :start
  (try (conman/connect! {:jdbc-url (env :database-url)})
       (catch Throwable e (do (println (str "Database connection failed " e))
                              (log/error (str "Database connection failed " e)))))
  :stop
  (conman/disconnect! *db*))

(conman/bind-connection *db* "sql/queries.sql")

(defn to-date [^java.sql.Date sql-date]
  (-> sql-date (.getTime) (java.util.Date.)))

(extend-protocol jdbc/IResultSetReadColumn
  java.sql.Date
  (result-set-read-column [v _ _] (to-date v))

  java.sql.Timestamp
  (result-set-read-column [v _ _] (to-date v)))

(extend-type java.util.Date
  jdbc/ISQLParameter
  (set-parameter [v ^PreparedStatement stmt idx]
    (.setTimestamp stmt idx (java.sql.Timestamp. (.getTime v)))))
