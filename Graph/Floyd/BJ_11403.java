import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403 {
  static int[][] lst;
  static int N;
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    lst = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        lst[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] result = floyd();
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result.length; j++) {
        sb.append(result[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static int[][] floyd(){
    int[][] dist = new int[N][N];

    for (int i = 0; i < dist.length; i++) {
      for (int j = 0; j < dist.length; j++) {
        dist[i][j] = lst[i][j];
      }
    }

    for (int k = 0; k < dist.length; k++) { // 중간
      for (int i = 0; i < dist.length; i++) { // 시작노드
        for (int j = 0; j < dist.length; j++) { // 도착
          if(dist[i][k] != 0 && dist[k][j] != 0){
            dist[i][j] = 1;
          }
        }
      }
    }

    return dist;
  }
}
