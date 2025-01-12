
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

		return new 데이터컬렉션(data).filter(ext, val_ext).sort(sort_by).toArray();
	}
	

	public static class 데이터컬렉션{
		private ArrayList<데이터> list;

		public 데이터컬렉션(ArrayList<데이터> list) {
			this.list = list;
		}
		
		public 데이터컬렉션(int[][] data) {
			list = new ArrayList<>();
			for(int[] d : data) {
				list.add(new 데이터(d));
			}
		}
		
		public int[][] toArray(){
			return this.list.stream().map(d -> new int[] {d.code, d.date, d.maximum, d.remain}).toArray(int[][]::new);
		}
		
		public 데이터컬렉션 filter(String ext, int val_ext){
			List<데이터> collect = list.stream().filter(d -> d.해당기준보다작은지(ext, val_ext)).collect(Collectors.toList());
			return new 데이터컬렉션(new ArrayList<>(collect));
		}
		
		public 데이터컬렉션 sort(String sort_by){
			if(sort_by.equals("code")) {
				list.sort(Comparator.comparingInt(a -> a.code));
			}
			else if(sort_by.equals("date")) {
				list.sort(Comparator.comparingInt(a -> a.date));
			}
			else if(sort_by.equals("maximum")) {
				list.sort(Comparator.comparingInt(a -> a.maximum));
			}
			else if(sort_by.equals("remain")) {
				list.sort(Comparator.comparingInt(a -> a.remain));
			}
			return this;
		}
	}


	public static class 데이터{
		private int code;
		private int date;
		private int maximum;
		private int remain;
		
		public 데이터 (int[] data){
			this.code = data[0];
			this.date = data[1];
			this.maximum = data[2];
			this.remain = data[3];
		}

		public 데이터(int code, int date, int maximum, int remain) {
			this.code = code;
			this.date = date;
			this.maximum = maximum;
			this.remain = remain;
		}

		public boolean 해당기준보다작은지(String ext, int val_ext) {
			if(ext.equals("code")) {
				return code < val_ext;
			}
			else if(ext.equals("date")) {
				return date < val_ext;
			}
			else if(ext.equals("maximum")) {
				return maximum < val_ext;
			}
			else if(ext.equals("remain")) {
				return remain < val_ext;
			}
			return false;
		}
	}

}
