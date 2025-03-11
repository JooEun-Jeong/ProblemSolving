// 백준 슬라이딩 윈도우
// 실버 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N, K;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int arr[] = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int c = 0, s = 0, m = -987654321;
    for (int i = 0; i < arr.length; i++) {
      if (c == K) {
        break;
      }
      c++;
      s += arr[i];
    }
    if(s > m){
      m = s;
    }
    for (int i = K; i < arr.length; i++) {
      s -= arr[i - K];
      s += arr[i];
      if(s > m){
        m = s;
      }
    }

    System.out.println(m);
  }
}
