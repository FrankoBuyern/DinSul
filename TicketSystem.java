import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class TicketSystem {

    // Хранилище билетов
    static class TicketInventory {
        private int tickets;
        private final ReentrantLock lock = new ReentrantLock();

        public TicketInventory(int total) {
            this.tickets = total;
        }

        public boolean tryBuyTicket() {
            lock.lock();
            try {
                if (tickets > 0) {
                    tickets--;
                    return true;
                }
                return false;
            } finally {
                lock.unlock();
            }
        }

        public int getRemaining() {
            return tickets;
        }
    }

    // Тяж проверка токена
    static boolean verifyToken(String token) {
        try {
            // имитация дорогой операции (например криптография)
            Thread.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return token.hashCode() % 3 != 0; // часть невалидных
    }

    // Обработчик
    static class RequestHandler implements Runnable {
        private final TicketInventory inventory;
        private final AtomicInteger success;
        private final AtomicInteger failed;
        private final Random random = new Random();

        public RequestHandler(TicketInventory inventory,
                              AtomicInteger success,
                              AtomicInteger failed) {
            this.inventory = inventory;
            this.success = success;
            this.failed = failed;
        }

        @Override
        public void run() {
            String token = "user-" + random.nextInt(1_000_000);

            if (!verifyToken(token)) {
                failed.incrementAndGet();
                return;
            }

            if (inventory.tryBuyTicket()) {
                success.incrementAndGet();
            } else {
                failed.incrementAndGet();
            }
        }
    }

    // Тест
    public static void main(String[] args) throws InterruptedException {
        int totalTickets = 100_000;
        int requests = 1_000_000;
        int threads = Runtime.getRuntime().availableProcessors();

        TicketInventory inventory = new TicketInventory(totalTickets);
        AtomicInteger success = new AtomicInteger(0);
        AtomicInteger failed = new AtomicInteger(0);

        Thread[] pool = new Thread[threads];

        long start = System.currentTimeMillis();

        for (int t = 0; t < threads; t++) {
            pool[t] = new Thread(() -> {
                for (int i = 0; i < requests / threads; i++) {
                    new RequestHandler(inventory, success, failed).run();
                }
            });
            pool[t].start();
        }

        for (Thread t : pool) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("Success: " + success.get());
        System.out.println("Failed: " + failed.get());
        System.out.println("Remaining tickets: " + inventory.getRemaining());
        System.out.println("Time: " + (end - start) + " ms");
    }
}