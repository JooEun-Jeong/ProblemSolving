// DP | 2차원, 0-1 Knapsack
// 해결 아이디어: dp[i][w] = i번째 물건까지 고려했을 때, 무게 w 이하로 담을 수 있는 최대 가치
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b12865 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N, K;
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int arr[][] = new int[N][2];

    for (int i = 0; i < arr.length; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
    }

    int dp[][] = new int[N+1][K + 1];
    for (int i = 1; i < dp.length; i++) {
      int weight, value;
      weight = arr[i-1][0];
      value = arr[i-1][1];
      for (int j = 0; j <= K; j++) {
        if (weight <= j) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
        }else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    System.out.println(dp[N][K]);
  }
}
