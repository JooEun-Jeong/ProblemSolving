// 백준 1644 | 연속되는 구간의 합 + 에라토스테네스의 체

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1644 {
  static ArrayList<Integer> primes;
  static int N;
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    primes = new ArrayList<>();
    fill_primes(N);

    int l, r, s, c;
    l = r = s = c = 0;
    while(r < primes.size()){
      s += primes.get(r);
      while(l <= r && N < s){
        s -= primes.get(l);
        l++;
      }

      if(s == N){
        c++;
      }
      r++;
    }
    
    System.out.println(c);
  }

  static void fill_primes(int end){
    int[] pp = new int[end+1];
    pp[0] = 1;
    pp[1] = 1;
    for (int i = 2; i*i <= end; i++) {
      if(pp[i] == 0){
        for (int j = i*i; j <= end; j+=i) { 
          pp[j] = 1;
        }
      }
    }

    for (int i = 0; i <= end; i++) {
      if(pp[i] == 0)
        primes.add(i);
    }
  }
}
