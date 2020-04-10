(ns bpm-web.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]))

(def samples 8)
(def timeout 5000)
;; -------------------------
;; State

(defonce times (r/atom [0]))

(defn handle-click! [n]
  (let [now (system-time)
        last-time (last @times)]
    (if (and (not (zero? last-time)) (< timeout (- now last-time)))
      (reset! times [now])
      (swap! times (comp vec (partial take-last (inc samples)) conj) now))))

;; -------------------------
;; components

(defn button [n]
  ^{:key "button-1"} [:button
             {:on-click #(handle-click! n)}
             n])

(defn bpm [ts]
  (let [c (dec (count ts))
        interval (- (last ts) (first ts))
        tpb (/ interval c)]
    (* 60000 (/ 1 tpb))))

(defn round [p x]
  (/ (int (+ 0.5 (* (Math/pow 10 p) x))) (Math/pow 10 p)))

;; -------------------------
;; Views

(defn home-page []
  [:div 
   (button (->> @times bpm (round 0)))])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
