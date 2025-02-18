>> 위상정렬(Topological Sort)은 **방향성이 있는 그래프에서 노드들을 선형적으로 정렬하는 알고리즘**으로, 일반적으로 **순서가 있는 작업, 선수 과목, 작업 스케줄링** 등의 문제에서 자주 출제됩니다.

---

### 📌 **코딩테스트에서 나오는 위상정렬 유형**
#### 1️⃣ 기본적인 위상정렬 (BFS: Kahn’s Algorithm)
- **유형**: 단순한 위상정렬 결과 출력
- **변형**: 여러 개의 위상정렬 결과가 가능할 수도 있음
- **예시 문제**: 백준 [2252번 줄 세우기](https://www.acmicpc.net/problem/2252)

✅ **코드 (BFS 방식)**
```java
import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 개수
        int M = sc.nextInt(); // 간선 개수

        List<Integer>[] graph = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (--inDegree[next] == 0) queue.add(next);
            }
        }
    }
}
```

---

#### 2️⃣ **위상정렬을 활용한 선수 과목 문제**
- **유형**: 각 과목을 이수하는 데 걸리는 시간을 고려해야 함
- **변형**: 단순 정렬이 아니라 **완료 시간 계산**
- **예시 문제**: 백준 [14567번 선수과목](https://www.acmicpc.net/problem/14567)

✅ **코드 (최소 시간 계산)**
```java
import java.util.*;

public class PrerequisiteCourses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        List<Integer>[] graph = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1], time = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            graph[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                time[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                time[next] = Math.max(time[next], time[node] + 1);
                if (--inDegree[next] == 0) queue.add(next);
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(time[i] + " ");
    }
}
```

---

#### 3️⃣ **사이클 판별 (DAG인지 확인)**
- **유형**: 위상정렬이 가능한지 여부를 판단하는 문제
- **변형**: 위상정렬이 불가능하면 사이클이 존재함
- **예시 문제**: 백준 [9466번 텀 프로젝트](https://www.acmicpc.net/problem/9466)

✅ **코드 (사이클 확인)**
```java
import java.util.*;

public class CycleDetection {
    public static boolean topologicalSort(int N, List<Integer>[] graph, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 1; i <= N; i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int next : graph[node]) {
                if (--inDegree[next] == 0) queue.add(next);
            }
        }
        return count == N; // N개 모두 처리되었으면 사이클 없음
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        List<Integer>[] graph = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            graph[a].add(b);
            inDegree[b]++;
        }

        if (topologicalSort(N, graph, inDegree)) {
            System.out.println("위상정렬 가능 (DAG)");
        } else {
            System.out.println("사이클 존재");
        }
    }
}
```

---

#### 4️⃣ **위상정렬을 활용한 문제 해결 (가장 긴 경로)**
- **유형**: 위상정렬을 이용하여 최장 경로를 구해야 하는 문제
- **변형**: 그래프의 경로를 고려하는 문제
- **예시 문제**: 백준 [2056번 작업](https://www.acmicpc.net/problem/2056)

✅ **코드 (DAG의 최장 경로)**
```java
import java.util.*;

public class LongestPathInDAG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer>[] graph = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1], time = new int[N + 1], dp = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            int pre = sc.nextInt();
            for (int j = 0; j < pre; j++) {
                int prev = sc.nextInt();
                graph[prev].add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                dp[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                dp[next] = Math.max(dp[next], dp[node] + time[next]);
                if (--inDegree[next] == 0) queue.add(next);
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) answer = Math.max(answer, dp[i]);
        System.out.println(answer);
    }
}
```

---

### 📌 **정리**
| 유형 | 특징 | 예제 문제 |
|------|------|----------|
| 기본 위상정렬 | 단순한 정렬 | [2252번 줄 세우기](https://www.acmicpc.net/problem/2252) |
| 선수 과목 | 최단 시간 계산 | [14567번 선수과목](https://www.acmicpc.net/problem/14567) |
| 사이클 판별 | DAG 여부 확인 | [9466번 텀 프로젝트](https://www.acmicpc.net/problem/9466) |
| 최장 경로 | DAG에서 최장 작업 시간 | [2056번 작업](https://www.acmicpc.net/problem/2056) |


*Generated by OpenAI*