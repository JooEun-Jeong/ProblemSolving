import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1753 {
  static int V, E, startV;
  static List<List<int[]>> edges;
  static int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    startV = Integer.parseInt(br.readLine());

    edges = new ArrayList<>();
    for(int i=0; i<=V; i++) edges.add(new ArrayList<>());

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      edges.get(s).add(new int[]{e, c});
    }

    int[] result = dijkstra();

    for (int i = 1; i < result.length; i++) {
      sb.append(((result[i]==INF) ? "INF" : result[i]) + "\n");
    }

    System.out.println(sb);
  }

  static int[] dijkstra (){
    int[] dist = new int[V+1];
    for (int i = 0; i < dist.length; i++) {
      dist[i] = INF;
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{startV, 0});
    dist[startV] = 0;

    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int cn = cur[0];
      int cw = cur[1];

      if(cw > dist[cn]) continue;

      for(int[] next: edges.get(cn)){
        int nn = next[0];
        int nw = next[1];
        int nd = cw + nw;
        if(nd < dist[nn]){
          dist[nn] = nd;
          pq.offer(new int[]{nn, nd});
        }
      }
    }
    return dist;
  }
}
