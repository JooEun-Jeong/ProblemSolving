// DP | 피보나치
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      if (m > max) {
        max = m;
      }
      arr[i] = m;
    }
    if (max < 3) {
      max = 3;
    }
    int dp[] = new int[max + 1];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i < dp.length && i <= max; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(dp[arr[i]] + "\n");
    }

    System.out.println(sb.toString());
  }
}
