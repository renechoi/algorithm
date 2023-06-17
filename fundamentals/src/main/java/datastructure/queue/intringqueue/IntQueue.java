package datastructure.queue.intringqueue;

public class IntQueue {
	private int max;
	private int front;
	private int rear;
	private int currentCounts;
	private int[] queue;

	public IntQueue(int capacity) {
		currentCounts = 0;
		front = 0;
		rear = 0;
		this.max = capacity;

		try {
			queue = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	/**
	 * 큐에 데이터를 인큐한다. 인큐에 성공하면 인큐한 값을 그대로 반한한다. 그러나 큐가 가득차서 인큐할 수 없다면 예외를 던진다.
	 *
	 * 인큐하기 전의 rear 값이 배열의 끝 값이라면 이후의 reqr 값이 배열의 마지막 요소를 초과하여 가리키 않도록 rear의 값이 max와 같아지면 그 다음 순번은 배열의 처음인 0으로 변경해준다.
	 * @param value
	 * @return
	 */
	public int enque(int value) {
		if (currentCounts >= max) {
			throw new IllegalStateException("큐가 가득 찼습니다");
		}
		queue[rear++] = value;
		currentCounts++;

		if (rear == max) {
			rear = 0;
		}
		return value;
	}

	/**
	 * 큐에서 데이터를 디큐하고 그 값을 반환한다. 큐가 비어있으면 예외를 던진다.
	 *
	 * 디큐 하기 전의 front 값이 배열의 끝 값이라면 이후의 front 값이 배열의 마지막 요소를 초과하여 가리키지 않도록 front의 값이 max와 같아지면 그 다음 순번은 배열의 0으로 변경해준다.
	 * @return
	 */
	public int deque(){
		if (currentCounts<=0){
			throw new IllegalStateException("큐가 비어 있습니다");
		}
		int value = queue[front++];
		currentCounts--;

		if (front==max){
			front =0;
		}
		return value;
	}

	public int peek(){
		if (currentCounts<=0){
			throw  new IllegalStateException("큐가 비어 있습니다");
		}
		return queue[front];
	}

	/**
	 * 큐의 배열에서 value 값이 저장되어 있는 위치를 알아낸다.
	 *
	 * front에서 rear로 선형 탐색을 수행한다. 스캔의 시작은 배열의 첫 요소가 아니라 큐의 첫 요소, 즉 프런트이다.
	 * 따라서 idx의 계산은 (i + front) % max이다.
	 * @param value
	 * @return
	 */

	public int indexOf(int value){
		for (int i =0; i< currentCounts; i++){
			int idx = (i + front) % max;
			if (queue[idx] == value){
				return idx;
			}
		}
		return -1;
	}

	public void clear(){
		currentCounts = 0;
		front =0;
		rear=0;
	}

	public int capacity(){
		return max;
	}

	public int size(){
		return currentCounts;
	}

	public boolean isEmpty(){
		return currentCounts<=0;
	}

	public boolean isFull(){
		return currentCounts>=max;
	}


	public void dump(){
		if (currentCounts<=0){
			throw new IllegalStateException("큐가 비어 있습니다");
		}

		for (int i =0; i< currentCounts;i++){
			System.out.println(queue[(i + front) % max]);
		}
	}



}
