// 백준 12738 | 가장 긴 수열 길이 출력
// 골드 2 | 이분 탐색을 이용한 적합한 위치 찾기
// 이분탐색: lst
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_12738 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    int N, arr[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<Integer> lst = new ArrayList<>();
    for (int item : arr) {
      if (lst.isEmpty() || lst.get(lst.size() - 1) < item) {
        lst.add(item);
      } else {
        int idx = Collections.binarySearch(lst, item);
        if (idx < 0) {
          idx = -idx - 1;
        }
        lst.set(idx, item);
      }
    }

    sb.append(lst.size());
    System.out.println(sb.toString());
  }
}
