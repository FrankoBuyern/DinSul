import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicLong;

public class Miner {

    private static boolean isValidHash(String hash, int zeros) {
        String suffix = "0".repeat(zeros);
        return hash.endsWith(suffix);
    }

    private static String sha256(long nonce) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(String.valueOf(nonce).getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                String s = Integer.toHexString(0xff & b);
                if (s.length() == 1) hex.append('0');
                hex.append(s);
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Single thr
    public static long mineSingleThread(long start, long end, int zeros) {
        long count = 0;

        for (long nonce = start; nonce <= end; nonce++) {
            String hash = sha256(nonce);
            if (isValidHash(hash, zeros)) {
                count++;
            }
        }
        return count;
    }

    // Multi
    public static long mineMultiThread(long start, long end, int zeros, int threads)
            throws InterruptedException {

        AtomicLong counter = new AtomicLong(0);
        Thread[] workers = new Thread[threads];

        long range = (end - start + 1) / threads;

        for (int i = 0; i < threads; i++) {
            long localStart = start + i * range;
            long localEnd = (i == threads - 1) ? end : localStart + range - 1;

            workers[i] = new Thread(() -> {
                for (long nonce = localStart; nonce <= localEnd; nonce++) {
                    String hash = sha256(nonce);
                    if (isValidHash(hash, zeros)) {
                        counter.incrementAndGet();
                    }
                }
            });

            workers[i].start();
        }

        for (Thread t : workers) {
            t.join();
        }

        return counter.get();
    }

    // Тестик
    public static void main(String[] args) throws InterruptedException {
        long start = 1;
        long end = 2_000_000;
        int zeros = 3;

        long t1 = System.currentTimeMillis();
        long single = mineSingleThread(start, end, zeros);
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        long multi = mineMultiThread(start, end, zeros, Runtime.getRuntime().availableProcessors());
        long t4 = System.currentTimeMillis();

        System.out.println("Single-thread: " + single + " time=" + (t2 - t1) + " ms");
        System.out.println("Multi-thread:  " + multi + " time=" + (t4 - t3) + " ms");
    }
}