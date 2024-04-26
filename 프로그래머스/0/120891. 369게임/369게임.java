import java.util.stream.*;

class Solution {
     public int solution(int order) {
        return (int) String.valueOf(order)
                     .chars() 
                     .mapToObj(c -> (char) c)  
                     .filter(this::isDigit369) 
                     .count(); 
    }
    
    private boolean isDigit369(char digit) {
        return digit == '3' || digit == '6' || digit == '9';
    }
}