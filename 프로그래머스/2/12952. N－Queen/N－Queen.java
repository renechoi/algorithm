class Solution {
    private int totalCount = 0; 
    private int[] board; 
    private int N;

    public int solution(int n) {
        N = n; 
        board = new int[N]; 
        placeQueen(0); 
        return totalCount;
    }

    private void placeQueen(int currentRow) {
        if (currentRow == N) {
            totalCount++; 
            return; 
        }

        for (int col = 0; col < N; col++) {
            board[currentRow] = col; 
            
            if (isValid(currentRow)) {
                placeQueen(currentRow + 1); 
            }
        }
    }

    private boolean isValid(int currentRow) {
        for (int i = 0; i < currentRow; i++) {
            if (board[i] == board[currentRow]) {
                return false;
            }

            if (Math.abs(currentRow - i) == Math.abs(board[currentRow] - board[i])) {
                return false;
            }
        }
        return true; 
    }
}