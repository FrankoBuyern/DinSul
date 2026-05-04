import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class SensorProcessing {

    public static class SensorQueue {
        private final Queue<String> queue = new LinkedList<>();
        private final int capacity;

        public SensorQueue(int capacity) {
            this.capacity = capacity;
        }

        public synchronized void put(String line) throws InterruptedException {
            while (queue.size() >= capacity) {
                wait();
            }
            queue.add(line);
            notifyAll();
        }

        public synchronized String take() throws InterruptedException {
            while (queue.isEmpty()) {
                wait();
            }
            String line = queue.poll();
            notifyAll();
            return line;
        }
    }

    private static final String EOF = "EOF";

    public static class Producer implements Runnable {
        private final String filePath;
        private final SensorQueue queue;
        private final int consumersCount;

        public Producer(String filePath, SensorQueue queue, int consumersCount) {
            this.filePath = filePath;
            this.queue = queue;
            this.consumersCount = consumersCount;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    queue.put(line);
                }

                for (int i = 0; i < consumersCount; i++) {
                    queue.put(EOF);
                }

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Consumer implements Runnable {
        private final SensorQueue queue;
        private final AtomicLong anomalies;

        public Consumer(SensorQueue queue, AtomicLong anomalies) {
            this.queue = queue;
            this.anomalies = anomalies;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String line = queue.take();

                    if (EOF.equals(line)) {
                        break;
                    }

                    // "тяжёлый" парсинг
                    String[] parts = line.split(",");
                    if (parts.length != 2) continue;

                    double temp = Double.parseDouble(parts[1]);

                    if (temp > 50.0) {
                        anomalies.incrementAndGet();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Тестик 2
    public static void main(String[] args) throws InterruptedException {
        String filePath = "sensors.csv";
        int consumersCount = Runtime.getRuntime().availableProcessors();
        SensorQueue queue = new SensorQueue(1000);
        AtomicLong anomalies = new AtomicLong(0);

        Thread producer = new Thread(new Producer(filePath, queue, consumersCount));

        Thread[] consumers = new Thread[consumersCount];
        for (int i = 0; i < consumersCount; i++) {
            consumers[i] = new Thread(new Consumer(queue, anomalies));
        }

        long start = System.currentTimeMillis();

        producer.start();
        for (Thread c : consumers) c.start();

        producer.join();
        for (Thread c : consumers) c.join();

        long end = System.currentTimeMillis();

        System.out.println("Anomalies (>50): " + anomalies.get());
        System.out.println("Time: " + (end - start) + " ms");
    }
}