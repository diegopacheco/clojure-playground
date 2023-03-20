### Run
open clojur repl
```bash
lein repl
```
```clojure
(load-file "main.clj")
(run-with-strategy "*" 3 4)
```
Results
```bash
user=> (load-file "main.clj")
#'user/run-with-strategy
user=> (run-with-strategy "*" 3 4)
12
user=> 
```