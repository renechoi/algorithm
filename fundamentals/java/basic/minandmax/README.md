# FindMin 클래스
`FindMin` 클래스는 주어진 배열에서 최소값을 찾는 기능을 제공한다. 


## 메서드 findMin()

```java 
public static int findMin(int[] arr) {
	int min = arr[0];
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] < min) {
	    min = arr[i];
	    }
	}
	return min;
}
```

findMin 메서드는 다음과 같은 알고리즘을 사용하여 최소값을 찾는다:

1. 주어진 배열 arr의 첫 번째 요소를 초기 최소값(min)으로 설정한다.
2. 배열을 반복하면서 현재 요소가 min보다 작으면 min을 현재 요소로 갱신한다.
3. 반복이 완료되면 min을 반환한다.

이 알고리즘은 배열의 모든 요소를 한 번씩 비교하여 최소값을 찾는다. 




<br>

## 시간 복잡도

이 알고리즘의 시간 복잡도를 Big-O 표기법으로 분석하면 O(n)이다.

findMin 메서드에서 가장 핵심적인 연산은 for 루프 내부의 비교 연산이다:

```java
for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i];
    }
}
```

이 코드는 배열의 길이에 따라 반복하며, 배열의 모든 요소에 대해 비교 연산을 수행한다. 
따라서 배열의 크기를 n이라고 할 때, 비교 연산은 최대 n-1번 수행된다.
<br>
<br>
배열의 크기에 비례하여 시간이 증가하므로 시간 복잡도는 O(n)으로 표기된다. 
즉, 입력 크기에 비례하여 선형적으로 실행 시간이 증가한다.

<br>

## 사용 예시
```java
public static void main(String[] args) {
	int[] numbers = {5, 8, 2, 9, 1};
	System.out.println("최소값: " + findMin(numbers));
	}
```

```java
최소값: 1
```



----

# FindMax 클래스
`FindMax` 클래스는 주어진 배열에서 최대값을 찾는 기능을 제공한다.


## 메서드 findMax()

```java 
public static int findMax(int[] arr) {
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < arr.length; i++) {
	    if (max < arr[i]) {
	    max = arr[i];
	    }
	}
	return max;
}
```
`findMax`메서드는 다음과 같은 알고리즘을 사용하여 최대값을 찾는다:

1. 주어진 배열 `arr`의 첫 번째 요소를 초기 최대값(max)으로 설정한다.
2. 배열을 반복하면서 현재 요소가 `max`보다 크면 `max`를 현재 요소로 갱신한다.
3. 반복이 완료되면 `max`를 반환한다.
이 알고리즘은 배열의 모든 요소를 한 번씩 비교하여 최대값을 찾는다.

<br>

## 시간 복잡도

이 알고리즘의 시간 복잡도를 Big-O 표기법으로 분석하면 O(n)이다.

`findMax` 메서드에서 가장 핵심적인 연산은 for 루프 내부의 비교 연산이다:

```java
for (int i = 0; i < arr.length; i++) {
    if (max < arr[i]) {
        max = arr[i];
    }
}
```
이 코드는 배열의 길이에 따라 반복하며, 배열의 모든 요소에 대해 비교 연산을 수행한다. 
따라서 배열의 크기를 n이라고 할 때, 비교 연산은 최대 n-1번 수행된다.
<br>
<br>
배열의 크기에 비례하여 시간이 증가하므로 시간 복잡도는 O(n)으로 표기된다. 
즉, 입력 크기에 비례하여 선형적으로 실행 시간이 증가한다.


<br>

## 사용 예시
```java
int[] numbers = {0, 10, 7, 5, 6};
System.out.println("최대값: " + findMax(numbers));

int[] numbers2 = {-5, -2, 5, 0, -1};
System.out.println("최대값: " + findMax(numbers2));

int[] numbers3 = {-5, -2, -10, -4, -3};
System.out.println("최대값: " + findMax(numbers3));

int[] numbers4 = {-12, -50, 1, 4, 3};
System.out.println("최대값: " + findMax(numbers4));

int[] numbers5 = {12, 13};
System.out.println("최대값: " + findMax(numbers5));
```

```java
최대값: 10
최대값: 5
최대값: -2
최대값: 4
```