class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (지폐가들어갈수없다면(wallet, bill)){
            if(bill[0] > bill[1]){
                bill[0] = bill[0] / 2;
            } 
            else {  
                bill[1] = bill[1] / 2;
            }
            answer++;
        }
        
        return answer;
    }
              
     
     private boolean 지폐가들어갈수없다면(int[] wallet, int[] bill){
        return  get작은값(bill) > get작은값(wallet) || get큰값(bill) > get큰값(wallet);
     }       
               
     private int get작은값(int[] walletOrBill){
         int min = Integer.MAX_VALUE;
         
         for(int i =0;i<walletOrBill.length; i++){
             if(walletOrBill[i] <min){
                 min = walletOrBill[i];
             }
         }
         return min;
     }  
               
      private int get큰값(int[] walletOrBill){
         int max = Integer.MIN_VALUE;
         
         for(int i =0;i<walletOrBill.length; i++){
             if(walletOrBill[i] > max){
                 max = walletOrBill[i];
             }
         }
         return max;
     }    
             
             
}