import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int solution(int[] array, int n) {
        HashMap<Integer, Integer> diffMap = fillDifferenceMap(array, n);
        int minDiff = findMinimumDifference(diffMap);
        return diffMap.get(minDiff);
    }

    private HashMap<Integer, Integer> fillDifferenceMap(int[] array, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            int diff = Math.abs(num - n);
            if (!map.containsKey(diff) || map.get(diff) > num) {
                map.put(diff, num);
            }
        }
        return map;
    }

    private int findMinimumDifference(HashMap<Integer, Integer> map) {
        return Collections.min(map.keySet());
    }
}
