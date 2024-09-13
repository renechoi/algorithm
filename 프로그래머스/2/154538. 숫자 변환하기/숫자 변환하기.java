import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        Queue<State> queue = new LinkedList<>(); 
        boolean[] visited = new boolean[y+1]; 
    
        queue.add(new State(x, 0)); 
        visited[x] = true; 
    
        while (!queue.isEmpty()) {
            State current = queue.poll(); 
            
            
            if (current.isTargetMatch(y)) {
                return current.count; 
            }
            
            current.stepAhead(queue, visited, n, y);
        }
        
        return -1;
    }
    
    static class State { 
        int value;
        int count;
        
        public static State of(int value, int count) {
            return new State(value, count);
        }
        
        public State(int value, int count) {
            this.value = value;
            this.count = count;
        }
        
        public boolean isTargetMatch(int y) {
            return this.value == y;
        }
      
        public void stepAhead(Queue<State> queue, boolean[] visited, int n, int y) {
            Arrays.stream(getNextValues(n))
                  .filter(next -> next <= y && !visited[next]) 
                  .forEach(next -> {
                      visited[next] = true; 
                      queue.add(State.of(next, count + 1)); 
                  });
        }
    
        private int[] getNextValues(int n) {
            return new int[] {value + n, value * 2, value * 3};
        }
    }
}
