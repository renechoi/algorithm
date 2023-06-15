package os.semaphore.producerandconsumer;

import os.semaphore.Semaphore;

class Producer extends Thread {
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;
    private int id;

    public Producer(Semaphore mutex, Semaphore empty, Semaphore full, int id) {
        this.mutex = mutex;
        this.empty = empty;
        this.full = full;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                // 생산 전에 빈 공간을 확인
                empty.acquire();
                mutex.acquire();

                // 생산 작업 수행
                System.out.println("생산자 " + id + "가 아이템을 생산합니다.");

                mutex.release();
                full.release();
                Thread.sleep(1000); // 임의의 작업 시간
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;
    private int id;

    public Consumer(Semaphore mutex, Semaphore empty, Semaphore full, int id) {
        this.mutex = mutex;
        this.empty = empty;
        this.full = full;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                // 소비 전에 채워진 아이템을 확인
                full.acquire();
                mutex.acquire();

                // 소비 작업 수행
                System.out.println("소비자 " + id + "가 아이템을 소비합니다.");

                mutex.release();
                empty.release();
                Thread.sleep(2000); // 임의의 작업 시간
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1); // 상호 배제를 위한 mutex 세마포어
        Semaphore empty = new Semaphore(5); // 비어있는 슬롯 개수를 추적하는 empty 세마포어
        Semaphore full = new Semaphore(0); // 채워진 슬롯 개수를 추적하는 full 세마포어

        // 생산자와 소비자 생성
        Producer producer = new Producer(mutex, empty, full, 1);
        Consumer consumer = new Consumer(mutex, empty, full, 1);

        // 생산자와 소비자 실행
        producer.start();
        consumer.start();

        // 메인 스레드는 생산자와 소비자가 종료될 때까지 대기
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
