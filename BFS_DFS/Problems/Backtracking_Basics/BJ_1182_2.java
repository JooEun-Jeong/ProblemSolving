
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_2 {
  static int n, m, arr[], result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);

    System.out.print((m == 0) ? result - 1 : result);
  }

  static void dfs(int res, int depth) {
    if (depth == n) {
      if (res == m) {
        result++;
      }
      return;
    }

    dfs(res, depth + 1);
    dfs(res + arr[depth], depth + 1);
  }
}
