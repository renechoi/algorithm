import java.util.*; 

public class Main{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int price =       sc.nextInt();
        
        int change = 1000 - price; 
        
        int[] coinTypes = {500, 100, 50, 10, 5, 1};
        
        int answer =0; 
        
        for (int coin: coinTypes){
            answer  =    answer +  (  change / coin) ;            
            change = change % coin; 
        }
        
        System.out.println(answer);
        sc.close();

    }
}