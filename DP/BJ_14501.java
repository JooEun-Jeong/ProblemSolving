// DP | 0-1 냅색 문제
// 상담하거나 안하거나
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int arr[][] = new int[N][2];
    StringTokenizer st;
    for (int i = 0; i < arr.length; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
    }

    int dp[] = new int[N + 1];

    for (int i = 1; i <= arr.length; i++) {
      int ds = arr[i - 1][0], val = arr[i - 1][1];
      if (i + ds - 1 <= N) {
        dp[i + ds - 1] = Math.max(dp[i + ds - 1], dp[i - 1] + val);
      }
      dp[i] = Math.max(dp[i], dp[i - 1]);
    }

    // for (int i = 0; i < dp.length; i++) {
    // System.out.print(dp[i] + " ");
    // }
    // System.out.println();

    System.out.println(dp[N]);
  }
}
