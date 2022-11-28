import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static ArrayList<Integer> stack = new ArrayList<>();
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
			Arrays.stream(StackCommand.values())
					.filter(commands->commands.commandName.equals(command))
					.findFirst()
					.orElse(StackCommand.NoneObject)
					.stackCommand.command();
		}

		System.out.println(stringBuilder);
	}

	public interface Command {
		void command();
	}

	public enum StackCommand {
		pushCommand("push", new Command(){
			@Override
			public void command() {
				stack.add(size, pushValue);
				Main.size++;
			}
		}),

		topCommand("top", () -> {
			if(size == 0) {
				stringBuilder.append("-1");
				stringBuilder.append("\n");
//				System.out.println("-1");
			}
			else {
				stringBuilder.append(stack.get(size-1));
				stringBuilder.append("\n");
//				System.out.println(stack.get(size-1));
			}
		}),

		sizeCommand("size", () -> {
//			System.out.println(size);
			stringBuilder.append(size);
			stringBuilder.append("\n");
		}),

		emptyCommand("empty", () -> {
			if(size == 0) {
//				System.out.println("1");
				stringBuilder.append("1");
				stringBuilder.append("\n");
			}
			else {
				stringBuilder.append("0");
				stringBuilder.append("\n");
//				System.out.println("0");
			}
		}),

		popCommand("pop", () -> {
			if(size == 0) {
				stringBuilder.append("-1");
				stringBuilder.append("\n");
//				System.out.println("-1");
			}
			else {
				int res = stack.get(size - 1);
				stack.set(size - 1, 0);
				size--;
				stringBuilder.append(res);
				stringBuilder.append("\n");
//				System.out.println(res);
			}
		}),

		NoneObject("", () -> {
			throw new RuntimeException();
		});

		private final String commandName;
		private final Command stackCommand;

		StackCommand(String commandName, Command stackCommand){
			this.commandName = commandName;
			this.stackCommand = stackCommand;
		}
	}

}
