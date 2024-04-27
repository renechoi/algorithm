import java.util.Arrays;
class Solution {
   public int solution(String my_string) {
        String[] numbers = my_string.split("[^0-9]+");

        return Arrays.stream(numbers)
            .filter(s -> !s.isEmpty())
            .mapToInt(Integer::parseInt)
            .sum();
    }
}