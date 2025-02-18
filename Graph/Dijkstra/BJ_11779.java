import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11779 {
  static int V, E;
  static int[] route;
  static List<List<int[]>> graph;
  static List<Integer> routes;
  static int INF = Integer.MAX_VALUE;
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    V = Integer.parseInt(br.readLine());
    E = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();
    for (int i = 0; i <= V ; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph.get(s).add(new int[]{e, c});
    }

    int startV, endV;
    st = new StringTokenizer(br.readLine());
    startV = Integer.parseInt(st.nextToken());
    endV = Integer.parseInt(st.nextToken());

    System.out.println(dijkstra(startV, endV));
  
    int current = endV;
    routes = new ArrayList<>();
    while(current != 0) {
        routes.add(current);
        current = route[current];
    }
    System.out.println(routes.size());

    for (int j = routes.size()-1; j>=0; j--) {
      System.out.print(routes.get(j) + " ");
    }
  }

  static int dijkstra(int startV, int endV){
    int cost = 0;
    int[] dist = new int[V+1];
    Arrays.fill(dist, INF);

    route = new int [V+1];
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{startV, 0});
    dist[startV] = 0;

    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int cn = cur[0];
      int cd = cur[1];
      
      if(dist[cn] < cd) {
        continue;
      }

      for(int[] next: graph.get(cn)){
        int nn = next[0];
        int nw = next[1];
        int nd = cd+nw;
        if(nd < dist[nn]){
          dist[nn] = nd;
          route[nn] = cn;
          pq.offer(new int[]{nn, nd});
        }
      }
    }

    cost = dist[endV];
    return cost;
  }
}
