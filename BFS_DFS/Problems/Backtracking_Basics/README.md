### 백트래킹 적용 과정
1. 모든 경우의 수를 탐색해야 한다면 DFS (재귀) 구조부터 만든다.
2. "선택한 숫자"를 저장할 배열과 "방문 여부"를 체크할 배열을 만든다.
3. 탐색이 끝났을 때 백트래킹을 위해 방문 여부를 원래 상태로 돌려놓는다.
4. 중복된 경우를 방지하기 위해 prev 변수를 활용하여 같은 depth에서 같은 숫자를 건너뛴다.
5. 문제에 따라 추가적인 가지치기 (Pruning)를 고민한다

#### 핵심 포인트
- 백트래킹은 "모든 경우를 탐색하되, 불필요한 경우는 미리 제거" 하는 기법이다.
- 순열 문제에서는 재귀(DFS) + 방문 체크 + 백트래킹 을 적용하면 해결할 수 있다.
- 중복을 방지하려면 정렬 후 prev 변수를 사용하여 같은 depth에서 같은 숫자를 두 번 고르지 않도록 한다.


#### Backtracking의 기본 골자가 되는 문제들
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
  - [N과 M 1](https://www.acmicpc.net/problem/15649)
- 1부터 N까지의 수를 중복 없이 M개 고른 수열 + 오름차순
  - [N과 M 2](https://www.acmicpc.net/problem/15650)
- 1부터 N까지의 수를 중복해서 M개 고른 수열
  - [N과 M 3](https://www.acmicpc.net/problem/15651)
- 1부터 N까지의 수를 중복해서 M개 고른 수열 + 비내림차순
  - [N과 M 4](https://www.acmicpc.net/problem/15652)
- N개의 자연수 중에서 M개를 중복없이 고른 수열
  - [N과 M 5](https://www.acmicpc.net/problem/15654)
- N개의 자연수 중에서 M개를 중복없이 고른 수열 + 오름차순
  - [N과 M 6](https://www.acmicpc.net/problem/15655)
- N개의 자연수 중에서 M개를 중복해서 고른 수열
  - [N과 M 7](https://www.acmicpc.net/problem/15656)
- N개의 수를 중복해서 M개 고른 수열 + 비내림차순
  - [N과 M 8](https://www.acmicpc.net/problem/15657)
- N개의 자연수 중에서 M개를 중복없이  고른 수열 + 오름차순
  - [N과 M 9](https://www.acmicpc.net/problem/15663)