import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int people = dfs(startX, startY);

        System.out.println(people == 0 ? "TT" : people);
    }

    public static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || campus[nx][ny] == 'X')
                    continue;

                if (campus[nx][ny] == 'P') count++;

                visited[nx][ny] = true;
                stack.push(new int[]{nx, ny});
            }
        }

        return count;
    }
}
