import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        while (deque.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                deque.offerLast(deque.pollFirst());
            }
            stringBuilder.append(deque.pollFirst()).append(", ");
        }
        stringBuilder.append(deque.pollFirst());
        stringBuilder.append(">");

        System.out.println(stringBuilder);
    }
}