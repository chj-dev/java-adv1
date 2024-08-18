package chjTest.start;

import static util.MyLogger.log;

public class StartTest1Main {

    public static void main(String[] args) {
        CounterThread ct = new CounterThread();
        ct.start();
    }

    private static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
