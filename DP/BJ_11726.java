// DP | 피보나치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];
    dp[1] = 1;
    if(N==1){
      System.out.println(1);
      return;
    }
    dp[2] = 2;
    for (int i = 3; i < dp.length; i++) {
      dp[(i % 3)] = (dp[(i-1)%3] + dp[(i-2)%3]) % 10_007;
    }

    System.out.println(dp[N % 3] % 10_007);
  }
}
