// BFS + DFS | 최단거리의 경로를 출력하라
// 경로 출력 = 백트래킹
// 최단 거리 = BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b13913 {
  static final int MAX = 100_001;
  static int N, K;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();
    q.add(N);
    int dist[] = new int[MAX];
    dist[N] = 1;

    List<Integer>[] track = new ArrayList[MAX];
    for (int i = 0; i < MAX; i++) {
      track[i] = new ArrayList<Integer>();
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      if (cur == K) {
        break;
      }
      for (int nm : new int[] { cur - 1, cur + 1, cur * 2 }) {
        if (nm >= 0 && nm < MAX) {
          if (dist[nm] == 0) {
            // 한번도 방문한 적이 없는 경우
            dist[nm] = dist[cur] + 1;
            track[nm].add(cur);
            q.add(nm);
          }
        }
      }
    }

    ArrayList<Integer> startPath = new ArrayList<>();

    backtrack(K, startPath, track);

    sb.append(K);
    System.out.println(sb.toString());
  }

  static void backtrack(int current, List<Integer> path, List<Integer>[] parents) {
    if (current == N) {
      List<Integer> result = new ArrayList<>(path);
      Collections.reverse(result);
      sb.append((result.size()) + "\n");
      for (int i = 0; i < result.size(); i++) {
        sb.append(result.get(i) + " ");
      }
      return;
    }
    for (int p : parents[current]) {
      path.add(p);
      backtrack(p, path, parents);
      path.remove(path.size() - 1);
    }
  }
}
