
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String[] startTimes = bufferedReader.readLine().split(":");
		String[] endTimes = bufferedReader.readLine().split(":");

		int startHour = Integer.parseInt(startTimes[0]);
		int startMinute = Integer.parseInt(startTimes[1]);
		int startSecond = Integer.parseInt(startTimes[2]);

		int endHour = Integer.parseInt(endTimes[0]);
		int endMinute = Integer.parseInt(endTimes[1]);
		int endSecond = Integer.parseInt(endTimes[2]);

		Time start = new Time(startHour, startMinute, startSecond);
		Time end = new Time(endHour, endMinute, endSecond);

		Time difference = start.calculateDifference2(end);
		System.out.println(difference);
	}

	static class Time {
		private int hour;
		private int minute;
		private int second;

		public Time() {
		}

		public Time(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}

		public Time calculateDifference1(Time end) {
			int hourDifference = end.hour - this.hour;
			int minuteDifference = end.minute - this.minute;
			int secondDifference = end.second - this.second;

			if (secondDifference < 0 ){
				secondDifference += 60;
				minuteDifference -=1;
			}

			if (minuteDifference<0){
				minuteDifference += 60;
				hourDifference -=1;
			}

			if (hourDifference< 0){
				hourDifference +=24;
			}

			return new Time(hourDifference, minuteDifference, secondDifference);
		}


		public Time calculateDifference2(Time end) {
			int totalStartSeconds = this.hour * 3600 + this.minute * 60 + this.second;
			int totalEndSeconds = end.hour * 3600 + end.minute * 60 + end.second;

			int differenceSeconds =totalEndSeconds - totalStartSeconds ;

			if (differenceSeconds <= 0) {
				differenceSeconds += 86400;  // 24시간(1일) 추가
			}

			int hourDifference = differenceSeconds / 3600;
			int minuteDifference = (differenceSeconds % 3600) / 60;
			int secondDifference = differenceSeconds % 60;

			return new Time(hourDifference, minuteDifference, secondDifference);
		}

		@Override
		public String toString() {
			return String.format("%02d:%02d:%02d", hour, minute,second);
		}
	}
}
