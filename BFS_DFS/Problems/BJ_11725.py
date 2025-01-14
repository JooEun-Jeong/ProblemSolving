# 문제 정의: 부모 노드 찾기
# 문제 유형: 연결 요소 찾기
# 수준: 실버 2

# 첫번쨰 시도: DFS/ 정보를 2차원 graph로 받자. N*N 메모리를 만들자 => 최대 100억 메모리 => 메모리 에러
# 두번째 시도: DFS/ 정보를 hash로 받자. => Runtime Error = Recursion Error
# 세번째 시도: BFS => 자식 노드로 들어가기 전에 미리 저장

import sys
read = sys.stdin.readline
sys.setrecursionlimit(10000)
# def dfs(v, pv, graph, visited, parents):
#   visited[v] = True
#   parents[v] = pv
#   for i in range(1, N+1):
#     if not visited[i] and graph[v][i] == 1:
#       dfs(i, v, graph, visited, parents)

def dfs(v, pv, hash, visited, parents):
  visited[v] = True
  parents[v] = pv
  # print("v: "+ str(v))
  for i in hash[v]:
    if not visited[i]:
      dfs(i, v, hash, visited, parents)

from collections import deque
def bfs(v, hash, visited, parents):
  q = deque([v])
  visited[v] = True
  while q:
    n = q.popleft()
    for v in hash[n]:
      if parents[v] == 0:
        parents[v] = n
        q.append(v)


N = int(read().strip())

# graph = [[0] * (N+1) for _ in range(N+1)]
hash =  {key: [] for key in range(1, N + 1)}
visited = [False] * (N+1)
parents = [0] * (N+1)

for i in range(N-1):
  a, b = map(int, read().strip().split())
  # graph[a][b] = 1
  # graph[b][a] = 1
  hash[a].append(b)
  hash[b].append(a)

# dfs(1, 1, graph, visited, parents)
# dfs(1, 1, hash, visited, parents)
bfs(1, hash, visited, parents)

# print(hash)
print("\n".join(map(str, parents[2:])))