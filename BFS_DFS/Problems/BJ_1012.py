# 문제 정의: 2D 배열에서 이어져있는 밭 개수 세기
# 문제 유형: 땅따먹기
# 수준: 실버 2 / BJ_2667 단지 개수 세기보다 쉬움
# 접근: DFS

import sys 
read = sys.stdin.readline

## dfs 로 풀기 위해선 setrecursionlimit이 꼭 필요하다.
## 동작 시간은 44ms
sys.setrecursionlimit(10000) #[출처] Python3 최대 재귀한도 깊이 설정 ( Maximum recursion depth exceed )|작성자 서브
def dfs(sx, sy, graph):
  dx =[-1, 1, 0, 0]
  dy = [0,0,-1,1]
  for i in range(4):
    nx = sx + dx[i]
    ny = sy + dy[i]
    if(0<=nx<N and 0<=ny<M and graph[nx][ny] == 1):
      graph[nx][ny] = 0
      dfs(nx, ny, graph)

## bfs로 풀기
## 동작 시간은 76ms
from collections import deque
def bfs(sx, sy, graph):
  q = deque([(sx, sy)])
  graph[sx][sy] = 0

  while q:
    x, y = q.popleft()
    dx =[-1, 1, 0, 0]
    dy = [0,0,-1,1]
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if(0<=nx<N and 0<=ny<M and graph[nx][ny] == 1):
        graph[nx][ny] = 0
        q.append((nx, ny))
    
cases = int(input())

for _ in range(cases):
  N, M, L = map(int, read().strip().split())

  graph = [[0] * (M) for _ in range(N)]

  worm_cnt = 0

  for i in range(L):
    a, b = map(int, read().strip().split())
    graph[a][b] = 1
  
  for i in range(N):
    for j in range(M):
      if graph[i][j] == 1:
        graph[i][j] = 0
        bfs(i, j, graph)
        worm_cnt += 1
  
  print(worm_cnt)