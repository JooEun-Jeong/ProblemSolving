// BFS | 최단 경로(시간)의 경우의 수 찾기 + 최단 경로(시간) 길이
// 백준 12851 + 내가 변형

import java.io.*;
import java.util.*;

public class Print_shortest_path {
  static int n, k;
  static List<Integer>[] parents = new ArrayList[100001];
  static List<List<Integer>> paths = new ArrayList<>();

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
            parents[nm].add(a);
            q.add(nm);
          } else if (visited[nm] == visited[a] + 1) {
            // 다른 경로로 같은 시간 방문
            cnt[nm] += cnt[a];
            parents[nm].add(a);
          }
        }
      }
    }

    System.out.println(visited[k] - 1);
    System.out.println(cnt[k]);

    // 최단 경로 추적
    List<Integer> path = new ArrayList<>();
    path.add(k);
    backtrack(k, path);

    // 모든 경로 출력
    for (List<Integer> p : paths) {
      for (int num : p) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

  static void backtrack(int cur, List<Integer> path){
    if(cur == n){
      List<Integer> result = new ArrayList<>(path);
      Collections.reverse(result);
      paths.add(result);
      return;
    }
    for(int p: parents[cur]){
      path.add(p);
      backtrack(p, path);
      path.remove(path.size() - 1);
    }
  }
}
