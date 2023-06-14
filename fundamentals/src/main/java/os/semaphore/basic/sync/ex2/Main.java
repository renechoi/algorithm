package os.semaphore.basic.sync.ex2;

import os.semaphore.Semaphore;

class SharedResource {
    private Semaphore semaphoreMutex;

    public SharedResource() {
        // 세마포어의 초기값을 0으로 설정하여 동기화 문제를 해결
        semaphoreMutex = new Semaphore(0);
    }

    public void processA() {
        try {
            System.out.println("프로세스 A가 작업을 수행합니다.");

            // 프로세스 A 작업 수행

            // 세마포어를 릴리즈하여 프로세스 B가 실행될 수 있도록 함
            semaphoreMutex.release();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processB() {
        try {
            // 세마포어를 획득하여 프로세스 A가 작업을 완료할 때까지 대기
            semaphoreMutex.acquire();
            
            System.out.println("프로세스 B가 작업을 수행합니다.");

            // 프로세스 B 작업 수행

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // 프로세스 A 생성 및 실행
        Thread processA = new Thread(() -> {
            sharedResource.processA();
        });

        // 프로세스 B 생성 및 실행
        Thread processB = new Thread(() -> {
            sharedResource.processB();
        });

        // 프로세스 A와 B 실행
        processA.start();
        processB.start();

        // 메인 스레드는 프로세스 A와 B가 모두 종료될 때까지 대기
        try {
            processA.join();
            processB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("작업이 완료되었습니다.");
    }
}
