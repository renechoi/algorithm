import java.util.stream.Collectors;

class Solution {
    public String solution(String rsp) {
        return rsp.chars()  
                   .mapToObj(c -> (char) c)  
                   .map(this::winningMove) 
                   .map(String::valueOf)  
                   .collect(Collectors.joining());
    }

    private char winningMove(char rsp) {
        switch (rsp) {
            case '0': // win: 바위 -> 보 
                return '5';
            case '2': // win: 가위 -> 바위 
                return '0';
            case '5': // win: 보 -> 가위
                return '2';
            default:
                throw new IllegalArgumentException("");
        }
    }
}
