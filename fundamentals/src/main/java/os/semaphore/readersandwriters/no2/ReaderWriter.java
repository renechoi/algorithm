package os.semaphore.readersandwriters.no2;

import os.semaphore.Semaphore;

class SharedResource {
    private Semaphore rd;
    private Semaphore wrt;
    private Semaphore mutex1;
    private Semaphore mutex2;
    private Semaphore mutex3;
    private int rCount;
    private int wCount;

    public SharedResource() {
        rd = new Semaphore(1);
        wrt = new Semaphore(1);
        mutex1 = new Semaphore(1);
        mutex2 = new Semaphore(1);
        mutex3 = new Semaphore(1);
        rCount = 0;
        wCount = 0;
    }

    public void writeData() {
        try {
            mutex2.acquire();
            wCount++;
            if (wCount == 1) {
                rd.acquire();
            }
            mutex2.release();

            wrt.acquire();

            // 공유 자원에 데이터 쓰기
            System.out.println("기록기가 공유 자원에 데이터를 씁니다.");

            wrt.release();

            mutex2.acquire();
            wCount--;
            if (wCount == 0) {
                rd.release();
            }
            mutex2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            mutex3.acquire();
            rd.acquire();
            mutex1.acquire();
            rCount++;
            if (rCount == 1) {
                wrt.acquire();
            }
            mutex1.release();
            rd.release();
            mutex3.release();

            // 공유 자원에서 데이터 읽기
            System.out.println("판독기가 공유 자원에서 데이터를 읽습니다.");

            mutex1.acquire();
            rCount--;
            if (rCount == 0) {
                wrt.release();
            }
            mutex1.release();
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
