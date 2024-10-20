import java.util.*;

class Solution {
    	public String solution(String[] participant, String[] completion) {


		HashMap<String, Integer> 완주자맵  = new HashMap<>();

		for (String 완주자 : completion) {
			완주자맵.put(완주자, 완주자맵.getOrDefault(완주자, 0)+1);
		}

		for (String 참가자 : participant) {

			if(!완주자맵.containsKey(참가자) || 완주자맵.get(참가자) == 0){
				return 참가자;
			}

			완주자맵.put(참가자, 완주자맵.get(참가자)-1);
		}

		return "Notfound";
	}
}