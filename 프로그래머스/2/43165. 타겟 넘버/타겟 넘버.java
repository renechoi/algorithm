class Solution {
    
     int target;
     int[] numbers;
     int count;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        this.count = 0; 
        
        dfs(0, 0);
        
        
        return count;
    }
    
    public void dfs(int index, int sum){
        
        if(index == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        
        dfs(index +1, sum + numbers[index]);
        dfs(index +1, sum - numbers[index]);
        
    }
}