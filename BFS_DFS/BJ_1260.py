# 가장 기본이 되는 dfs, bfs 구조
## 1. graph 표현 방법
## 2. dfs, bfs별 중요 포인트 잡기
##     => 특정 종료 조건, 이동조건
import sys

# graph가 2D array로 노드와의 관계를 표현했음
# graph를 dictionary로 표현할 경우의 문제점: 
#   숫자가 작은 것부터 순회해야하는데, 따로 정렬이 필요함
def dfs(node, graph, visited_d):
  visited_d.add(node)
  print(node, end=" ")
  for idx in range(1, len(graph[node])):
    if graph[node][idx] and idx not in visited_d:
      dfs(idx, graph, visited_d)

from collections import deque
def bfs(node, graph, visited_b):
  que = deque([node])
  while que:
    cur_node = que.popleft()
    print(cur_node, end=" ")
    for idx in range(1, len(graph[cur_node])):
      if graph[cur_node][idx] and idx not in visited_b:
        visited_b.add(idx)
        que.append(idx)
  return -1

if __name__ == '__main__':
  read = sys.stdin.readline
  node_num, line_num, start_node = map(int, read().split())

  graph = [[False] * (node_num+1) for _ in range(node_num+1)]

  for _ in range(line_num):
    n, m = map(int, read().split())
    
    graph[n][m] = True
    graph[m][n] = True

  # print(graph)
  visited_d = set()
  visited_b = set([start_node])
  dfs(start_node, graph, visited_d)
  print()
  bfs(start_node, graph, visited_b)
