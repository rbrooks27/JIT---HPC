# Java Matrix Benchmark

This project benchmarks the performance of Java matrix multiplication, measuring:
- Java compilation time
- Runtime execution time (with multiple iterations)
- Memory usage
- Optional: JIT compilation behavior using JVM flags

##  How to Run

### 1. Compile the Code

Open a terminal in the project directory and run:

``` bash
javac MatrixOps.java BenchmarkDriver.java
```
### 2. Run the Code

``` 
java BenchmarkDriver
```

## Requirements

1. Java 17 or newer
 use: 
 ```
 sudo apt install openjdk-17-jdk
 ```

## Benchmark Parameters
- Matrix size: 500 x 500
- Repeats matrix multiplication 5 times to measure average performance
- Uses ```System.nanoTime()``` for precise runtime tracking
- Measures heap memory usage with ```Runtime.getRuntime()```

## What is JIT Compilation?

Java uses a **Just-In-Time (JIT)** compiler as part of the JVM (Java Virtual Machine). Rather than compiling code ahead of time (AOT) like C/C++, Java compiles bytecode **at runtime** when methods become "hot" (i.e., executed frequently).

This runtime compilation allows the JVM to:
- Optimize based on actual runtime behavior (profiling data)
- Inline methods
- Remove unused code paths (dead code elimination)
- Specialize based on types and branches taken

Different JVMs (HotSpot, OpenJ9, GraalVM) each implement JIT differently.

