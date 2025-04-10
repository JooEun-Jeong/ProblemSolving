// DP | 이중 for문을 사용하되, 원하는 범위까지만 동작하도록 조정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1535 {
  static int N, lose[], joy[];

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    lose = new int[N];
    joy = new int[N];
    int health[] = new int[101];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < joy.length; i++) {
      lose[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < joy.length; i++) {
      joy[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      for (int j = 100; j > health[i] - 1; j--) { // health[i] - 1이 kick임!
        if (j - lose[i] > 0) {
          health[j] = Math.max(health[j], health[j - lose[i]] + joy[i]);
        }
      }
    }

    int maxx = 0;
    for (int i = 0; i < health.length; i++) {
      if (maxx < health[i]) {
        maxx = health[i];
      }
    }

    System.out.println(maxx);
  }
}
