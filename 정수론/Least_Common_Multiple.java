// 백준 13241 | 최소공배수
// 실버 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Least_Common_Multiple {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long a, b;
    a = Long.parseLong(st.nextToken());
    b = Long.parseLong(st.nextToken());

    long gc = gcd(a, b);
    long result = 1;
    if (gc == 1) {
      result = a * b;
    } else {
      result = a * b / gc;
    }
    System.out.println(result);
  }

  static long gcd(long a, long b) {
    while (b != 0) {
      long k = a % b;
      a = b;
      b = k;
    }
    return a;
  }
}
