// 백준 2003 문제 | 연속된 부분 수열의 합
// 기본적인 슬라이딩 윈도우 코드 (l, r 포인터가 같은 방향으로 이동)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N, M;
    int[] arr;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int r, l, s, c;
    r = l = s = c = 0;
    while (r < N) {
      s += arr[r];
      while (s > M && l <= r) {
        s -= arr[l];
        l++;
      }
      if (s == M) {
        c++;
      }
      r++;
    }

    System.out.println(c);
  }
}
