package chjTest.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest1Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
        System.out.println("모든 스레드 실행 완료");
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}


/**
 * 로그 출력 예측 & 총 실행시간?
 *
 * 1. 로그 출력 예측
 * - 10:50:00.000 [t1] 1
 * - 10:50:01.000 [t1] 2
 * - 10:50:02.000 [t1] 3
 * - 10:50:03.000 [t2] 1
 * - 10:50:04.000 [t2] 2
 * - 10:50:05.000 [t2] 3
 * - 10:50:06.000 [t3] 1
 * - 10:50:07.000 [t3] 2
 * - 10:50:08.000 [t3] 3
 * - 모든 스레드 실행 완료
 *
 * 2. 총 실행시간
 * - 약 9초
 */