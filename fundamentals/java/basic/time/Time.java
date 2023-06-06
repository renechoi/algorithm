package basic.time;

public class Time {
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

	public Time calculateDifference(Time end) {
		int totalStartSeconds = this.hour * 3600 + this.minute * 60 + this.second;
		int totalEndSeconds = end.hour * 3600 + end.minute * 60 + end.second;

		int differenceSeconds = totalEndSeconds - totalStartSeconds;

		if (differenceSeconds <= 0) {
			differenceSeconds += 86400;  // 24시간(1일) 추가
		}

		int hourDifference = differenceSeconds / 3600;
		int minuteDifference = (differenceSeconds % 3600) / 60;
		int secondDifference = differenceSeconds % 60;

		return new Time(hourDifference, minuteDifference, secondDifference);
	}

	public Time calculateDifference2(Time end) {
		int hourDifference = end.hour - this.hour;
		int minuteDifference = end.minute - this.minute;
		int secondDifference = end.second - this.second;

		if (secondDifference <= 0) {
			secondDifference += 60;
			minuteDifference -= 1;
		}

		if (minuteDifference <= 0) {
			minuteDifference += 60;
			hourDifference -= 1;
		}

		if (hourDifference <= 0) {
			hourDifference += 24;
		}

		return new Time(hourDifference, minuteDifference, secondDifference);
	}

	private boolean isSecondLater(Time end) {
		return end.getSecond() > this.second;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}



