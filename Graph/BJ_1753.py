# 문제 정의: 부모 노드 찾기
# 문제 유형: 최단 경로
# 수준: 골드 4
## 첫번째 접근법: graph를 dictionary로 구성 => python이면 시간초과, pypy3면 통과
## 두번째 접근법: graph를 list로 구성(dictionary보단 빠름) => python이면 시간초과, pypy3면 통과

import heapq

def dijkstra(graph, start):
  distances = {node: float('inf') for node in range(1, len(graph))}
  distances[start] = 0
  pq = [(0, start)]

  while pq:
    c_distance, c_node = heapq.heappop(pq)
    if c_distance > distances[c_node]:
      continue
  
    for nei, we in graph[c_node]:
      distance = c_distance + we
      if distance < distances[nei]:
        distances[nei] = distance
        heapq.heappush(pq, (distance, nei))
  
  return distances

V, E = map(int, input().split())
start = int(input())

graph = [[] for _ in range(V+1)]

for _ in range(E):
  a, b, w = map(int, input().split())
  graph[a].append((b, w))

result = dijkstra(graph, start)

for key, value in result.items():
  if value == float('inf'):
    print('INF')
  else:
    print(value)