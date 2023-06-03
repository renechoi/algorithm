# Swap 클래스
`Swap` 클래스는 배열 내 요소를 교환하기 위한 메서드를 제공한다.

## 메서드 swap()

```java 
public static <T> void swap(T[] array, int i, int j){};
```


지정된 배열에서 두 개의 요소를 교환한다.

#### 매개변수
- `array`: 교환을 수행할 배열
- `i`: 교환할 첫 번째 요소의 인덱스
- `j`: 교환할 두 번째 요소의 인덱스

#### 타입 매개변수
- `T`: 배열 내 요소의 타입

<br>

## 메서드 swapExample()

```java
private static <T> void swapExample(T[] array)
```

배열 내 요소를 교환하는 예시 메서드. swap 후 수정된 배열을 출력한다.

#### 매개변수
- `array`: 요소를 교환할 배열

#### 타입 매개변수
- `T`: 배열 내 요소의 타입

<br>

## 사용 예시 
```java
public static void main(String[] args) {
    swapExample(new Integer[]{1, 2});
    swapExample(new String[]{"a", "b"});
}
```

위의 예시는 `Swap 클래스`를 사용하는 방법에 대한 예시이다. 
`swapExample` 메서드를 호출하여 배열의 요소를 교환하고, 교환 후 수정된 배열이 출력된다. 
각각 `Integer` 배열과 `String` 배열에 대한 예시를 제공하였다.

