// DFS | 기본

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b2667 {
  static int N, area;
  static char map[][];
  static ArrayList<Integer> res;
  static int[] dr = new int[] { 1, -1, 0, 0 };
  static int[] dc = new int[] { 0, 0, 1, -1 };

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    res = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == '1') {
          area = 1;
          dfs(i, j);
          res.add(area);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(res.size() + "\n");
    Collections.sort(res);
    for (int i = 0; i < res.size(); i++) {
      sb.append(res.get(i) + "\n");
    }

    System.out.print(sb.toString());
  }

  static void dfs(int r, int c) {
    map[r][c] = '0';
    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];
      if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != '0') {
        area++;
        dfs(nr, nc);
      }
    }
  }
}
