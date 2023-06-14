package os.semaphore;

public class Semaphore {
    private int permits;

    public Semaphore(int initialPermits) {
        permits = initialPermits;
    }

    /**
     * 허용된 자원의 개수(permits)가 0 이하인 경우 스레드를 대기 상태로 전환 시키는 역할을 한다.
     *
     * wait(): 스레드를 일시적으로 대기 상태로 전환한다.
     * 스레드는 wait() 메서드를 호출하면 해당 객체의 모니터(lock)를 해제하고 대기 상태로 들어간다.
     * 대기 상태에서는 다른 스레드가 해당 객체의 모니터를 획득하여 작업을 수행할 수 있다.
     * 스레드가 wait() 상태에 있을 때는 notify() 또는 notifyAll() 메서드에 의해 깨어나 실행을 재개하게 된다.
     * @throws InterruptedException
     */
    public synchronized void acquire() throws InterruptedException {
        while (permits <= 0) {
            wait();
        }
        permits--;
    }

    /**
     * 자원을 해제하고 대기중인 스레드의 실행이 제기되도록 호출한다.
     *
     * notify(): 대기 중인 스레드 중 하나를 깨운다.
     * 깨어난 스레드는 wait() 메서드 이후부터 실행을 재개하며, wait() 호출 이후의 문장부터 실행된다.
     * 여러 스레드가 대기 중이라면 어떤 스레드가 깨어날지는 정해져 있지 않다.
     */
    public synchronized void release() {
        permits++;
        notify();
    }
}