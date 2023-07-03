package basic.array;

public class Array {
	public static void main(String[] args) {

	}

	/**
	 * 메모리가 연속적이기 때문에 arr의 시작 주소로부터 index 만큼 떨어진 주소를 바로 계산하므로
	 * 시간 복잡도 O(1)
	 */
	public static int getElement(int[] arr, int index) {
		return arr[index];
	}

	/**
	 * 인덱스 연산자를 통해 idx번 원소에 바로 접근이 가능하고, 바로 값을 변경하므로
	 * 시간 복잡도 O(1)
	 */
	public static void changeElement(int[] arr, int idx, int val) {
		arr[idx] = val;
	}

	/**
	 * 현재 배열에 담긴 원소의 개수를 알면 해당 인덱스에 요청받은 원소를 넣는다.
	 * 그런데 배열이 꽉 차 있다면 ?
	 * 배열은 고정 길이 이므로 길이를 늘릴 수 없다.
	 * 따라서 새로운 배열을 만들고 거기에 옮겨 넣어야 한다.
	 * <p>
	 * 체크하는 부분과 실제로 변경하는 연산 밖에 없으므로
	 * 시간 복잡도 O(1)
	 */
	public static boolean appendElement(int[] arr, int arrCount, int val) {
		if (arrCount == arr.length) {
			return false;
		}
		arr[arrCount] = val;
		return true;
	}

	/**
	 * 원소들이 연속된 배열의 중간에 원소를 집어 넣는다.
	 * 그러기 위해서는 추가되는 원소의 뒷 원소들이 한 칸씩 뒤로 이동해야 한다.
	 * <p>
	 * 4번 인덱스에 넣으려고 한다면, 5번부터 마지막까지 원소를 뒤로 한칸씩 민다.
	 * 만약 0번 인덱스에 넣고자 한다면 모든 원소들을 탐색해주어야 하므로
	 * 시간 복잡도는 O(N)
	 */
	public static boolean insertElement(int[] arr, int arrCount, int idx, int val) {
		if (idx > arrCount || arrCount >= arr.length) {
			return false;
		}
		for (int i = arrCount; i > idx; i--) {
			arr[i] = arr[i - 1];
		}
		arr[idx] = val;
		return true;
	}

	/**
	 * 삽입 때와는 반대로 삭제하고자 하는 해당 원소의 뒷 원소들을 모두 한 칸씩 앞으로 이동해야 한다.
	 * 따라서 시간 복잡도 O(N)
	 */
	public static boolean eraseElement(int[] arr, int arrCount, int idx){
		if (idx>=arrCount){
			return false;
		}
		for (int i = idx; i< arrCount; i++){
			arr[i] = arr[i +1];
		}
		return true;
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	private static void reverse(int start, int end, int[] arr) {
		int repeat = (end - start + 1) / 2;
		while (repeat-- > 0) {
			swap(start, end, arr);
			start++;
			end--;
		}
	}

	private static void reverse2(int start, int end, int[] arr) {
		int repeat = (end - start + 1) / 2;
		for (int i = 0; i < repeat; i++) {
			swap(start + i, end - i, arr);
		}
	}
}
