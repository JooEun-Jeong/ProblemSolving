// 백준 1654 | 주어진 개수에 맞게 주어진 값들을 잘라 개수만큼 맞추기, 그 중에서 최대 값 찾기
// 실버 2 | 이분탐색 - 파라메트릭 서치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Parametric_Search {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n, k;
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int arr[] = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // l이 1부터 시작하는게 중요!!
    long l = 1, r = Arrays.stream(arr).summaryStatistics().getMax();
    long result = 0;
    while (l <= r) {
      long m = (l + r) / 2;
      if (m == 0) // zero division 안 되도록 예외처리 중요!!
        break;
      long total = 0;
      for (int i : arr) {
        total += (i / m);
      }
      if (total >= k) {
        result = m;
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    System.out.println(result);
  }
}
