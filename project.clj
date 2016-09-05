(defproject merlin "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://example.com/FIXME"
  :min-lein-version "2.5.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.227"]
                 [compojure "1.5.0"]
                 [ring "1.4.0"]
                 [ring-server "0.4.0"]
                 [ring/ring-defaults "0.2.0"]
                 [ring/ring-json "0.4.0"]
                 [clj-http "2.1.0"]
                 [cljs-ajax "0.5.8"]
                 [figwheel "0.5.6"]
                 [reagent "0.6.0-rc"]]

  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.6"]]

  :ring {:handler merlin.handler/app}

  :source-paths ["src/clj"]

  :hooks [leiningen.cljsbuild]

  :cljsbuild {:builds {:client {:figwheel {:on-jsload "merlin.core/run"}
                                :compiler {:main "merlin.core"
                                           :optimizations :none}}}}

  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]
         :cljsbuild {:builds {:client {:source-paths ["src/cljs"]
                                       :compiler {:output-dir "target/client"
                                                  :output-to "target/client.js"}}}}}})
