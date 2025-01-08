# 문제 정의: 1번 노드와 연결된 노드의 개수 찾기
# 문제 유형: 연결 요소 찾기
# 접근: BFS / DFS

## BFS
from collections import deque
def bfs(graph, visited):
  q = deque([0])
  visited[0] = True
  cnt = 0
  while q:
    i = q.popleft()
    for j in range(len(graph[i])):
      if graph[i][j] == 1 and not visited[j]:
        visited[j] = True
        cnt+= 1
        q.append(j)
  return cnt

## DFS: 재귀 / cnt를 파라미터로 넘겨주는 경우
def dfs(n, graph, visited, cnt):
  visited[n] = True
  for i in range(len(graph[n])):
    if not visited[i] and graph[n][i] == 1:  # 연결되어 있고 방문하지 않은 경우
      cnt = dfs(i, graph, visited, cnt+1) # n에 graph[n][i]대신 i를 넣어야 한다.
  return cnt

## DFS: 재귀 / global cnt로 작성하는 경우
cnt = 0
def dfs_with_global(n, graph, visited):
  visited[n] = True
  global cnt
  for i in range(len(graph[n])):
    if not visited[i] and graph[n][i] == 1:  # 연결되어 있고 방문하지 않은 경우
      cnt += 1  # 연결된 컴퓨터 수 증가
      dfs(i, graph, visited) # n에 graph[n][i]대신 i를 넣어야 한다.

if __name__ == '__main__':
  computer_n = int(input())
  input_n = int(input())

  visited = [False] * (computer_n)
  visited_d = [False] * (computer_n)
  graph = [[0] * (computer_n) for _ in range(computer_n)]
  for _ in range(input_n):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1
    graph[b-1][a-1] = 1
  
  ## 첫번째 방법 사용시
  # print(bfs(graph, visited))

  ## 두번째 방법 사용시
  # dfs_with_global(0, graph, visited_d)
  # print(cnt)
  
  print(dfs(0, graph, visited_d, 0))
