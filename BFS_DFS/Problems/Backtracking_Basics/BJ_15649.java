// 백트래킹 | 1부터 N까지의 수 중에서 중복 없이 M개를 고른 수열을 모두 출력

// 시간복잡도 자체는 동일하지만, 실제 실행시간은 배열 방식이 더 빠르고 가벼움.
//  Deque는 구조적으로 유연하지만, 단순 순역 백트래킹에서는 배열이 최적.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_15649 {
  static int N, M;
  static StringBuilder sb = new StringBuilder();
  static Deque<Integer> dq = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    boolean[] visited = new boolean[N + 1];
    backtrack(visited, 0);

    System.out.print(sb.toString());
  }

  static void backtrack(boolean[] visited, int n) {
    if (dq.size() == M) {
      Iterator<Integer> it = dq.iterator();
      while (it.hasNext()) {
        int item = it.next();
        sb.append(item + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (n != i && !visited[i]) {
        visited[i] = true;
        dq.add(i);
        backtrack(visited, i);
        dq.removeLast();
        visited[i] = false;
      }
    }
  }
}
