;; 
(require 'boot.repl)

(swap! boot.repl/*default-dependencies*
       concat '[[cider/cider-nrepl "0.8.2"]])

(swap! boot.repl/*default-middleware*
       conj 'cider.nrepl/cider-middleware)

;; prefer local API javadoc for nREPL
(set-env! :resource-paths
          #(conj %  "/usr/share/doc/java/api/"))

