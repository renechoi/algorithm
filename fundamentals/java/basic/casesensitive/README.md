# FindCaseSensitive 클래스
`FindCaseSensitive` 클래스는 대소문자를 판별하는 기능을 제공한다.


## 메서드 isUpperCase()

```java 
public static boolean isUpperCase(Character character){
        return character < 97;
        }
```

isUpperCase() 메서드는 주어진 문자가 대문자인지 여부를 판별하는 기능을 제공한다. 
메서드 내부에서는 주어진 문자(character)가 'a'의 아스키 값보다 작으면 대문자로 간주되며, true 값을 반환한다. 
그렇지 않은 경우에는 소문자로 간주되며, false 값을 반환한다.


## 메서드 isLowerCase()

```java 
public static boolean isLowerCase(Character character){
		return character >= 97;
	}
```

isLowerCase() 메서드는 주어진 문자가 소문자인지 여부를 판별하는 기능을 제공한다. 
메서드 내부에서는 주어진 문자(character)가 'a'의 아스키 값과 같거나 크면 소문자로 간주되며, true 값을 반환한다. 
그렇지 않은 경우에는 대문자로 간주되며, false 값을 반환한다.

<br>


<br>

## 사용 예시
```java
public static void main(String[] args) {
        Character testCase1 = 'a';
        Character testCase2 = 'B';

        System.out.println(isLowerCase(testCase1));
        System.out.println(isUpperCase(testCase1));

        System.out.println(isLowerCase(testCase2));
        System.out.println(isUpperCase(testCase2));
        }
```

```java
true
false
false
true 
```


----

# ConvertToCase 클래스
`ConvertToCase` 클래스는 문자의 대소문자를 변환하는 기능을 제공한다.


## 메서드 convert()

```java 
private static Character convert(Character character){
        if (FindCaseSensitive.isUpperCase(character)){
            return toLowerCase(character);
        }
        return toUpperCase(character);
        }
```
convert() 메서드는 주어진 문자의 대소문자를 변환하는 기능을 제공한다. 
메서드 내부에서는 주어진 문자(character)가 대문자인지 여부를 FindCaseSensitive.isUpperCase() 메서드를 통해 판별하고, 
대문자인 경우 toLowerCase() 메서드를 호출하여 소문자로 변환한다. 

그렇지 않은 경우에는 소문자인 경우 toUpperCase() 메서드를 호출하여 대문자로 변환하고 변환된 문자를 반환한다.
<br>

## 메서드 toUpperCase()

```java 
private static Character toUpperCase(Character character){
        return  (char)(character - 32);
        }
```
toUpperCase() 메서드는 주어진 소문자 문자(character)를 대문자로 변환한다. 
변환은 해당 문자의 아스키 코드에서 32를 빼는 것으로 이루어지며, 변환된 대문자를 반환한다.

<br>

## 메서드 toUpperCase()

```java 
private static Character toLowerCase(Character character){
        return  (char)(character + 32);
        }
```
toLowerCase() 메서드는 주어진 대문자 문자(character)를 소문자로 변환한다. 
변환은 해당 문자의 아스키 코드 값에 32를 더하는 것으로 이루어지며, 

변환된 소문자를 반환한다.

<br>

## 시간 복잡도

시간 복잡도는 각 메서드마다 O(1)이다. 

이는 입력에 관계없이 동일한 수행 시간을 갖는다는 것을 의미한다.

<br>

## 사용 예시
```java
 public static void main(String[] args) {
     Character testCase1 = 'a';
     Character testCase2 = 'B';

     System.out.println(convert(testCase2));
     System.out.println(convert(testCase1));
     }
```

```java
b
A
```