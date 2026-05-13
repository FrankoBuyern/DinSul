import org.junit.jupiter.api.Test;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkBankTask {

    static class Transaction {
        long id;
        long amount;
        public Transaction(long id, long amount) { this.id = id; this.amount = amount; }
    }

    private long decryptPayload(Transaction t) {
        long hash = t.id;
        for (int i = 0; i < 50; i++) {
            hash = (hash * 31) + (t.amount % 17);
        }
        return t.amount;
    }

    public Transaction[] generateTransactions(int count) {
        Transaction[] txs = new Transaction[count];
        for (int i = 0; i < count; i++) {
            txs[i] = new Transaction(i, 10);
        }
        return txs;
    }

    static class BankAccount {

        private long balance;

        private final Lock lock = new ReentrantLock();

        public BankAccount(long initialBalance) {
            this.balance = initialBalance;
        }

        public long getBalance() {
            return balance;
        }

        public void withdraw(long amount) {

            lock.lock();

            try {

                balance -= amount;

            } finally {

                lock.unlock();
            }
        }
    }

    public void processSingleThread(Transaction[] txs, BankAccount account) {

        for (Transaction tx : txs) {

            long amount = decryptPayload(tx);

            account.withdraw(amount);
        }
    }

    public void processMultiThread(Transaction[] txs, BankAccount account, int threadsCount) throws InterruptedException {

        Thread[] threads = new Thread[threadsCount];

        int part = txs.length / threadsCount;

        for (int t = 0; t < threadsCount; t++) {

            int start = t * part;

            int end;

            if (t == threadsCount - 1) {
                end = txs.length;
            } else {
                end = start + part;
            }

            threads[t] = new Thread(() -> {

                for (int i = start; i < end; i++) {

                    long amount = decryptPayload(txs[i]);

                    account.withdraw(amount);
                }
            });

            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    @Test
    void testNetworkLoad() throws InterruptedException {

        int txCount = 5_000_000;
        Transaction[] txs = generateTransactions(txCount);
        long initialBalance = 100_000_000L;
        long expectedBalance = initialBalance - (txCount * 10L);

        // Замер однопоточки
        BankAccount accSingle = new BankAccount(initialBalance);
        long startSingle = System.currentTimeMillis();
        processSingleThread(txs, accSingle);
        long timeSingle = System.currentTimeMillis() - startSingle;

        // Замер многопоточки
        BankAccount accMulti = new BankAccount(initialBalance);
        long startMulti = System.currentTimeMillis();
        processMultiThread(txs, accMulti, 4);
        long timeMulti = System.currentTimeMillis() - startMulti;

        System.out.println("Network Single: " + timeSingle + " ms, Multi: " + timeMulti + " ms");

        assertEquals(expectedBalance, accSingle.getBalance(), "Однопоточный баланс неверен!");
        assertEquals(expectedBalance, accMulti.getBalance(), "Гонка данных! Многопоточный баланс неверен!");
        assertTrue(timeMulti < timeSingle, "Многопоточная версия неэффективна! Проверь, не обернул ли ты в Lock слишком много кода.");
    }
}