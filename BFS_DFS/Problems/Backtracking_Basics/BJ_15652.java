// 백준 | 백트래킹 - 완전 탐색 + 조건
// 순열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15652 {
  static int n, m;
  static StringBuilder sb = new StringBuilder();
  static int[] print;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    print = new int[m];

    backtrack(0, 1);
    System.out.print(sb.toString());
  }

  static void backtrack(int depth, int nn) {
    if (depth == m) {
      for (int i = 0; i < m; i++) {
        sb.append(print[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = nn; i <= n; i++) {
      print[depth] = i;
      backtrack(depth + 1, i);
    }
  }
}
