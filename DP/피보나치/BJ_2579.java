// DP | 피보나치 유형
// 3번 연속 밟지 않기 위해 역추적으로 고민하며 타고 내려가보자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2579 {
  static int arr[], dp[];

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    dp = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = arr[0];
    // 예외 처리: n이 1이나 2인 경우
    if (n == 1) {
      System.out.println(arr[0]);
      return;
    }

    if (n == 2) {
      System.out.println(arr[0] + arr[1]);
      return;
    }

    dp[1] = dp[0] + arr[1];
    dp[2] = Math.max(arr[0], arr[1]) + arr[2];
    for (int i = 3; i < n; i++) {
      dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
    }

    System.out.println(dp[n - 1]);
  }
}
