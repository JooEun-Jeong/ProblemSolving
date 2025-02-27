// 백준 1806 문제 | 부분 합 중 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하여라
// 골드 4 | 투포인터 응용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N, S, l, r, minLength;
    long sum;
    int arr[];
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arr = new int[N];
    minLength = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    l = r = 0;
    sum = 0L;
    while(r < N){
      sum += arr[r];
      while(l <= r && S <= sum){
        minLength = Math.min(r - l + 1, minLength);
        sum -= arr[l];
        l++;
      }
      r++;
    }

    if(minLength == Integer.MAX_VALUE) 
      minLength = 0;
    System.out.println(minLength);
  }
}
