
class Solution {

	int removed =0;
	int count = 0 ;

	public int[] solution(String s) {

		이진반복(s);

        return new int[]{count,removed};
	}

	public void 이진반복(String s){
		if (s.equals("1")) {
			return;
		}
		count++;


		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == '0') {
				removed++;
			} else {
				sb.append(c);
			}
		}

		int len = sb.length();
		이진반복(Integer.toBinaryString(len)); 
	}
}