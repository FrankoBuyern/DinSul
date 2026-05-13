import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicLong;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeTask {

    public static boolean isPrime(long number) {
        if (number < 2) return false;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public long countSingleThread(long max) {

        long count = 0;

        for (long i = 1; i <= max; i++) {

            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    public long countMultiThread(long max, int threadsCount) throws InterruptedException {

        AtomicLong result = new AtomicLong(0);

        Thread[] threads = new Thread[threadsCount];

        long part = max / threadsCount;

        for (int t = 0; t < threadsCount; t++) {

            long start = t * part + 1;

            long end;

            if (t == threadsCount - 1) {
                end = max;
            } else {
                end = start + part - 1;
            }

            threads[t] = new Thread(() -> {

                long local = 0;

                for (long i = start; i <= end; i++) {

                    if (isPrime(i)) {
                        local++;
                    }
                }

                result.addAndGet(local);
            });

            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return result.get();
    }

    @Test
    void testPrimePerformance() throws InterruptedException {
        long maxNumber = 5_000_000;
        int threads = 4;

        long startSingle = System.currentTimeMillis();
        long singleResult = countSingleThread(maxNumber);
        long timeSingle = System.currentTimeMillis() - startSingle;

        long startMulti = System.currentTimeMillis();
        long multiResult = countMultiThread(maxNumber, threads);
        long timeMulti = System.currentTimeMillis() - startMulti;

        System.out.println("Single: " + timeSingle + " ms, Multi: " + timeMulti + " ms");

        assertEquals(348513, singleResult, "Однопоточный алгоритм считает неверно!");
        assertEquals(singleResult, multiResult, "Результаты однопоточного и многопоточного не совпадают!");
        assertTrue(timeMulti < timeSingle, "Многопоточная версия должна быть быстрее!");
    }
}