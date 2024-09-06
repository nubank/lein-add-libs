# lein-add-libs

Use the [add-lib](https://clojure.github.io/clojure/branch-master/clojure.repl-api.html#clojure.repl.deps/add-lib) function in your repl from within a lein project.

# Installation as a Tool

**Important** make sure you have at least Clojure CLI version 1.12.0.1479 installed (can be checked with `clj -version`)

```sh
clj -Ttools install nubank/lein-add-libs '{:git/url "git@github.com:nubank/lein-add-libs.git" :git/sha "ad9b22cbea29fb76fa3d60e639320052e1423be4"}' :as lein-add-libs
```

# Invoking the tool from a REPL

```clojure
(clojure.tools.deps.interop/invoke-tool {:tool-name "lein-add-libs" :fn 'lein-add-libs.core/bootstrap})
```

Now that the bootstrap function has been successfully run. You can proceed to use `add-lib`, `add-libs` as you would in a deps.edn base project. **NOTE** `sync-deps` is not expected to work in a lein context.

For example:
```clojure
(add-lib 'org.clojure/data.json)
(require '[clojure.data.json :as json])
(json/read-str "{\"a\":1,\"b\":2}" :key-fn keyword)
```

## Copyright and License

Copyright © 2023 Nu North America, Inc

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.