// 백준 12738 | 주어진 범위 내에서 최솟값 찾기
// 골드 2 | 파라메트릭 서치: 범위를 설정하는 것이 포인트!!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b6236 {
  public static void main(String[] args) throws IOException {
    int n, k;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int arr[] = new int[n];
    int r = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      r += arr[i];
    }

    int l = Arrays.stream(arr).summaryStatistics().getMax();
    int result = 0;
    while (l <= r) {
      int m = (l + r) / 2;
      int total = 0;
      if (m == 0)
        break;

      for (int i = 0; i < arr.length;) {
        int rr = 0;
        while (rr <= m && i < arr.length) {
          rr += arr[i];
          i++;
        }
        if(rr > m){
          i--;
          rr -= arr[i];
        }
        total++;
      }

      if (total <= k) {
        result = m;
        r = m - 1;
      } else {
        l = m + 1;
      }
    }

    System.out.println(result);
  }
}
