#!/usr/bin/env bash

java -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -XX:+LogCompilation -cp build/classes/main org.dryft.antiproxy.Main
