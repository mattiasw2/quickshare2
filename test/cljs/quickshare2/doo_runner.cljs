(ns quickshare2.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [quickshare2.core-test]))

(doo-tests 'quickshare2.core-test)

