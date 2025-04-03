// DP | 계단식 점화식 유형(피보나치 유형)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
  static int[][] data;
  static int[][] dp;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    data = new int[N][3];
    dp = new int[N][3];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      data[i] = new int[] { a, b, c };
    }

    dp[0][0] = data[0][0];
    dp[0][1] = data[0][1];
    dp[0][2] = data[0][2];
    for (int i = 1; i < N; i++) {
      dp[i][0] = Math.min(dp[i - 1][1] + data[i][0], dp[i - 1][2] + data[i][0]);
      dp[i][1] = Math.min(dp[i - 1][0] + data[i][1], dp[i - 1][2] + data[i][1]);
      dp[i][2] = Math.min(dp[i - 1][1] + data[i][2], dp[i - 1][0] + data[i][2]);
    }

    System.out.println(getMin(dp[N - 1]));
  }

  static int getMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    return min;
  }
}
