import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String words = bufferedReader.readLine();
        ConcurrentMap alphabetMatches = identifier(words);

        List<Integer> answerSheet = new ArrayList<>();
        IntStream.rangeClosed('a', 'z')
                .mapToObj(i -> (char) i)
                .forEach(v -> {
                    Runnable getAlphabetList = alphabetMatches.containsKey(v) ?
                            () -> answerSheet.add(Integer.parseInt(alphabetMatches.get(v).toString())) :
                            () -> answerSheet.add(0);
                    getAlphabetList.run();
                });
        String answer = Arrays.toString(answerSheet.toArray());
        System.out.println(answer.replaceAll("[\\]\\[,]", ""));
    }

    private static ConcurrentMap identifier(String words) {
        ConcurrentMap<Character, LongAdder> occurances = new ConcurrentHashMap<>();
        for (char character : words.toCharArray()) {
            occurances.computeIfAbsent(character, ch -> new LongAdder()).increment();
        }
        return occurances;
    }
}
