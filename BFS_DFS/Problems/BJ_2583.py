# 문제 정의: 부모 노드 찾기
# 문제 유형: 기본 순회
# 수준: 실버 1

# 첫번쨰 시도: DFS
import sys
read = sys.stdin.readline

M, N, K = map(int, read().strip().split())

# graph 만들기
graph = [[0 for _ in range(M)] for _ in range(N)]
for _ in range(K):
  a, b, c, d = map(int, read().strip().split())
  for i in range(a, c):
    for j in range(b, d):
      graph[i][j] = 1

from collections import deque
def bfs(a, b, graph):
  q = deque([(a, b)])
  graph[a][b] = 1
  cnt = 0
  dx= [-1, 1, 0, 0]
  dy= [0, 0, -1, 1]
  while q:
    x, y = q.popleft()
    cnt += 1
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0:
        q.append((nx, ny))
        graph[nx][ny] = 1
  return cnt

result = []
for i in range(N):
  for j in range(M):
    if graph[i][j] == 0:
      result.append(bfs(i, j, graph))

print(len(result))
result.sort()
print(" ".join(map(str, result)))