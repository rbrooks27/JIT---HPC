import java.io.IOException;

public class BenchmarkDriver {
    public static void main(String[] args) {
        int size = 500;

        // Measure compilation time (javac)
        long compileStart = System.currentTimeMillis();
        try {
            Process p = new ProcessBuilder("javac", "MatrixOps.java").start();
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Compilation failed.");
        }
        long compileEnd = System.currentTimeMillis();
        double compilationTime = (compileEnd - compileStart) / 1000.0;

        // Measure runtime + memory
        int[][] a = MatrixOps.buildMatrix(size, size);
        int[][] b = MatrixOps.buildMatrix(size, size);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Suggest garbage collection

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        for (int i = 0; i < 5; i++) {
            MatrixOps.matMul(a, b);
        }

        long end = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        double elapsedSeconds = (end - start) / 1_000_000_000.0;
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.printf("Compilation time: %.3f seconds%n", compilationTime);
        System.out.printf("Execution time: %.3f seconds%n", elapsedSeconds);
        System.out.printf("Memory used: %.2f MB%n", memoryUsed / (1024.0 * 1024));
    }
}
