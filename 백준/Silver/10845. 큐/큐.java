import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Deque<Integer> queue;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());
        queue = new ArrayDeque<>();

        stringBuilder = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            switch (command) {
                case "push":
                    handlePushCommand(Integer.parseInt(stringTokenizer.nextToken()));
                    continue;
                case "pop":
                    stringBuilder.append(handlePopCommand()).append("\n");
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


    private static void handlePushCommand(int number) {
        queue.add(number);
    }

    private static Integer handlePopCommand() {
        try {
            return queue.pop();
        } catch (NoSuchElementException e) {
            return -1;
        }
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
        try {
            return queue.getFirst();
        } catch (NoSuchElementException e) {
            return -1;
        }
    }

    private static Integer handleBackCommand() {
        try {
            return queue.getLast();
        } catch (NoSuchElementException e) {
            return -1;
        }
    }
}