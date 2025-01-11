
public class Solution {
	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		Video video = new Video(video_len, pos, op_start, op_end);

		for (String c : commands) {
			command cmd = new command(c);
			if (cmd.isPrev()) {
				video.goPrev();
			} else if (cmd.isNext()) {
				video.goNext();
			}
		}

		return video.getCurrentPositionTime();
	}


	public static class Video {
		private int start = 0;
		private int end;
		private int pos;

		private int opStart;
		private int opEnd;

		public Video(String video_len, String pos, String op_start, String op_end) {
			this.end = toSeconds(video_len);
			this.opStart = toSeconds(op_start);
			this.opEnd = toSeconds(op_end);
			this.pos = toSeconds(pos);

			this.pos = isCurrentOpeningSectionThenGoToTheOpEnd(this.pos);
		}


		private int isCurrentOpeningSectionThenGoToTheOpEnd(int currentPos) {
			if (currentPos >= opStart && currentPos <= opEnd) {
				return opEnd;
			}
			return currentPos;
		}


		public void goPrev() {
			this.pos -= 10;
			if (this.pos < start) {
				this.pos = start;
			}
			this.pos = isCurrentOpeningSectionThenGoToTheOpEnd(this.pos);
		}


		public void goNext() {
			this.pos += 10;
			if (this.pos > end) {
				this.pos = end;
			}
			this.pos = isCurrentOpeningSectionThenGoToTheOpEnd(this.pos);
		}


		public String getCurrentPositionTime() {
			return toTimeString(this.pos);
		}


		private int toSeconds(String time) {
			String[] arr = time.split(":");
			int mm = Integer.parseInt(arr[0]);
			int ss = Integer.parseInt(arr[1]);
			return mm * 60 + ss;
		}


		private String toTimeString(int totalSeconds) {
			int mm = totalSeconds / 60;
			int ss = totalSeconds % 60;
			return String.format("%02d:%02d", mm, ss);
		}
	}



	public static class command {
		private String cmd;

		public command(String cmd) {
			this.cmd = cmd;
		}

		public boolean isPrev() {
			return cmd.equals("prev");
		}

		public boolean isNext() {
			return cmd.equals("next");
		}
	}
}