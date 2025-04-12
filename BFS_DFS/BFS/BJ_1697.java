// BFS | 행동 조건에 따라 달라지는 경우

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {
  static int n, k;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int[] visited = new int[100001];

    Queue<Integer> q = new LinkedList<>();
    q.add(n);
    visited[n] = 1;
    while (!q.isEmpty()) {
      int a = q.poll();
      if(a == k){
        break;
      }
      for (int nm: new int[]{a-1, a+1, a*2}) {
        if (nm >= 0 && nm <= 100000) {
          if (visited[nm] == 0 || (visited[nm] != 0 && visited[nm] > (visited[a] + 1))) {
            visited[nm] = visited[a] + 1;
            q.add(nm);
          }
        }
      }
    }

    System.out.println(visited[k]-1);
  }
}
