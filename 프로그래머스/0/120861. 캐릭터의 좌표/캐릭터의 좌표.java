class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
       Position position = Position.init(board[0], board[1]);
        
        for (String command: keyinput){
            position.move(command);
        }
        
        return position.showCurrent();
    }
    
    public static class Position {
        int x;
        int y;
        int boardSizeX;
        int boardSizeY;
        
        public Position(int x, int y, int boardSizeX, int boardSizeY){
            this.x = x;
            this.y = y;
            this.boardSizeX = boardSizeX;
            this.boardSizeY = boardSizeY;
        }
        
        public static Position init(int sizeX, int sizeY){
            return new Position(0,0, sizeX, sizeY);
        }
        
        
        public void move(String command){
            if("left".equals(command)){
                goLeft();
            } 
            
            if("right".equals(command)){
                goRight();
            } 
            
            if("up".equals(command)){
                goUp();
            } 
            
            if("down".equals(command)){
                goDown();
            } 
        }
        
        public void goLeft(){
            if(x<=-boardSizeX/2 ){
                return;
            }
            this.x--;
        }
        
        public void goRight(){
            if( x>=boardSizeX/2){
                return;
            }
            this.x++;
        }
        
        public void goUp(){
            if( y>=boardSizeY/2){
                return;
            }
            this.y++;
        }
        
        public void goDown(){
             if(y<=-boardSizeY/2 ){
                return;
            }
            this.y--;
        }
        
        public int[] showCurrent(){
            return new int[]{x, y};
        }
        
        
    }
}