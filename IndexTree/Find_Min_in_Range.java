// 백준 10868번 | 주어진 범위 내에서 최솟값 찾기
// 세그먼트 트리 | build, update, query 시 주의해야할 포인트(주석 참조) 꼭 확인!!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_Min_in_Range {
  static int tree[], arr[];
  static int N, M;
  static final int MAX = 1000000001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    tree = new int[N * 4 + 1];
    for (int i = 0; i < tree.length; i++) {
      tree[i] = MAX; // max 값으로 설정해주기!!
    }
    arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    build(0, 0, N - 1);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a, b;
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      int result = query(0, 0, N - 1, a - 1, b - 1);
      sb.append(result + "\n");
    }

    System.out.print(sb.toString());
  }

  public static void build(int n, int s, int e) {
    if (s == e) {
      tree[n] = arr[s];

    } else {
      int mid = (s + e) / 2;
      build(2 * n + 1, s, mid);
      build(2 * n + 2, mid + 1, e);
      tree[n] = Math.min(tree[2 * n + 1], tree[2 * n + 2]); // 최솟값으로 설정해주기!!
    }
  }

  public static void update(int n, int s, int e, int nidx, int nval) {
    if (s == e) {
      tree[n] = nval;
    } else {
      int m = (s + e) / 2;
      if (nidx > m) {
        update(2 * n + 1, s, m, nidx, nval);
      } else {
        update(2 * n + 2, m + 1, e, nidx, nval);
      }
      tree[n] = Math.min(tree[2 * n + 1], tree[2 * n + 2]); // 최솟값으로 설정해주기!!
    }
  }

  public static int query(int n, int s, int e, int l, int r) {
    if (e < l || s > r) {
      return MAX; // max 값으로 설정해주기!!
    }
    if (l <= s && e <= r) {
      return tree[n];
    }
    int m = (s + e) / 2;
    return Math.min(query(2 * n + 1, s, m, l, r), query(2 * n + 2, m + 1, e, l, r));
  }
}
