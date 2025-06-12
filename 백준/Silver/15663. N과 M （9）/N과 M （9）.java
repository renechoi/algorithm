import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] selected;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        numbers = new int[N];
        selected = new int[M];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(numbers);
        
        backtrack(0);
    }
    
    static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;

        for (int i = 0; i < N; i++) {
            if (visited[i]){
                continue;
            }
            
            if (prev == numbers[i]) {
                continue; 
            }

            selected[depth] = numbers[i];
            visited[i] = true;
            prev = numbers[i];

            backtrack(depth + 1);

            visited[i] = false;
        }

    }
}