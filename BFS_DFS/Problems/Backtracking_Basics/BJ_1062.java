import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1062 {
  static int N, K, bit, maxCount;
  static int words[];
  static int learnable[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    learnable = new int[26];

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    bit = 1;
    bit = bit | 1 << ('n' - 'a');
    bit = bit | 1 << ('t' - 'a');
    bit = bit | 1 << ('i' - 'a');
    bit = bit | 1 << ('c' - 'a');
    maxCount = 0;

    
    if (K < 5) {
      System.out.println("0");
      return;
    }
    
    if (K == 26) {
      System.out.println(N);
      return;
    }
    
    words = new int[N];
    for (int i = 0; i < N; i++) {
      words[i] = encodeWordToBit(br.readLine());
    }

    for (char c = 'a'; c <= 'z'; c++){
      if ((bit & (1 << (c - 'a'))) == 0) {
        learnable[c - 'a'] = 1;
      }
    }

    dfs(0, 0);

    System.out.println(maxCount);
  }

  static void dfs(int count, int idx) {
    if (K - 5 == count) {
      maxCount = Math.max(maxCount, learnableCount());
    }

    for (int i = idx; i < 26; i++) {
      if(learnable[i] != 0){
        int alpha = i;
        bit |= 1 << (alpha);
        dfs(count+1, i+1);
        bit &= ~(1 << (alpha));
      }
    }
  }

  static int encodeWordToBit(String a) {
    int w = 1;
    for (char c : a.toCharArray()) {
      w |= (1 << (c - 'a'));
    }
    return w;
  }

  static int learnableCount() {
    int count = 0;
    for (int word : words) {
      if ((word & ~bit) == 0) {
        count++;
      }
    }
    return count;
  }
}
