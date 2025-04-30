// 그래프 탐색, 대각선 방향으로도 체크하도록 설정
// dfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4963 {

  static int N, M;
  static int dc[] = new int[] { 0, 0, 1, -1, 1, -1, 1, -1 };
  static int dr[] = new int[] { 1, -1, 0, 0, 1, 1, -1, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (true) {
      st = new StringTokenizer(br.readLine());
      int w, h;
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());
      if (w == 0 && h == 0) {
        break;
      }

      int[][] map = new int[h][w];
      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int result = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1) {
            dfs(map, i, j, h, w);
            result++;
          }
        }
      }
      sb.append(result + "\n");
    }

    System.out.print(sb.toString());
  }

  static void dfs(int[][] map, int r, int c, int h, int w) {
    map[r][c] = 0;
    for (int i = 0; i < 8; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1) {
        dfs(map, nr, nc, h, w);
      }

    }
  }
}
