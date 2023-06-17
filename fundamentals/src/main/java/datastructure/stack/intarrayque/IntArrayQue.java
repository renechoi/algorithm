package datastructure.stack.intarrayque;

public class IntArrayQue {
	private int max;
	private int pointer;
	private int[] que;

	public IntArrayQue(int capacity) {
		max = capacity;
		pointer = 0;
		que = new int[max];
	}

	public void enqueue(int value) {
		if (pointer >= max) {
			throw new IllegalStateException("큐가 가득 찼습니다.");
		}
		que[pointer++] = value;
	}

	public int dequeue() {
		if (pointer <= 0) {
			throw new IllegalStateException("큐가 비어 있습니다.");
		}
		int value = que[0];
		reconstruct();
		pointer--;
		return value;
	}

	public int peek() {
		if (pointer <= 0) {
			throw new IllegalStateException("큐가 비어 있습니다.");
		}
		return que[0];
	}

	public boolean isEmpty() {
		return pointer == 0;
	}

	public boolean isFull() {
		return pointer == max;
	}

	public int size() {
		return pointer;
	}

	public void clear() {
		pointer = 0;
	}

	private void reconstruct() {
		for (int i = 1; i < pointer; i++) {
			que[i - 1] = que[i];
		}
		que[pointer - 1] = 0;
	}

}
