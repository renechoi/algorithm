package datastructure.queue.intarrayqueue;

public class IntArrayQueueMain {
    public static void main(String[] args) {
        IntArrayQueue queue = new IntArrayQueue(5); // 용량(capacity)이 5인 큐 생성

        // 큐에 값 추가
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("큐의 크기: " + queue.size()); // 큐의 크기 출력: 5
        System.out.println("큐가 가득 찼는가? " + queue.isFull()); // 큐가 가득 찼는지 여부 출력: true

        System.out.println("큐의 맨 앞 요소: " + queue.peek()); // 큐의 맨 앞 요소 확인: 1


        int removedValue = queue.dequeue();         // 큐에서 값 제거
        System.out.println("제거한 값: " + removedValue); // 제거된 값 출력: 1

        System.out.println("큐의 크기: " + queue.size()); // 큐의 크기 출력: 4

        // 큐 비우기
        queue.clear();
        System.out.println("큐의 크기: " + queue.size()); // 큐의 크기 출력: 0
        System.out.println("큐가 비었는가? " + queue.isEmpty()); // 큐가 비어 있는지 여부 출력: true
    }
}
