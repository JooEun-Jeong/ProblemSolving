// 펜윅트리 기본 | 백준 2268
// update의 의미를 잘 이해할 것. idx에 val을 더한다는 뜻!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fenwick_Tree {
  static long[] tree, arr;
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    tree = new long[n + 1];
    arr = new long[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int command, a, b;
      command = Integer.parseInt(st.nextToken());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      if (command == 0) {
        if (a > b) {
          int tmp = a;
          a = b;
          b = tmp;
        }
        sb.append(getSum(a, b) + "\n");
      } else {
        // 이 부분 유의깊게 볼 것!!
        long dif = b - arr[a];
        arr[a] = b;
        update(a, dif);
      }
    }

    System.out.print(sb.toString());
  }

  // 현재 위치 idx에 val을 더한다 라는 뜻임!!
  // 갱신하기 위해서는 기존 값을 빼는 과정이 필요함.
  static void update(int idx, long val) {
    while (idx <= n) {
      tree[idx] += val; // 더하기!
      idx += idx & -idx;
    }
  }

  static long query(int idx) {
    long sum = 0;
    while (idx > 0) { // 0 초과!
      sum += tree[idx];
      idx -= idx & -idx;
    }
    return sum;
  }

  static long getSum(int l, int r) {
    return query(r) - query(l - 1);
  }

}
