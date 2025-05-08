// Backtracking | 부분 수열 중 특정 합을 만족하는 합의 개수
// 분기를 잘 타는 게 중요!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182 {
  static int cnt, N, S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    int arr[] = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dfs(arr, 0, 0);

    System.out.println(cnt - (S == 0 ? 1 : 0));
  }

  static void dfs(int[] arr, int idx, int sum) {
    if (idx == N) {
      if (sum == S) {
        cnt++;
      }
      return;
    }

    dfs(arr, idx + 1, sum + arr[idx]);
    dfs(arr, idx + 1, sum);
  }
}
