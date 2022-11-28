import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static Deque<Integer> deque = new ArrayDeque<>();
	public static int size = 0;
	public static int pushValue;
	public static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
		int N = Integer.parseInt(stringTokenizer.nextToken());

		stringBuilder = new StringBuilder();
		while (N -->0){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			String command = stringTokenizer.nextToken();
			if (command.equals("push")){
				pushValue = Integer.parseInt(stringTokenizer.nextToken());
			}
			Arrays.stream(DequeCommand.values())
					.filter(commands->commands.commandName.equals(command))
					.findFirst()
					.orElse(DequeCommand.NoneObject)
					.stackCommand.command();
		}

		System.out.println(stringBuilder);
	}

	public interface Command {
		void command();
	}

	public enum DequeCommand {
		pushCommand("push", new Command(){
			@Override
			public void command() {
				deque.offer(pushValue);
			}
		}),

		frontCommand("front", () -> {
			Integer front = deque.peek();
			if(front == null) {
				stringBuilder.append(-1).append('\n');
			}
			else {
				stringBuilder.append(front).append('\n');
			}
		}),

		backCommand("back", () -> {
			Integer last = deque.peekLast();
			if(last == null) {
				stringBuilder.append(-1).append('\n');
			}
			else {
				stringBuilder.append(last).append('\n');
			}
		}),

		sizeCommand("size", () -> {
			stringBuilder.append(deque.size()).append('\n');
		}),

		emptyCommand("empty", () -> {
			if(deque.isEmpty()) {
				stringBuilder.append(1).append('\n');
			}
			else {
				stringBuilder.append(0).append('\n');
			}
		}),

		popCommand("pop", () -> {
			Integer value = deque.poll();
			if(value == null) {
				stringBuilder.append(-1).append('\n');
			}
			else {
				stringBuilder.append(value).append('\n');
			}
		}),

		NoneObject("", () -> {
			throw new RuntimeException();
		});

		private final String commandName;
		private final Command stackCommand;

		DequeCommand(String commandName, Command stackCommand){
			this.commandName = commandName;
			this.stackCommand = stackCommand;
		}
	}

}
