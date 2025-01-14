# 문제 정의: 연결 요소 (Connected Component)의 개수
# 문제 유형: 연결 요소 찾기
# 수준: 실버 2
# 접근: BFS 
import sys
read = sys.stdin.readline
N, M = map(int, input().split())

nodes = [[] for _ in range(N+1)]

for _ in range(1, M+1):
  a, b = map(int, read().strip().split())
  nodes[a].append(b)
  nodes[b].append(a)

from collections import deque
def bfs(v, nodes, visited):
  visited[v] = True
  q = deque([v])
  while q:
    n = q.popleft()
    for i in nodes[n]:
      if not visited[i]:
        q.append(i)
        visited[i] = True

visited = [False] * (N+1)

result = 0
for i in range(1, N+1):
  for j in nodes[i]:
    if not visited[j]:
      # if len(nodes[i]) == 0:
      #   visited[i] = True  
      # else:
      bfs(i, nodes, visited)
      result += 1

print(result)

# import sys
# read = sys.stdin.readline
# N, M = map(int, input().split())

# graph = [[0] * (N+1) for _ in range(N+1)]

# for _ in range(M):
#   a, b = map(int, read().strip().split())
#   graph[a][b] = 1
#   graph[b][a] = 1

# from collections import deque
# def bfs(v, graph, visited):
#   visited[v] = True
#   q = deque([v])
#   while q:
#     n = q.popleft()
#     for i in range(len(graph[n])):
#       if graph[n][i] == 1 and not visited[i]:
#         graph[n][i] = 0
#         q.append(i)
#         visited[i] = True

# visited = [False] * (N+1)

# result = 0
# for i in range(1, N+1):
#   for j in range(1, N+1):
#     if graph[i][j] == 1 and not visited[i]:
#       bfs(i, graph, visited)
#       result += 1

# print(result)