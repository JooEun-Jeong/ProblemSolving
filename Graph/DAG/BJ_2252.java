import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2252 {
  public static void main(String[] args) throws IOException {
    int N, M;
    List<List<Integer>> lst = new ArrayList<>();
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[] ind = new int[N+1];
    for (int i = 0; i <= N; i++) {
      lst.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      int a,b;
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      lst.get(a).add(b);
      ind[b]++;
    }

    Queue<Integer> q = new LinkedList<>();
    
    for (int i = 1; i < ind.length; i++) {
      if(ind[i] == 0){
        q.add(i);
      }
    }

    while(!q.isEmpty()){
      int cur = q.poll();

      sb.append(cur+ " ");
      for(int next: lst.get(cur)){
        if(--ind[next] == 0){
          q.add(next);
        }
      }
    }
    System.out.println(sb);
  }
}
