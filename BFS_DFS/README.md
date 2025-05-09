#### BFS 문제 유형

1. **기본 순회:** 
   > 현재 노드를 기준으로 이동할 수 있는 모든 노드를 탐색
    - 예. 단순 그래프 탐색, 특정 값이 있는 노드 찾기

2. **최단 경로**
   > 특정 두 노드 사이의 최단 경로를 탐색
    - 예. 미로 탈출 문제

3. **연결 요소**
    > 현재 노드를 기준으로 연결된 모든 노드를 탐색
    - 예. 섬의 개수 세기

4. **플러드 필**
    > 그래프의 영역을 특정 색상으로 채우는 문제, 일명 땅따먹기 문제
    - 예. 그림 채우기, 땅따먹기 문제.

5. **다중 시작점**
    - 예. 불이 퍼지는 시뮬레이션, 전염병 전파 계산

6. **최소 변경/최소 이동 문제**
    - 예. 벽 부수고 이동하기, 체스판에서 나이트 이동 문제.

--- 

#### DFS 문제 유형

1. **그래프 탐색**
   - 예. 연결 요소(Connected Components) 개수 구하기, 사이클(Cycle) 존재 여부 확인

2. **경로 탐색**
     - 예. 시작점에서 끝점까지의 경로 존재 여부, 미로 찾기 문제(Maze Solving)

3. **부분 집합 및 조합 생성**
     - 예. 부분 집합(Subsets), 조합(Combinations), 순열(Permutations) 생성

4. **트리 문제**
     - 예. 트리의 최대/최소 깊이 계산, 특정 조건을 만족하는 경로 탐색 (예: Path Sum)

5. **섬 문제**
     - 예. 2D 그리드에서 연결된 영역(섬) 개수 구하기, 가장 큰 섬의 크기 구하기

6. **최적화 및 백트래킹 문제**
     - 예. 배낭 문제(Knapsack Problem)와 같은 최적화 문제, 최소 비용 경로 탐색
     - 백트래킹: 순열, 부분집합, 조합, 특정 조건
       - 개념: 정답이 될 수 없는 경우를 빨리 포기하고, 더 좋은 선택을 찾는 방법

7. **퍼즐 탐색 및 상태 공간 탐색**
     - 예. 8-퍼즐 문제, 미로 탈출 문제, Word Search 문제 (그리드에서 특정 단어 탐색)

8. **네트워크 연결 문제**
     - 예. 단절점(Articulation Point) 및 단절선(Bridge) 탐색, 네트워크의 연결 여부 탐색

9. **재귀적 문제**
     - 예. 하노이의 탑 문제, 분할 정복 기반의 문제  

##### sys.setrecursionlimit() 적절한 설정 값
- Python의 **기본 재귀 한도는 보통 1000**으로 설정
- **입력 크기 및 문제 구조 고려:**

     재귀 호출의 깊이가 크거나 입력 데이터 크기가 매우 큰 경우, 기본 한도를 초과할 수 있습니다.
     예를 들어, DFS로 매우 큰 그래프를 탐색하거나, 분할정복 방식에서 매우 깊은 호출 스택이 필요한 경우.  

- **적절한 상한선 설정:**

     보통 10,000~100,000 범위 내에서 설정하는 것이 안전합니다.
     하지만 설정한 값이 지나치게 크면, 호출 스택이 메모리 한도를 초과하여 프로그램이 Segmentation Fault로 종료될 수 있습니다.

참고 문서 1. [코딩테스트 완전정복 ① - BFS 너비우선탐색](https://velog.io/@sihoon_cho/Python%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%99%84%EC%A0%84%EC%A0%95%EB%B3%B5-BFS-%EB%84%88%EB%B9%84%EC%9A%B0%EC%84%A0%ED%83%90%EC%83%89)
