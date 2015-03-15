#!/usr/bin/env bash

java -Xbatch -XX:-TieredCompilation \
     -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly \
     -cp build/classes/main \
     org.dryft.antiproxy.Main
