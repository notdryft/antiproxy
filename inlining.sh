#!/usr/bin/env bash

java -Xbatch -XX:-TieredCompilation \
     -XX:+PrintCompilation \
     -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining \
     -XX:+LogCompilation \
     -cp build/classes/main \
     org.dryft.antiproxy.Main
