// 백준 9020 | 골드바흐의 추측
// 실버 2 | 에라토스테네스의 체, 투 포인터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_9020 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    int T;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int[] numbers = new int[10001];
    ArrayList<Integer> primes = new ArrayList<>();
    numbers[0] = 1;
    numbers[1] = 1;
    for (int i = 2; i * i <= 10000; i++) {
      if (numbers[i] == 0) {
        for (int j = i * i; j <= 10000; j += i) {
          numbers[j] = 1;
        }
      }
    }

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 0) {
        primes.add(i);
      }
    }

    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {

      int base = Integer.parseInt(br.readLine());
      int l = 0, r = primes.size() - 1;
      int an_l = 0, an_r = r;
      while (l <= r) {
        int s = primes.get(l) + primes.get(r);
        if (s > base) {
          r--;
        } else if (s < base) {
          l++;
        } else {
          an_l = l;
          an_r = r;
          l++;
        }
      }

      sb.append(primes.get(an_l) + " " + primes.get(an_r) + "\n");
    }

    System.out.print(sb.toString());
  }
}
