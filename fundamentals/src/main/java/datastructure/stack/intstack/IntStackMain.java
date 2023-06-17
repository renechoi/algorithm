package datastructure.stack.intstack;

public class IntStackMain {

	public static void main(String[] args) {
		IntStack stack = new IntStack(5);

		// 스택에 값 추가
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		// 스택 정보 출력
		System.out.println("스택 크기: " + stack.size());
		System.out.println("스택이 비어있는가? " + stack.isEmpty());
		System.out.println("스택이 가득차있는가? " + stack.isFull());

		// 스택에서 값 가져오기
		int poppedValue = stack.pop();
		System.out.println("꺼낸 값: " + poppedValue);

		// 스택의 가장 위에 있는 값 확인
		int topValue = stack.peek();
		System.out.println("가장 위의 값: " + topValue);

		// 스택에서 값의 인덱스 확인
		int valueToFind = 30;
		int index = stack.indexOf(valueToFind);
		System.out.println(valueToFind + "의 인덱스: " + index);

		// 스택 초기화
		stack.clear();

		// 스택 정보 출력
		System.out.println("스택 크기: " + stack.size());
		System.out.println("스택이 비어있는가? " + stack.isEmpty());
		System.out.println("스택이 가득차있는가? " + stack.isFull());
	}
}
