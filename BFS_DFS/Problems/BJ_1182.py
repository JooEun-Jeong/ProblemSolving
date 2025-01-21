# 문제 정의: 부분 수열의 합
# 문제 유형: 백트래킹
# 수준: 실버 2
# 접근: DFS(Backtracking)

N, S = map(int, input().split())
lst = list(map(int, input().split()))
cnt = 0 
def dfs(i, s):
  global cnt
  if i >= N:
    return
  
  if s+lst[i] == S:
    cnt += 1

  # 두 번 찾아서 모든 가능성을 탐색
  dfs(i+1, s+lst[i])
  dfs(i+1, s)  

dfs(0, 0)
print(cnt)