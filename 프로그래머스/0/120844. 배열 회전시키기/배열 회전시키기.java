import java.util.Deque;
import java.util.LinkedList;

class Solution {
     public int[] solution(int[] numbers, String direction) {
        Deque<Integer> dq = new LinkedList<>();
        for (int num : numbers) {
            dq.addLast(num);
        }

        if ("right".equals(direction)) {
            dq.addFirst(dq.removeLast());           
        } else {
            dq.addLast(dq.removeFirst());            
        }

        int[] answer = new int[numbers.length];
        int idx = 0;
        for (int num : dq) {
            answer[idx++] = num;
        }
        return answer;
    }
}