# times-table

return a time-table in clojure.

## LazySeq
this code gives a lazy-sequence.
```clojure
(map #(* n %1) (range 11))
```
So - when is concatenated with a string does not work as expected.
so we can force evaluation using into. 
```clojure
(into '() (map #(* n %1) (range 11)))
```

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar times-table-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2022 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
