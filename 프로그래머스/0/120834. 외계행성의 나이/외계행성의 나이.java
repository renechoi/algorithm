import java.util.stream.Collectors;
import java.util.Collections;
import java.util.stream.IntStream;

class Solution {
    public String solution(int age) {
        return IntStream.iterate(age, n -> n > 0, n -> n / 10)
                        .map(n -> n % 10)
                        .mapToObj(n -> String.valueOf((char) ('a' + n)))
                        .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                            Collections.reverse(list);
                            return String.join("", list);
                        }));
    }
}
