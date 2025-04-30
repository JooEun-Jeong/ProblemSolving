// 노드의 연결 개수
// dfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11724 {
  static int N, M;
  static ArrayList<Integer>[] arr;
  static boolean visited[];

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    for (int i = 0; i < N + 1; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[a].add(b);
      arr[b].add(a);
    }

    int result = 0;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        result++;
      }
    }

    System.out.println(result);
  }

  static void dfs(int v) {
    visited[v] = true;
    for (int next : arr[v]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }
}