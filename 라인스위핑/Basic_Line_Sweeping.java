// 라인스위핑 기본
// linked list 사용하지 말 것.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2170 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    int n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st;

    // List<int[]> lst = new LinkedList<>(); // 링크드 리스트로 하면 시간초과남 (접근이 O(n)이기 때문)
    int[][] arr = new int[n][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a, b;
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      // lst.add(new int[] { a, b });
      arr[i] = new int[] { a, b };
    }

    // lst.sort((a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
    Arrays.sort(arr, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);

    int min, max;
    // min = lst.get(0)[0];
    // max = lst.get(0)[1];
    min = arr[0][0];
    max = arr[0][1];

    long len = max - min;
    for (int i = 1; i < n; i++) {
      // int[] item = lst.get(i);
      int[] item = arr[i];

      if (min <= item[0] && item[1] <= max) {
        // 구간 안에 있는 경우
        continue;
      } else if (max <= item[0]) {
        // 아예 안 겹치는 경우
        max = item[1];
        min = item[0];
        len += item[1] - item[0];
        // System.out.println("New: " + (item[1] - item[0]));
      } else if (item[0] <= max && item[1] >= max) {
        // 겹치는 경우
        len += item[1] - max;
        // System.out.println("Overlapped: " + (item[1] - max));
        max = item[1];
      }
    }

    System.out.println(len);
  }
}
