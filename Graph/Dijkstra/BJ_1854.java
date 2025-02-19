import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1854 {
  static int V, E, K, INF=987654;
  static List<List<int[]>> g;
  static PriorityQueue<int[]> pq;
  static PriorityQueue<Integer>[] distPq;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    g = new ArrayList<>();
    for (int i = 0; i < V+1; i++) {
      g.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s =Integer.parseInt(st.nextToken());
      int e =Integer.parseInt(st.nextToken());
      int c =Integer.parseInt(st.nextToken());

      g.get(s).add(new int[]{e,c});
    }

    dijkstra();
  }

  static void dijkstra(){
    int start =1;
    pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    distPq = new PriorityQueue[V+1];
    for (int j = 0; j < V+1; j++) {
      distPq[j] = new PriorityQueue<>((a, b) -> b - a); // 내림차순
    }

    pq.offer(new int[]{start, 0});
    distPq[start].add(0);

    while(!pq.isEmpty()){
      int[] c = pq.poll();
      int cn = c[0];
      int cd = c[1];

      for(int[] next: g.get(cn)){
        int nn = next[0];
        int nw = next[1];
        int nd = nw + cd;
        if(distPq[nn].size() < K){
          pq.add(new int[]{nn, nd});
          distPq[nn].add(nd);
        }else{
          if(distPq[nn].size() == K && distPq[nn].peek() > nd){
            pq.add(new int[]{nn, nd});
            distPq[nn].poll();
            distPq[nn].add(nd);
          }
        }
      }
    }

    StringBuilder sb= new StringBuilder();
    for (int i = 1; i <= V; i++) {
      if (distPq[i].size() != K) {
          sb.append("-1\n");
      } else {
          sb.append(distPq[i].peek()+"\n");
      }
    }

    System.out.print(sb);
  }
}
