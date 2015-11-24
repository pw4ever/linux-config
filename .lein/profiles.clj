{

 :user {
        
        :plugins [
                  ;; for CIDER - Clojure(Script) IDE
                  [cider/cider-nrepl "0.9.1"]
                  [refactor-nrepl "1.1.0"]
                  [org.clojure/tools.nrepl "0.2.10"]

                  ;; other Clojure targets
                  [lein-cljsbuild "1.0.6"]
                  ;;[lein-droid "0.2.3"]

                  ;; better REPL
                  [venantius/ultra "0.3.4"]
                  
                  ;; misc plugins
                  [lein-ring "0.9.6"]
                  [lein-localrepo "0.5.3"]
                  [lein-marginalia "0.8.0"]
                  [lein-javadoc "0.1.1"]
                  [lein-ancient "0.6.1"]
                  [lein-pprint "1.1.2"]
                  
                  ]

        :dependencies [
                       ;; for ClojureScript REPL
                       [org.clojure/clojurescript "1.7.48"]
                       [com.cemerick/piggieback "0.2.1"]
                       [weasel "0.7.0"]

                       [slamhound "1.5.5"]
                       [alembic "0.3.2"]
                       ]

        ;; https://github.com/cemerick/piggieback
        :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                       :init (do
                               (use 'clojure.pprint
                                    'clojure.stacktrace))}

        ;; https://github.com/venantius/ultra/issues/13
        :ultra {:repl true
                :stacktraces true
                :tests true
                :java true
                :color-scheme :solarized_dark}

        ;; local JDK API javadoc
        ;; use Leiningen profile read-eval trick
        ;; https://github.com/technomancy/leiningen/blob/master/doc/PROFILES.md#dynamic-eval
        :resource-paths [#=(eval (clojure.string/join (System/getProperty "file.separator")
                                                      [(System/getProperty "user.home")
                                                       "Documents"
                                                       "jdk"
                                                       "docs"
                                                       "api"]))
                         "/usr/share/doc/java/api/"]

        :aliases {
                  "slamhound" ["run" "m" "slam.hound"]
                  }


        :android {
                  ;;:sdk-path "/home/wei/android-sdk"
                  ;;:keystore-path ~(clojure.string/join (System/getProperty "file.separator") [(System/getProperty "user.home") ".android" "pengw.keystore"])
                  ;;:keystore-path "/home/wei/.android/pengw.keystore"
                  ;;:key-alias "pengw"

                  ;;:storepass ""
                  ;;:keypass ""
                  }

        }

 }
