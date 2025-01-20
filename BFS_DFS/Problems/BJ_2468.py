# 문제 정의: 2D 배열에서 조건에 맞는 영역 수 고르기
# 문제 유형: 기본 순회
# 수준: 실버 1
# 접근: BFS
import copy
N = int(input())

graph = []
minval, maxval = 100, 0
for _ in range(N):
  r = list(map(int, input().split()))
  minval = min(r) if min(r) < minval else minval
  maxval = max(r) if max(r) > maxval else maxval
  graph.append(r)

cnt = 0

from collections import deque

# print("minval "+str(minval))
# print("maxval "+str(maxval))
dc = [-1, 1, 0, 0]
dr = [0, 0, -1, 1]
def bfs(r, c, graph, k):
  q = deque([(r,c)])
  graph[r][c] = 0
  while q:
    cr, cc = q.popleft()
    for i in range(4):
      nr = cr + dr[i]
      nc = cc + dc[i]
      if 0<= nr < N and 0<=nc < N and (graph[nr][nc] - k > 0):
        q.append((nr, nc))
        graph[nr][nc] = 0
      
result = [1]
for k in range(minval, maxval):
  graph2 = copy.deepcopy(graph)
  cnt = 0
  for i in range(N):
    for j in range(N):
      if graph2[i][j] - k > 0:
        bfs(i, j, graph2, k)
        cnt +=1
  
  result.append(cnt)

# print(result)
print(max(result))