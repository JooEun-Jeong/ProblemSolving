// 백트래킹 | N개의 자연수 중 M개를 뽑아 오름차순으로 중복있게 나열
// 순열열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15656 {
  static int n, m;
  static StringBuilder sb = new StringBuilder();
  static int[] print;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    print = new int[m];
    arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    dfs(0);

    System.out.print(sb.toString());
  }

  static void dfs(int depth) {
    if (depth == m) {
      for (int i = 0; i < print.length; i++) {
        sb.append(print[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
      print[depth] = arr[i];
      dfs(depth + 1);
    }
  }
}
