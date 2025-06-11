class Solution {

    static int 화살개수;
    static int[] 어피치 = new int[11];
    static int[] 라이언현재조합 = new int[11];
    
    static 결과관리자 최적결과;

    public int[] solution(int n, int[] info) {
       화살개수 = n;

       for (int i = 0; i < 11; i++) {
          어피치[i] = info[i];
          라이언현재조합[i] = 0; 
       }
       
       최적결과 = new 결과관리자(); 

       점수조합하기(0, 화살개수);
       
       if (최적결과.최대차이점수 <= 0) {
          return new int[]{-1};
       }

       return 최적결과.라이온최적조합;
    }

    public void 점수조합하기(int 현재처리중인과녁인덱스, int 현재남아있는화살개수) {
       if (현재처리중인과녁인덱스 == 11) {
          라이언현재조합[10] += 현재남아있는화살개수;
          int 현재계산한점수 = 점수비교하여차이계산하기();

          최적결과.업데이트하기(현재계산한점수, 라이언현재조합);

          라이언현재조합[10] -= 현재남아있는화살개수;
          return;
       }

       int requiredArrows = 어피치[현재처리중인과녁인덱스] + 1;
       if (현재남아있는화살개수 >= requiredArrows) {
          라이언현재조합[현재처리중인과녁인덱스] = requiredArrows;
          점수조합하기(현재처리중인과녁인덱스 + 1, 현재남아있는화살개수 - requiredArrows);
          라이언현재조합[현재처리중인과녁인덱스] = 0; 
       }

       라이언현재조합[현재처리중인과녁인덱스] = 0;
       점수조합하기(현재처리중인과녁인덱스 + 1, 현재남아있는화살개수);
    }

    private int 점수비교하여차이계산하기() {
       int 라이온점수 = 0;
       int 어피치점수 = 0;

       for (int i = 0; i < 11; i++) {
          if (라이언현재조합[i] > 어피치[i]) {
             라이온점수 += (10 - i);
          } else if (어피치[i] > 0) {
             어피치점수 += (10 - i);
          }
       }

       return 라이온점수 - 어피치점수;
    }

    static class 결과관리자 {
        int 최대차이점수;
        int[] 라이온최적조합;

        public 결과관리자() {
            this.최대차이점수 = -1; 
            this.라이온최적조합 = new int[11]; 
        }

        public void 업데이트하기(int 현재계산한점수, int[] 현재비교할조합) {
            if (현재계산한점수 <= 0) {
                return;
            }

            if (현재계산한점수 > 최대차이점수) {
                최대점수차이갱신(현재계산한점수, 현재비교할조합);
            } 
            else if (현재계산한점수 == 최대차이점수) {
                낮은점수더많이맞춘경우갱신(현재비교할조합);
            }
        }

        private void 최대점수차이갱신(int 새로운점수차이, int[] 새로운조합) {
            this.최대차이점수 = 새로운점수차이;
            조합복사하기(새로운조합);
        }

        private void 낮은점수더많이맞춘경우갱신(int[] 새로운조합) {
            for (int i = 10; i >= 0; i--) {
                if (새로운조합[i] > this.라이온최적조합[i]) {
                    조합복사하기(새로운조합);
                    return; 
                } else if (새로운조합[i] < this.라이온최적조합[i]) {
                    return; 
                }
            }
        }

        private void 조합복사하기(int[] 원본조합) {
            for (int i = 0; i < 11; i++) {
                this.라이온최적조합[i] = 원본조합[i];
            }
        }
    }

}