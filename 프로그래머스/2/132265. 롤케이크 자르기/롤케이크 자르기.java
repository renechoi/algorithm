import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> 형케이크 = new HashMap<>();
        for (int t: topping) {
            형케이크.put(t, 형케이크.getOrDefault(t, 0)+1);
        }
        HashSet<Integer> 동생케이크 = new HashSet<>();
        int answer = 0;
        for (int t : topping) {
            동생케이크.add(t);
            형케이크.put(t, 형케이크.get(t) - 1);
            if (형케이크.get(t) == 0) {
                형케이크.remove(t);
            }
            if (동생케이크.size() == 형케이크.size()) {
                answer++;
            }
        }
        return answer;
    }
}