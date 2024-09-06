# lein-add-libs

Use the [add-lib](https://clojure.github.io/clojure/branch-master/clojure.repl-api.html#clojure.repl.deps/add-lib) function in your repl from within a lein project.

# Installation as a Tool

Make sure you have the latest Clojure CLI version installed. 

```sh
clj -Ttools install nubank/lein-add-libs '{:git/url "git@github.com:nubank/lein-add-libs.git" :git/sha "ad9b22cbea29fb76fa3d60e639320052e1423be4"}' :as lein-add-libs
```

# Invoking the tool from a REPL

```clojure
(clojure.tools.deps.interop/invoke-tool {:tool-name "lein-add-libs" :fn 'lein-add-libs.core/bootstrap})
```

Now that the bootstrap function has been successfully run. You can proceed to use `add-lib`, `add-libs` as you would in a deps.edn base project. *NOTE* `sync-deps` is not expected to work in a lein context.

For example:
```clojure
(add-lib 'org.clojure/data.json)
(require '[clojure.data.json :as json])
(json/read-str "{\"a\":1,\"b\":2}" :key-fn keyword)
```