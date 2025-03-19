// 나머지 합
// 누적합

import java.io.*;
import java.util.*;

public class BJ_10986 {
  static int n, m;
  static int arr[];

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

    int remain[] = new int[m];
    long preSum = 0;
    for (int i = 0; i < n; i++) {
      preSum += arr[i];
      remain[(int) (preSum % m + m) % m]++;
    }

    long result = remain[0];
    for (int i = 0; i < m; i++) {
      result += (long) (remain[i]) * (remain[i] - 1) / 2;
    }

    System.out.println(result);
  }
}
