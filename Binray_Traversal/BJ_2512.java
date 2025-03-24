// 파라메트릭 서치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long budget = Integer.parseInt(br.readLine());

    int l = 1, r = Arrays.stream(arr).summaryStatistics().getMax();
    int result = 0;
    while (l <= r) {
      int m = (l + r) / 2;
      if (m == 0) {
        break;
      }
      long total = 0;
      for (int i : arr) {
        total += (m > i) ? i : m;
      }
      if (total > budget) {
        r = m - 1;
      } else {
        result = m;
        l = m + 1;
      }
    }

    System.out.println(result);
  }
}
