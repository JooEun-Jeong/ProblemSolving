// 백준 9251 | LCS 최장 공통 부분 문자열의 길이 구하기
// 골드 5 | DP. 규칙 찾아내기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_length {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first, second;
    first = br.readLine();
    second = br.readLine();

    int[][] len = new int[first.length() + 1][second.length() + 1]; // 모두 0
    for (int i = 1; i <= first.length(); i++) {
      for (int j = 1; j <= second.length(); j++) {
        if (first.charAt(i - 1) == second.charAt(j - 1)) {
          len[i][j] = len[i - 1][j - 1] + 1;
        } else {
          len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
        }
      }
    }
    System.out.println(len[first.length()][second.length()]);
  }
}
