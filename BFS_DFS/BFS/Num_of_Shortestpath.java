// BFS | 최단 경로(시간)의 경우의 수 찾기 + 최단 경로(시간) 길이
// 백준 12851
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b12851 {
  static int n, k;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int[] visited = new int[100001];
    int[] cnt = new int[100001];

    Queue<Integer> q = new LinkedList<>();
    q.add(n);
    visited[n] = 1;
    cnt[n] = 1;
    while (!q.isEmpty()) {
      int a = q.poll();
      if (a == k) {
        break;
      }
      for (int nm : new int[] { a - 1, a + 1, a * 2 }) {
        if (nm >= 0 && nm <= 100000) {
          if (visited[nm] == 0) {
            visited[nm] = visited[a] + 1;
            cnt[nm] = cnt[a];
            q.add(nm);
          } else if (visited[nm] == visited[a] + 1) {
            // 다른 경로로 같은 시간 방문
            cnt[nm] += cnt[a];
          }
        }
      }
    }

    System.out.println(visited[k] - 1);
    System.out.println(cnt[k]);
  }
}
