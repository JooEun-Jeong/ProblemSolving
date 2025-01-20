# 문제 정의: 최단 거리 중 가장 긴 최단거리 찾기
# 문제 유형: 기본 순회
# 수준: 골드 5
# 접근: BFS / 모든 graph를 돌아

R, C = map(int, input().split())
graph = []
for _ in range(R):
  graph.append(list(input()))

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
from collections import deque
def bfs(r, c, graph):
  q = deque([(r, c)])
  visited = [[-1] * C for _ in range(R)]  # 그래프를 돌면서 각 시작점부터의 최고 거리를 찾아야하므로 새로운 배열 생성
  visited[r][c] = 0
  max_dist = 0  # 최장거리 반환

  while q:
    cr, cc = q.popleft()
    for k in range(4):
      nr, nc = cr + dr[k], cc + dc[k]
      if 0 <= nr < R and 0 <= nc < C and graph[nr][nc] == 'L' and visited[nr][nc] == -1:
        q.append((nr,nc))
        visited[nr][nc] = visited[cr][cc] + 1
        max_dist = max(max_dist, visited[nr][nc])
  return max_dist

result = 0
for i in range(R):
  for j in range(C):
    if graph[i][j] == 'L':
      result = max(result, bfs(i, j, graph))  # 가장 긴 최단거리 찾기

print(result)