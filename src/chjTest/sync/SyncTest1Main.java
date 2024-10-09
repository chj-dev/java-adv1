package chjTest.sync;

import thread.sync.test.SyncTest1BadMain;

public class SyncTest1Main {
    public static void main(String[] args) throws InterruptedException {
        SyncTest1Main.Counter counter = new SyncTest1Main.Counter();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("결과: " + counter.getCount());
    }

    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count = count + 1;
        }

        public int getCount() {
            return count;
        }
    }
}
