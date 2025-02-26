import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9663 {

  static int N, count;
  static boolean[] col, diag1, diag2; // 세로 열, 우하향 대각선, 좌하향 대각선 체크 배열

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    col = new boolean[N]; // 세로 방향 체크
    diag1 = new boolean[2 * N]; // 우하향 대각선 체크 (r + c)
    diag2 = new boolean[2 * N]; // 좌하향 대각선 체크 (r - c + N)

    count = 0;
    backtracking(0);
    System.out.println(count);
  }

  static void backtracking(int row) {
    if (row == N) { // 모든 행에 퀸을 배치 완료
      count++;
      return;
    }

    for (int c = 0; c < N; c++) { // 해당 행(row)에 대해 가능한 열(c) 탐색
      if (col[c] || diag1[row + c] || diag2[row - c + N])
          continue;

      // 현재 (row, c)에 퀸 배치
      col[c] = diag1[row + c] = diag2[row - c + N] = true;
      backtracking(row + 1); // 다음 행으로 이동
      col[c] = diag1[row + c] = diag2[row - c + N] = false; // 원상복구
    }
  }
}
