(ns lein-add-libs.core
  (:require
    [clojure.string :as str]
    [clojure.java.basis.impl :refer [update-basis!]]
    [leiningen.core.project :as project]
    [leiningen.core.classpath :refer [get-classpath]]))

(defn update-lein-basis [current-basis derived-basis]
  (if current-basis current-basis derived-basis))

(defn bootstrap [& args]
  (let [cp (get-classpath (project/read))
        deps (filter #(str/includes? % "/.m2/") cp)
        dep-parts (map (fn [dep] (butlast (drop 2 (drop-while #(not= ".m2" %) (str/split dep #"/"))))) deps)
        libs (reduce (fn [res dep]
                       (let [formatted-dep (symbol (str (str/join "." (drop-last 2 dep)) "/" (last (drop-last dep))))]
                         (assoc res formatted-dep {:mvn/version (last dep) :deps/manifest :mvn}))) {} dep-parts)
        repos (reduce (fn [res [repo url]] (assoc res repo url)) {} (:repositories (project/read)))
        bootstrapped-basis {:libs libs :mvn/repos repos}]
    (update-basis! update-lein-basis bootstrapped-basis)))