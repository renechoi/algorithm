import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int documents = Integer.parseInt(stringTokenizer.nextToken());
            int queryDocument = Integer.parseInt(stringTokenizer.nextToken());

            Deque<Integer> documentDeque = new ArrayDeque<>();
            Deque<Integer> priorityDeque = new ArrayDeque<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < documents; j++) {
                documentDeque.offer(j);
                priorityDeque.offer(Integer.valueOf(stringTokenizer.nextToken()));
            }

            printerSolution(queryDocument, documentDeque, priorityDeque);
        }
    }

    private static void printerSolution(int queryDocument, Deque<Integer> deque, Deque<Integer> priorityDeque) {
        int count = 1;

        while (!deque.isEmpty()) {
            int max = Collections.max(priorityDeque);
            int documentIndex = deque.pollFirst();
            int documentPriority = priorityDeque.pollFirst();

            if (documentPriority != max) {
                deque.offerLast(documentIndex);
                priorityDeque.offerLast(documentPriority);
            } else {
                if (documentIndex == queryDocument) {
                    System.out.println(count);
                    break;
                }
                count++;
            }
        }
    }
}
