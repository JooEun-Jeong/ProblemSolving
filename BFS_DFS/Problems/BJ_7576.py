# 문제 정의: 2D 배열에서 모든 토마토가 익는 최소 일수 구하기
# 문제 유형: 공간탐색
# 수준: 골드 5
# 접근: BFS:: 깊이 들어가는게 아니기 때문에 BFS로 풀어야함


import sys
sys.setrecursionlimit(10000)
read = sys.stdin.readline

M, N = map(int, read().strip().split())

graph = []
for _ in range(N):
  graph.append(list(map(int, read().strip().split())))

dc = [-1, 1, 0, 0]
dr = [0, 0, -1, 1]

from collections import deque
q = deque([])
def bfs(graph):
  while q:
    cr, cc = q.popleft()
    for i in range(4):
      nc = cc + dc[i]
      nr = cr + dr[i]
      if 0 <= nc < M and 0 <= nr < N and graph[nr][nc] == 0:
        q.append((nr, nc))
        graph[nr][nc] = graph[cr][cc] + 1
  return 

for i in range(N):
  for j in range(M):
    if graph[i][j] == 1:
      q.append((i, j))
bfs(graph)

maxval = -1
for r in graph:
  if 0 in r:
    maxval = -1
    break
  maxval = max(r) if max(r) > maxval else maxval

print(-1 if maxval == -1 else maxval -1)
  