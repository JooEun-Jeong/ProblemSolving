# 문제 정의: 노드 간 거리
# 문제 유형: 기본 순회
# 수준: 실버 1

# 첫번쨰 시도: DFS: 불완전한 종료 조건, 조기 종료 조건 넣음
# 두번쨰 시도: DFS / 32ms
# 세번째 시도: BFS / 존속끼리 1씩 더해주는게 필요함 => 리스트 하나 만들어서, 관련 계산을 저장해둠 / 60ms

N = int(input())
A, B = map(int, input().split())
K = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(K):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

visited = [False] * (N+1)

isKFound = False
def dfs(current, target, cnt):
  global isKFound
  if current == target:
    isKFound = True
    return cnt

  for neighbor in graph[current]:
    if not visited[neighbor]:
      visited[neighbor] = True
      result = dfs(neighbor, target, cnt + 1)
      if isKFound:
        return result
  return cnt

visited[A] = True
result = dfs(A, B, 0)
if isKFound:
    print(result)
else:
    print(-1)

## BFS
# from collections import deque
# results = [0] * (N+1)
# def bfs(cur, rlist):
#   q = deque([cur])
#   visited[cur] = True
#   while q:
#     n = q.popleft()
#     for i in graph[n]:
#       if not visited[i]:
#         q.append(i)
#         visited[i] = True
#         rlist[i] += rlist[n] + 1
# bfs(A, results)
# print(-1 if results[B] == 0 else results[B])