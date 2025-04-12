// BFS | 기본

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 {
  static int n, m;
  static char map[][];
  static int visited[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n][m];
    visited = new int[n][m];

    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      map[i] = row.toCharArray();
    }

    bfs();
    System.out.println(visited[n - 1][m - 1]);
  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    visited[0][0] = 1;
    q.add(new int[] { 0, 0 });

    int[] dr = new int[] { 1, -1, 0, 0 };
    int[] dc = new int[] { 0, 0, 1, -1 };
    while (!q.isEmpty()) {
      int[] loc = q.poll();
      int cr = loc[0], cc = loc[1];
      for (int i = 0; i < 4; i++) {
        int nr = cr + dr[i];
        int nc = cc + dc[i];
        if (0 <= nr && n > nr && 0 <= nc && m > nc && visited[nr][nc] == 0 && map[nr][nc] == '1') {
          visited[nr][nc] = visited[cr][cc] + 1;
          q.add(new int[] { nr, nc });
        }
      }
    }
  }
}
