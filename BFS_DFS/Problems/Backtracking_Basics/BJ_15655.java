import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655 {
  static int N, M;
  static boolean visited[];
  static int result[];
  static int arr[];
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    result= new int[M];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    dfs(0, 0);

    System.out.print(sb.toString());
  }

  static void dfs(int depth, int j){
    if(depth == M){
      for (int i = 0; i < M; i++) {
        sb.append(result[i] + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = j; i < arr.length; i++) {
      if(!visited[i]){
        visited[i] = true;
        result[depth] = arr[i];
        dfs(depth+1, i+1);
        visited[i] = false;
      }
    }
  }
}
