import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        IntStream.range(0, a.length()).forEach(i -> {
            System.out.println(a.charAt(i));}
                                       );
    }
}