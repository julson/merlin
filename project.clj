(defproject merlin "0.1.0-SNAPSHOT"
  :description "Making you aware of the stuff around you"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 [clj-http "2.1.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler merlin.handler/app}
  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
