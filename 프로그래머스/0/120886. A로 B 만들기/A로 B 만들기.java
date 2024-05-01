class Solution {
     public int solution(String before, String after) {
        if (before.length() != after.length()) return 0;

        int[] frequency = new int[26];
        calculateFrequency(before, frequency, 1);
        calculateFrequency(after, frequency, -1);

        return hasNegativeFrequency(frequency) ? 0 : 1;
    }

    private void calculateFrequency(String str, int[] frequency, int updateFactor) {
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i) - 'a'] += updateFactor;
        }
    }

    private boolean hasNegativeFrequency(int[] frequency) {
        for (int freq : frequency) {
            if (freq < 0) {
                return true;
            }
        }
        return false;
    }
}