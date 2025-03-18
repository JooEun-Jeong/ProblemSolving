// 다익스트라
//   ✅ 그래프(또는 격자)에서 출발점에서 도착점까지의 최단 경로를 구하는 문제인가?
//   ✅ 가중치(비용, 거리, 시간 등)가 있는가?
//   ✅ 모든 가중치가 양수인가? (음수 가중치가 있으면 벨만-포드 알고리즘 필요)
//
//   벽을 부수면 1, 안 부수면 0이므로 "가중치가 있는 최단 거리 문제"
//   가중치가 양수(0 또는 1)이므로 다익스트라를 적용할 수 있음

import java.io.*;
import java.util.*;

public class BJ_1261 {
  static int N, M;
  static int[][] map;
  static int[][] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    dist = new int[N][M];

    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    dist[0][0] = 0;

    for (int i = 0; i < N; i++) {
      char[] tmp = br.readLine().toCharArray();
      for (int j = 0; j < tmp.length; j++) {
        map[i][j] = tmp[j] - '0';
      }
    }

    System.out.println(dijkstra());

  }

  public static int dijkstra() {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    int startw = map[0][0] == 0 ? 0 : 1;
    pq.add(new int[] { 0, 0, startw });

    int[] dr = new int[] { 1, -1, 0, 0 };
    int[] dc = new int[] { 0, 0, 1, -1 };

    while (!pq.isEmpty()) {
      int[] nn = pq.poll();
      int r = nn[0];
      int c = nn[1];
      int w = nn[2];
    
      for (int i = 0; i < 4; i++) {
        int nr = dr[i] + r;
        int nc = dc[i] + c;
        if ((nr >= 0) && (nc >= 0) && (nr < N) && (nc < M)) {
          if (w + map[nr][nc] > dist[nr][nc]) {
            continue;
          }
          if ((w + map[nr][nc] < dist[nr][nc])) {
            dist[nr][nc] = w + map[nr][nc];
            pq.add(new int[] { nr, nc, dist[nr][nc] });
          }
        }
      }
    }

    return dist[N - 1][M - 1];
  }
}
