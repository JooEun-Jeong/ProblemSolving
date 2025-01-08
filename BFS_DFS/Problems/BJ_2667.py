# 문제 정의: 2D 배열에서 단지 개수 세기
# 문제 유형: 땅따먹기
# 접근: DFS

def dfs(sx, sy, graph, cnt):
  dx = [-1, 1, 0, 0]
  dy = [0, 0, -1, 1]
  for i in range(4):
    nx = sx + dx[i]
    ny = sy + dy[i]
    if (0<= nx < N and 0 <=ny<N and graph[nx][ny] == 1):
      graph[nx][ny] = 0
      cnt = dfs(nx, ny, graph, cnt+1)
  if cnt == 0:
    cnt =1
  return cnt

N = int(input())

graph = [list(map(int, input())) for _ in range(N)]

answers = []
for i in range(N):
  for j in range(N):
    if graph[i][j] == 1:
      answers.append(dfs(i, j, graph, 0))

print(len(answers))
answers.sort()
print("\n".join(map(str, answers)))