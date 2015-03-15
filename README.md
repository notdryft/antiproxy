# Antiproxy

Playing with proxies compilation flags.

## Building and running

```bash
$ gradle [-q] build
$ gradle [-q] run
```

## Check

`gradle build` is a prerequisite for each of thoses tasks.

### Inlining

```bash
$ java -Xbatch -XX:-TieredCompilation \
       -XX:+PrintCompilation \
       -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining \
       -XX:+LogCompilation \
       -cp build/classes/main \
       org.dryft.antiproxy.Main
```

Or:
```bash
$ ./print_inlining.sh
```

### Assembly

```bash
$ java -Xbatch -XX:-TieredCompilation \
       -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly \
       -cp build/classes/main \
       org.dryft.antiproxy.Main
```

Or:
```bash
$ ./print_assembly.sh
```

## Flags

### -XX:+FreqInlineSize

325 bytecode instructions by default on Linux 64 bits.

### -XX:+PrintCompilation (product)

Print hot methods.

https://gist.github.com/rednaxelafx/1165804#file-notes-md

### -XX:+PrintInlining (diagnostic)

Print inlining tree and class profile.

`-XX:+UnlockDiagnosticVmOptions` required for inlining to work.

### -XX:+LogCompilation (diagnostic)

More info, branch profile info, etc

### -XX:+PrintAssembly (diagnostic)

Annotated generated code.

HotSpot disassembler plugin needed: https://kenai.com/projects/base-hsdis/downloads

### Stability between executions

* `-Xbatch`: one thread running and compilation
* `-XX:-TieredCompilation`
