# 문제 정의: 모든 경우의 수이며, 유효하지 않은 조건은 사전에 제거한다.
# 문제 유형: 백트래킹
# 수준: 실버 1
# 접근: DFS 

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

min_difference = float('inf')
visited = [False] * n

def calc_team_score(team):
  score = 0
  for i in range(len(team)):
    for j in range(i+1, len(team)):
      score += graph[team[i]][team[j]] + graph[team[j]][team[i]]
  return score

def dfs(depth, idx):
  global min_difference

  # 선택한 인원이 절반일 때
  if depth == n // 2:
    team_a = [i for i in range(n) if visited[i]] # 
    team_b = [i for i in range(n) if not visited[i]]

    score_a = calc_team_score(team_a)
    score_b = calc_team_score(team_b)
    # print(f"team a: {team_a} score_a: {score_a}")
    # print(f"team b: {team_b} score_b: {score_b}")
    # print()

    min_difference = min(min_difference, abs(score_a - score_b))
    return

  for i in range(idx, n):
    if not visited[i]: # 유효한 경우를 탐색
      visited[i] = True
      dfs(depth + 1, i + 1)
      visited[i] = False 

dfs(0, 0)
print(min_difference)