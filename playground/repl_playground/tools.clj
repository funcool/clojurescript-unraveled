(require '[cljs.build.api :as b])
(require '[cljs.repl :as repl])
(require '[cljs.repl.nashorn :as nashorn])
(require '[cljs.repl.node :as node])
(require '[cljs.repl.browser :as browser])

(require '[rebel-readline.core]
         '[rebel-readline.clojure.main]
         '[rebel-readline.clojure.line-reader]
         '[rebel-readline.cljs.service.local]
         '[rebel-readline.cljs.repl])

(defmulti task first)

(defmethod task :default
  [args]
  (let [all-tasks  (-> task methods (dissoc :default) keys sort)
        interposed (->> all-tasks (interpose ", ") (apply str))]
    (println "Unknown or missing task. Choose one of:" interposed)
    (System/exit 1)))

(defmethod task "repl:nashorn"
  [args]
  (repl/repl (nashorn/repl-env)
             :output-dir "out/nashorn"
             :cache-analysis true))

(defmethod task "repl:node"
  [args]
  (repl/repl (node/repl-env)
             :output-dir "out/nodejs"
             :cache-analysis true))


(defmethod task "repl:rebel:node"
  [args]
  (rebel-readline.core/with-line-reader
    (rebel-readline.clojure.line-reader/create
     (rebel-readline.cljs.service.local/create))
    (repl/repl (node/repl-env)
               :prompt (fn []) ;; prompt is handled by line-reader
               :read (rebel-readline.cljs.repl/create-repl-read)
               :output-dir "out/nodejs"
               :cache-analysis false)))

(defmethod task "repl:browser"
  [args]
  (println "Building...")
  (b/build "src"
           {:output-to "out/browser/main.js"
            :output-dir "out/browser"
            :source-map true
            :main 'myapp.core
            :optimizations :none})

  (println "Launching REPL...")
  (repl/repl (browser/repl-env :port 9001)
             :output-dir "out/browser"))

(task *command-line-args*)


