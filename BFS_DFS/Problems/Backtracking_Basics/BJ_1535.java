// 백트래킹 + 완탐 | 하지만, DP로도 푸는 것이 시간복잡도 측면에서 더 효율적임
// 정해진 체력 안에서 최대의 가치 뽑아내기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1535 {
  static int joy[], lose[];
  static int N;
  static ArrayList<Integer> lst;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    lose = new int[N];
    joy = new int[N];
    lst = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < joy.length; i++) {
      lose[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < joy.length; i++) {
      joy[i] = Integer.parseInt(st.nextToken());
    }
    check(0, 0, 100);

    int maxx = 0;
    for (int i = 0; i < lst.size(); i++) {
      if (maxx < lst.get(i)) {
        maxx = lst.get(i);
      }
    }
    System.out.println(maxx);
  }

  static void check(int i, int sum, int life) {
    if (life > 0 && i == N) {
      lst.add(sum);
      return;
    }
    if (life <= 0) {
      return;
    }
    int l = lose[i];
    int j = joy[i];

    check(i + 1, sum + j, life - l);
    check(i + 1, sum, life);
  }
}
