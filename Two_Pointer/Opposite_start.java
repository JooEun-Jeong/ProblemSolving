// 백준 3273 문제 | 두 수의 합
// 기본적인 반대 방향에서 두 포인터가 움직이는 코드 (l, r 포인터가 반대 방향에서 이동)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b3273 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N, M, arr[];
    N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());

    int r, l, c;
    long s;
    r = N-1;
    l = c = 0;
    s = 0;

    Arrays.sort(arr); // 반드시 정렬하는 과정이 필요
    
    // 조건에 맞게 동작
    while (l < r) {
      if (arr[r] + arr[l] > M) {
        r--;
      }else if(arr[r] + arr[l] < M){
        l++;
      }else{
        c++;
        l++;
      }
    }

    System.out.println(c);
  }
}
