import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String cipher, int code) {
     	return IntStream.iterate(code-1, i->i+code)
			.limit(cipher.length() / code)
			.mapToObj(cipher::charAt)
			.map(String::valueOf)
			.collect(Collectors.joining());
    }
}