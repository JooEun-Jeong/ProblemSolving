// 백준 2166
// 기하학
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2166 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    double[] x = new double[n];
    double[] y = new double[n];

    // 좌표 입력
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Double.parseDouble(st.nextToken());
      y[i] = Double.parseDouble(st.nextToken());
    }

    double sum1 = 0.0, sum2 = 0.0;

    // 신발끈 공식 적용
    for (int i = 0; i < n; i++) {
      int next = (i + 1) % n; // 마지막 점과 첫 번째 점을 연결
      sum1 += x[i] * y[next];
      sum2 += y[i] * x[next];
    }

    double area = Math.abs(sum1 - sum2) / 2.0;

    System.out.println(String.format("%.1f", area)); // 자동 소수 둘째자리에서 반올림
  }
}
