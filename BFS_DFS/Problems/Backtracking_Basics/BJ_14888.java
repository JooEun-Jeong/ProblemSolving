import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {
  static int n, arr[], ops[];
  static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    ops = new int[n - 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int idx = 0;
    for (int i = 0; i < 4; i++) {
      int c = Integer.parseInt(st.nextToken());
      for (int j = 0; j < c; j++) {
        ops[idx++] = i + 1; // 1: +, 2: -, 3: *, 4: /
      }
    }

    boolean[] visited = new boolean[n - 1];

    dfs(visited, 0, arr[0]);

    System.out.println(max);
    System.out.println(min);
  }

  static void dfs(boolean[] visited, int d, int r) {
    if (d == n - 1) {
      max = Math.max(max, r);
      min = Math.min(min, r);
      return;
    }

    for (int i = 0; i < n - 1; i++) {
      if (!visited[i]) {
        visited[i] = true;
        int rr = calculate(r, arr[d + 1], ops[i]);
        dfs(visited, d + 1, rr);
        visited[i] = false;
      }
    }
  }

  static int calculate(int a, int b, int op) {
    switch (op) {
      case 1:
        return a + b;
      case 2:
        return a - b;
      case 3:
        return a * b;
      case 4:
        return a / b;
      default:
        return 0;
    }
  }
}