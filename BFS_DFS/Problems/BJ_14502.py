# 문제 정의: 2D 배열에서 모든 토마토가 익는 최소 일수 구하기
# 문제 유형: 다중 시작점
# 수준: 골드 4
## 접근
# 가. 바이러스 근처에 벽이 있나 확인 :: 벽을 3개까지 세울 수 있음
# 나. 그 이후, 바이러스를 퍼뜨린다.:: DFS로
# 다. 그래프 마다 0 개수 카운트

R, C = map(int, input().split())

graph = []
for _ in range(R):
  graph.append(list(map(int, input().split())))

# 퍼뜨리기
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def dfs(i, j, graph):
  graph[i][j] == 3
  for k in range(4):
    nx = j + dx[k]
    ny = i + dy[k]
    if 0 <= nx < C and 0 <= ny < R and graph[i][j] == 2:
      dfs(ny, nx, graph)

# 가.


# 나.
for i in range(R):
  for j in range(C):
    if graph[i][j] == 2:
      dfs(i, j, graph)

# 다.
cnt = 0
for r in graph:
  cnt += r.count(0)

print(cnt)