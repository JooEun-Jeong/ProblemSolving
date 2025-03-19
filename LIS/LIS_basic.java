// LIS 최장 증가 부분 수열의 길이 | 기본문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11053 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int d[] = new int[n];
    Arrays.fill(d, 1);
    int result = 0;
    for (int i = 0; i < d.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          d[i] = Math.max(d[i], d[j] + 1);
          if (result < d[i]) {
            result = d[i];
          }
        }
      }
    }
    System.out.println(result);
  }
}
