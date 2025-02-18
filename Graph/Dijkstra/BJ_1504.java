import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1504 {
  static int N, E;
  static List<List<int[]>> g;
  static long INF = 2000000000L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    g = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      g.add(new ArrayList<>());
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      g.get(s).add(new int[]{e, c});
      g.get(e).add(new int[]{s, c});
    }

    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    long[] firstRoute = dijkstra(1);
    long[] secondRoute = dijkstra(v1);
    long[] thirdRoute = dijkstra(v2);

    long r1, r2;
    r1 = firstRoute[v1] + secondRoute[v2] + thirdRoute[N];
    r2 = firstRoute[v2] + thirdRoute[v1] + secondRoute[N];

    if( r1 >= INF){
      r1 = INF;
    }

    if( r2 >= INF){
      r2 = INF;
    }
    if(r1 ==INF && r2 == INF){
      System.out.println(-1);
    }else{
      System.out.println(Math.min(r1, r2));
    }
  }

  static long[] dijkstra(int startV){
    long[] dist = new long[N+1];
    Arrays.fill(dist, INF);
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    dist[startV] = 0;
    pq.offer(new int[]{startV, 0});

    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int cn = cur[0];
      int cd = cur[1];

      if(cd > dist[cn]) continue;
      for(int[] next: g.get(cn)){
        int nn = next[0];
        int nw = next[1];
        int nd = cd + nw;
        if( dist[nn] > nd){
          dist[nn] = nd;
          pq.add(new int[]{nn, nd});
        }
      }
    }
    return dist;
  }
}
