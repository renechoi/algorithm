import java.util.LinkedList;
import java.util.List;

class Solution {

    boolean solution(String s) {

        List<Character> list = new LinkedList<>();

        char[] brackets = s.toCharArray();
        for (char bracket : brackets) {

            if (bracket == '(') {
                // 중간에 삽입할 경우 성능 저하 (O(n))
                list.add(0, bracket);  // 비효율적인 삽입
                continue;
            }

            if (bracket == ')' && !list.isEmpty()) {
                // 중간에서 삭제할 경우 성능 저하 (O(n))
                list.remove(list.size() - 1);  // 비효율적인 삭제
            } else {
                return false;
            }
        }

        return list.isEmpty();
    }
}
