import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());
        queue = new ArrayDeque<>(10001);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            switch (command) {
                case "push_front":
                    handlePushFrontCommand(Integer.parseInt(stringTokenizer.nextToken()));
                    continue;
                case "push_back":
                    handlePushBackCommand(Integer.parseInt(stringTokenizer.nextToken()));
                    continue;
                case "pop_front":
                    stringBuilder.append(handlePopFrontCommand()).append("\n");
                    continue;
                case "pop_back":
                    stringBuilder.append(handlePopBackCommand()).append("\n");
                    continue;
                case "size":
                    stringBuilder.append(handleSizeCommand()).append("\n");
                    continue;
                case "empty":
                    stringBuilder.append(handleEmptyCommand()).append("\n");
                    continue;
                case "front":
                    stringBuilder.append(handleFrontCommand()).append("\n");
                    continue;
                case "back":
                    stringBuilder.append(handleBackCommand()).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    private static void handlePushFrontCommand(int number) {
        queue.addFirst(number);
    }

    private static void handlePushBackCommand(int number) {
        queue.addLast(number);
    }

    private static Integer handlePopFrontCommand() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.pollFirst();
    }

    private static Integer handlePopBackCommand() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.pollLast();
    }

    private static Integer handleSizeCommand() {
        return queue.size();
    }

    private static Integer handleEmptyCommand() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static Integer handleFrontCommand() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peekFirst();
    }

    private static Integer handleBackCommand() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peekLast();
    }
}