// 백준 1261번 문제

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp[j] - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    int cost = dist[r][c] + map[nr][nc];

                    if (cost < dist[nr][nc]) {
                        dist[nr][nc] = cost;
                        if (map[nr][nc] == 0) {
                            deque.addFirst(new int[] {nr, nc}); // 0이면 우선 탐색
                        } else {
                            deque.addLast(new int[] {nr, nc});  // 1이면 후순위 탐색
                        }
                    }
                }
            }
        }

        return dist[N - 1][M - 1];
    }
}
