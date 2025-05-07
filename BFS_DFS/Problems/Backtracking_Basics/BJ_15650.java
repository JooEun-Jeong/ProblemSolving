// 백트래킹 | Combination 패턴
// 문제:
// 1부터 N까지 숫자 M개 선택
// 오름차순이어야 하며, 중복 없어야함.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650 {
  static int N, M;
  static int[] print;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    print = new int[M];
    backtrack(0, 0);

    System.out.print(sb.toString());
  }

  static void backtrack(int start, int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(print[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start + 1; i <= N; i++) {
      print[depth] = i;
      backtrack(i, depth + 1);

    }
  }
}
