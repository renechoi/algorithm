package datastructure.stack.intstack;

public class IntStack {
	private int max;
	private int pointer;
	private int[] stack;

	public IntStack(int capacity) {
		pointer = 0;
		max = capacity;

		try {
			stack = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public int push(int value) {
		if (pointer >= max) {
			throw new OverflowIntStackException();
		}
		return stack[pointer++] = value;
	}

	public int pop() {
		if (pointer <= 0) {
			throw new EmptyIntStackException();
		}
		return stack[--pointer];
	}

	public int peek() {
		if (pointer <= 0) {
			throw new EmptyIntStackException();
		}
		return stack[pointer - 1];
	}

	public int indexOf(int x) {
		for (int i = pointer - 1; i >= 0; i--) {
			if (stack[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public void clear() {
		pointer = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return pointer;
	}

	public boolean isEmpty() {
		return pointer <= 0;
	}

	public boolean isFull(){
		return pointer>=max;
	}

	public void dump(){
		if (pointer<=0){
			System.out.println("스택이 비어 있습니다.");
			return;
		}
		for (int i =0; i< pointer;i++){
			System.out.println(stack[i]);
		}
	}

}
