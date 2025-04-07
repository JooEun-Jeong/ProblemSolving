// 다이나믹 프로그래밍

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2839 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N + 1];

    dp[3] = dp[5] = 1;
    for(int i = 6; i<=N; i++){
      if(dp[i-3] != 0){
        dp[i] = dp[i-3] +1;
      }

      if(dp[i-5] != 0){
        dp[i] = dp[i-5] + 1;
      }
    }

    System.out.println(dp[N] == 0 ? -1 : dp[N]);
  }
}
