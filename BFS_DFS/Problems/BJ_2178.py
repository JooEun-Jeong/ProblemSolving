# 문제 정의: N, M까지 가야하는 최소 이동 개수
# 문제 유형: 최단 경로
# 접근: BFS (최소 이동 칸 수)

## graph 자체를 변형하면서 이동한 경우
import sys
from collections import deque

def bfs(sx, sy, graph, visited):
  que = deque([(sx, sy)])
  dx = [1, -1, 0, 0]
  dy = [0, 0, 1, -1]
  visited[sx][sy] = True
  while que:
    x, y = que.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if(0 <= nx < N and 0 <= ny < M):
        if (graph[nx][ny] == 1 and not visited[nx][ny]):
          que.append((nx, ny))
          visited[nx][ny] = True
          graph[nx][ny] = graph[x][y] + 1
    
## 응용1. 만약 shortest path를 출력한다면?
def bfs_with_path(sx, sy, graph, visited):
  que = deque([(sx, sy)])
  dx = [1, -1, 0, 0]
  dy = [0, 0, 1, -1]
  visited[sx][sy] = True
  predecessors = [[None for _ in range(M)] for _1 in range(N)] ## 경로 값 따로 저장
  while que:
    x, y = que.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if(0 <= nx < N and 0 <= ny < M):
        if (graph[nx][ny] == 1 and not visited[nx][ny]):
          que.append((nx, ny))
          visited[nx][ny] = True
          graph[nx][ny] = graph[x][y] + 1
          predecessors[nx][ny] = [x, y] 

  # 경로 재설정
  path = []
  current = [N-1, M-1]

  # current가 None이 될 때까지, current를 업데이트한다.
  while current: # 경로 타고타고 가기
      path.append(current)
      current = predecessors[current[0]][current[1]]
  return path[::-1] # reverse the list

if __name__ == "__main__":
  read = sys.stdin.readline
  N, M = map(int, read().split())

  graph = [list(map(int, read().strip())) for _ in range(N)]
  
  visited = [[False] * (M) for _ in range(N)]
  
  bfs(0, 0, graph, visited)
  print(graph[N-1][M-1])
  # bfs_with_path(0, 0, graph, visited)
  # print(bfs_with_path(0, 0, graph, visited))

