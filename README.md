# Antiproxy

Playing with proxies compilation flags.

## Building and running

```bash
$ gradle [-q] build
$ gradle [-q] run
```

## Check

With `gradle build` as a prerequisite:
```bash
$ java -XX:+PrintCompilation \
       -XX:+UnlockDiagnosticVMOptions \
       -XX:+PrintInlining \
       -XX:+LogCompilation \
       -cp build/classes/main \
       org.dryft.antiproxy.Main
```

Or:
```bash
$ ./inlining.sh
```

## Flags

### -XX:+FreqInlineSize

325 bytecode instructions by default on Linux 64 bits.

### -XX:+PrintCompilation

Print hot method and.

### -XX:+PrintInlining

Print inlining tree and class profile.
`-XX:+UnlockDiagnosticVmOptions` required for inlining to work.

### -XX:+LogCompilation

More info, branch profile info, etc

### -XX:+PrintAssembly

Annotated generated code.
HotSpot disassembler plugin needed: https://kenai.com/projects/base-hsdis/downloads

### Stability between executions

* `-Xbatch`: one thread
* `-XX:TieredCompilation`
