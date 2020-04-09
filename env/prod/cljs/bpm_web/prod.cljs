(ns bpm-web.prod
  (:require
    [bpm-web.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
