import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2473 {
  static int n, arr[];

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(st.nextToken());
      arr[i] = a;
    }

    Arrays.sort(arr);

    int result[] = new int[3];
    // 밑에는 완전탐색을 하지 못함.
    // int l = 0, r = n - 1;
    // long prevSum = Integer.MAX_VALUE;
    // while (l < (r - 1)) {
    //   int a = arr[l];
    //   int c = arr[r];
    //   long sum = a + c;
    //   for (int i = l + 1; i < r; i++) {
    //     int b = arr[i];
    //     if (sum > 0 && arr[i] < 0) {
    //       b = arr[i];
    //     } else if (sum < 0 && arr[i] > 0) {
    //       b = arr[i];
    //     }
    //     sum += b;
    //     if (Math.abs(prevSum) > Math.abs(sum)) {
    //       prevSum = sum;
    //       result[0] = a;
    //       result[1] = b;
    //       result[2] = c;
    //     }
    //     sum -= b;
    //   }

    //   if (sum > 0) {
    //     r--;
    //   } else if (sum < 0) {
    //     l++;
    //   } else {
    //     break;
    //   }
    // }
    long bestSum = Long.MAX_VALUE;
    for (int i = 0; i < n - 2; i++) {
      int mid = i + 1;
      int right = n - 1;

      while (mid < right) {
        long sum = (long) arr[i] + arr[mid] + arr[right];

        if (Math.abs(sum) < Math.abs(bestSum)) {
          bestSum = sum;
          result[0] = arr[i];
          result[1] = arr[mid];
          result[2] = arr[right];
        }

        if (sum < 0) {
          mid++;
        } else {
          right--;
        }
      }
    }
    for (int i = 0; i < result.length; i++) {
      sb.append(result[i] + " ");
    }

    System.out.println(sb.toString());
  }
}
