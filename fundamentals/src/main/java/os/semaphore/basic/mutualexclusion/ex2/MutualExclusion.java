package os.semaphore.basic.mutualexclusion.ex2;

import os.semaphore.Semaphore;

class SharedResource {
    private Semaphore mutex;

    public SharedResource() {
        // 세마포어의 초기값을 1로 설정하여 상호 배제를 구현
        mutex = new Semaphore(1);
    }

    public void accessResource(int processId) {
        try {
            System.out.println("프로세스 " + processId + "가 공유 자원에 접근합니다.");

            // 세마포어를 획득하고 공유 자원에 접근
            mutex.acquire();

            // 공유 자원에 대한 작업 수행
            System.out.println("프로세스 " + processId + "가 공유 자원을 사용 중입니다.");
            Thread.sleep(2000); // 임의의 작업 시간

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("프로세스 " + processId + "가 공유 자원 사용을 완료하였습니다.");

            // 세마포어를 해제하여 다른 프로세스가 접근할 수 있도록 함
            mutex.release();
        }
    }
}

class Process extends Thread {
    private int processId;
    private SharedResource sharedResource;

    public Process(int processId, SharedResource sharedResource) {
        this.processId = processId;
        this.sharedResource = sharedResource;
    }

    public void run() {
        sharedResource.accessResource(processId);
    }
}

public class MutualExclusion {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // 3개의 프로세스 생성
        Process process1 = new Process(1, sharedResource);
        Process process2 = new Process(2, sharedResource);
        Process process3 = new Process(3, sharedResource);

        // 각 프로세스 실행
        process1.start();
        process2.start();
        process3.start();
    }
}
