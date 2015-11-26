{

 :user {
        
        :plugins [
                  ;;; for CIDER - Clojure(Script) IDE
                  [cider/cider-nrepl "0.9.1"]
                  [refactor-nrepl "1.1.0"]
                  [org.clojure/tools.nrepl "0.2.11"]

                  ;;; ClojureScript
                  [lein-cljsbuild "1.1.1"]  ; https://github.com/clojure/clojurescript/wiki/lein-cljsbuild
                  [lein-figwheel "0.5.0-2"] ; https://github.com/bhauman/lein-figwheel
                  [lein-npm "0.6.1"]    ; https://github.com/RyanMcG/lein-npm
                  [lein-cljsasset "0.2.0"] ; https://github.com/pbostrom/lein-cljsasset

                  ;;; better REPL
                  ;;; -- disabled: specify needs with :repl-options > :init below
                  ;;[venantius/ultra "0.4.0"]
                  ;; last version that supports Clojure 1.6.x
                  ;;[venantius/ultra "0.3.4"] 
                  
                  ;;; useful plugins
                  [lein-ring "0.9.7"]
                  [lein-localrepo "0.5.3"]
                  [lein-marginalia "0.8.0"]
                  [lein-javadoc "0.1.1"]
                  [lein-ancient "0.6.1"]
                  [lein-pprint "1.1.2"]
                  
                  ]

        :dependencies [
                       ;;; utilities
                       [im.chit/hara.reflect "2.2.11"] ; JVM reflections
                       [alembic "0.3.2"] ; JVM classpath reloading
                       [slamhound "1.5.5"] ; ns form rewriter
                       
                       ;;; for ClojureScript REPL

                       ;; https://github.com/cemerick/piggieback
                       ;; nREPL middleware for ClojureScript
                       ;; (cemerick.piggieback/cljs-repl (cljs.repl.rhino/repl-env))
                       ;; ; type :cljs/quit to quit REPL
                       [com.cemerick/piggieback "0.2.1"]

                       ;; https://github.com/tomjakubowski/weasel
                       ;; Web-Socket-based channel over piggieback
                       ;; Step 1
                       ;; Piggieback the Weasel REPL environment onto the nREPL session, optionally specifying a port (defaults to 9001) and an address to bind to (defaults to "127.0.0.1")
                       ;; (cemerick.piggieback/cljs-repl
                       ;;  (weasel.repl.websocket/repl-env :ip "0.0.0.0" :port 9001))
                       ;; Weasel will block the REPL, waiting for a client to connect.
                       ;; In your project's ClojureScript source, require the Weasel client namespace and connect to the REPL.
                       ;; (when-not (weasel.repl/alive?)
                       ;;   (repl/connect "ws://localhost:9001"
                       ;;                 :verbose true
                       ;;                 :print #{:repl :console}
                       ;;                 :on-error #(print "Error! " %)))
                       
                       [weasel "0.7.0" :exclusions [org.clojure/clojurescript]]

                       ;;; Android
                       ;; [lein-droid "0.4.3]
                       
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
                               (require '[alembic.still
                                          :refer [distill load-project]]
                                        '[cemerick.piggieback
                                          :as piggieback
                                          :refer [cljs-repl]]
                                        '[weasel.repl.websocket
                                          :as weasel]))}

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
