package os.semaphore.readersandwriters.no1;

import os.semaphore.Semaphore;

class SharedResource {
    private Semaphore wrt;
    private Semaphore mutex;
    private int rCount;

    public SharedResource() {
        wrt = new Semaphore(1);
        mutex = new Semaphore(1);
        rCount = 0;
    }

    public void writeData() {
        try {
            wrt.acquire();

            // 공유 자원에 데이터 쓰기
            System.out.println("기록기가 공유 자원에 데이터를 씁니다.");

            wrt.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * rCount를 설정하는 부분을 임계영역으로 설정하는 이유:
     * rCount++;를 통해 1을 증가시키지만, 스레드가 동시적으로 수행되면서 "==1" 을 거치기 전에 바로 2가 되어 버리는 경우가 생길 수 있다.
     * 따라서 rCount 변수를 설정하고 if 문을 수행하는 과정은 판독기 스레드들이 공유 자원에 접근하기 전에 실행되어야 한다.
     * mutex.acquire()를 호출하여 임계 영역을 설정하여
     * rCount 변수와 if 문이 원자적(atomic)으로 실행되고 다른 스레드에 의해 방해받지 않는 환경을 보장한다.
     */

    public void readData() {
        try {
            mutex.acquire();
            rCount++;
            if (rCount == 1) {
                wrt.acquire();
            }
            mutex.release();

            // 공유 자원에서 데이터 읽기
            System.out.println("판독기가 공유 자원에서 데이터를 읽습니다.");

            mutex.acquire();
            rCount--;
            if (rCount == 0) {
                wrt.release();
            }
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Writer extends Thread {
    private SharedResource sharedResource;

    public Writer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        sharedResource.writeData();
    }
}

class Reader extends Thread {
    private SharedResource sharedResource;

    public Reader(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        sharedResource.readData();
    }
}

public class ReaderWriter {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // 기록기 생성 및 실행
        Writer writer = new Writer(sharedResource);
        writer.start();

        // 판독기 생성 및 실행
        Reader reader1 = new Reader(sharedResource);
        Reader reader2 = new Reader(sharedResource);
        reader1.start();
        reader2.start();

        // 메인 스레드는 모든 스레드가 종료될 때까지 대기
        try {
            writer.join();
            reader1.join();
            reader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
