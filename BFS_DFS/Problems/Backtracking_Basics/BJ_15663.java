// 문제 정의: 중복제거한 문자열 사전순 출력
// 문제 유형: 백트래킹
// 수준: 실버 2 
// 접근: DFS를 활용한 백트래킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TreeSet으로 구현시, O(N!logN!)
// 배열로 구현시, O(N!)
public class BJ_15663 {
  static int M, N;
  static int[] arr, result;
  static boolean[] visited;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken()); 
    M = Integer.parseInt(st.nextToken()); 

    arr = new int[N];
    visited = new boolean[N]; // index로 구분해보자.
    result = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    dfs(0);

    System.out.print(sb.toString());
    

  }

  static void dfs(int depth){
    if(depth == M){
      for (int i = 0; i < M; i++) {
        sb.append(result[i] + " ");
      }
      sb.append("\n");
      return;
    }
    int prev = -1;
    for (int i = 0; i < arr.length; i++) {
      if(visited[i] == false && arr[i] != prev){
        visited[i] = true;
        result[depth] = arr[i];
        prev = arr[i];
        dfs(depth+1);
        visited[i] = false;
      }
    }
  }
}
