# 문제 정의: 2D 배열에서 이어져있는 그림 개수 세기
# 문제 유형: 연결 요소
# 수준: 실버 1
# 접근: DFS (Recursion Error)-> BFS
import sys

## Recursion Error
# sys.setrecursionlimit(10000) # 한도를 더 늘리면 가능할 수도!
# def dfs(x, y, graph, cnt):
#   dx = [-1, 1, 0, 0]
#   dy = [0, 0, -1, 1]
#   graph[x][y] = 0
#   for i in range(4):
#     nx = x + dx[i]
#     ny = y + dy[i]
#     if 0 <= nx < N and 0 <= ny < M and graph[nx][ny]:
#       cnt = dfs(nx, ny, graph, cnt+1)
#   return cnt

from collections import deque
def bfs(x, y, graph):
  cnt = 1
  q = deque([(x, y)])
  graph[x][y] = 0

  dx = [-1, 1, 0, 0]
  dy = [0, 0, -1, 1]
  while q:
    a, b = q.popleft()
    for i in range(4):
      nx = a + dx[i]
      ny = b + dy[i]
      if 0 <= nx < N and 0 <= ny < M and graph[nx][ny]:
        q.append((nx, ny))
        graph[nx][ny] = 0
        cnt += 1
  return cnt

N, M = map(int, input().split())

graph = []

for _ in range(N):
  graph.append(list(map(int, input().split())))

result = []
for i in range(N):
  for j in range(M):
    if graph[i][j]:
      # result.append(dfs(i, j, graph, 1))
      result.append(bfs(i, j, graph))

result.sort()
print(len(result))
print(result[-1] if len(result)!=0 else 0)