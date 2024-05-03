class Solution {
    public String solution(String s) {
        int[] frequency = new int[26];
        
         for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 1) {
                result.append((char) (i + 'a'));
            }
        }
        
        return result.toString();
    }
}