{

 :user {
        
        :plugins [
                  ;; for CIDER - Clojure(Script) IDE
                  [cider/cider-nrepl "0.9.1"]
                  [refactor-nrepl "1.1.0"]
                  [org.clojure/tools.nrepl "0.2.11"]

                  ;; other Clojure targets
                  [lein-cljsbuild "1.1.1"]
                  [lein-figwheel "0.5.0-2"]

                  ;; better REPL
                  ;;[venantius/ultra "0.4.0"]
                  ;;[venantius/ultra "0.3.4"] ; last version that supports Clojure 1.6.x
                  
                  ;; misc plugins
                  [lein-ring "0.9.7"]
                  [lein-localrepo "0.5.3"]
                  [lein-marginalia "0.8.0"]
                  [lein-javadoc "0.1.1"]
                  [lein-ancient "0.6.1"]
                  [lein-pprint "1.1.2"]
                  
                  ]

        :dependencies [
                       ;; utilities
                       [im.chit/hara.reflect "2.2.11"] ; JVM reflections
                       [alembic "0.3.2"] ; classpath reloading
                       
                       ;; for ClojureScript REPL
                       [com.cemerick/piggieback "0.2.1"]
                       [weasel "0.7.0"]

                       [slamhound "1.5.5"]
                       
                       ]

        
        :repl-options {
                       ;; https://github.com/cemerick/piggieback
                       :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]

                       ;; REPL utilities
                       :init (do
                               (use 'clojure.pprint ; pprint print-table
                                    'clojure.repl ; source doc apropos root-cause pst
                                    'hara.reflect ; query-class query-instance
                                    )
                               (require '[alembic.still :refer [distill load-project]]))}

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
