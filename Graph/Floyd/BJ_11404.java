import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11404 {
  static int V, E;
  static long lst[][];
  static long INF = Long.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    V = Integer.parseInt(br.readLine());
    E = Integer.parseInt(br.readLine());

    lst = new long[V+1][V+1];
    for (long[] r:lst) {
      Arrays.fill(r, INF);
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      
      if(lst[s][e] > c)
        lst[s][e] = c;
    }

    floyd();
  }

  static void floyd(){
    StringBuilder sb = new StringBuilder();

    for (int k = 1; k < lst.length; k++) {
      for (int i = 1; i < lst.length; i++) {
        for (int j = 1; j < lst.length; j++) {
          if(i == j){
            lst[i][j] = 0;
            continue;
          }
          if(lst[i][k] != INF && lst[k][j] != INF){
            lst[i][j] = Math.min(lst[i][j], lst[i][k] + lst[k][j]);
          }
        }
      }
    }

    for (int i = 1; i < lst.length; i++) {
      for (int j = 1; j < lst.length; j++) {
        long k =lst[i][j];
        if(k == INF){
          k = 0;
        }
        sb.append(k + " ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
