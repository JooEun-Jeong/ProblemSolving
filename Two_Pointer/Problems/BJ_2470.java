// 백준 2470 문제 | 두 개의 합이 가장 작은 조합 출력하기
// 골드 5 | 투포인터 반대 방향

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int r, l;
    l = 0;
    r = N - 1;

    int ar = r, al = l;

    long min = 9876543210L;
    Arrays.sort(arr);

    if(arr[l] < 0 && arr[r] < 0){
      al = N-2;
      ar = N-1;
    }else if(arr[l] > 0 && arr[r] > 0){
      al = 0;
      ar = 1;
    }else{
      while (l < r) {
        long s = arr[r] + arr[l];
        if (min > Math.abs(s)) {
          min = Math.abs(s);
          ar = r;
          al = l;
        }
        if (s > 0) {
          r--;
        } else if (s < 0) {
          l++;
        } else {
          break;
        }
      }
    }

    System.out.println(arr[al] + " " + arr[ar]);
  }
}
