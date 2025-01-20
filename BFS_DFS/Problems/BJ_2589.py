# 문제 정의: 최단 거리 중 가장 긴 최단거리 찾기
# 문제 유형: 기본 순회
# 수준: 골드 5
# 접근: BFS / 모든 graph를 돌아. : 그런데 방향이 2개(상하, 좌우 중 1개씩 인 경우에만!)

import copy

R, C = map(int, input().split())
graph = []
for _ in range(R):
  graph.append(list(input()))

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
from collections import deque
def bfs(r, c, graph):
  q = deque([(r, c)])
  graph[r][c] = 0
  while q:
    cr, cc = q.popleft()
    for k in range(4):
      nr, nc = cr + dr[k], cc + dc[k]
      if 0 <= nr < R and 0 <= nc < C and graph[nr][nc] == 'L':
        q.append((nr,nc))
        graph[nr][nc] = graph[cr][cc] + 1

for i in range(R):
  for j in range(C):
    if graph[i][j] == 'L':
      bfs(i, j, graph)
    if graph[i][j] == 'W':
      graph[i][j] = -1

result = 0
for r in graph:
  result = max(r) if result < max(r) else result
  
# print(graph)

print(result+1)