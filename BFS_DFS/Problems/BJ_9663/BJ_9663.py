# 문제 정의: N-Queens
# 문제 유형: 백트래킹
# 수준: 골드 4
# 접근: DFS(Backtracking)


# 참고: https://great-park.tistory.com/32
## 첫번째 방법
N = int(input())
cnt = 0
def is_available(candidates, current_col):
  current_row = len(candidates) # 현재 놓을 퀸의 행

  # 걸리면 다른 queen과 자리를 공유하는 것
  for queen_row in range(current_row):
    if candidates[queen_row] == current_col or abs(candidates[queen_row] - current_col) == current_row - queen_row:
      return False
  return True

def dfs(n, cur_row, candidates):
  global cnt
  if cur_row == n:
    cnt += 1
    return
  
  for i in range(n):
    # queen이 다른 곳에 있는 경우
    if is_available(candidates, i):
      candidates.append(i) # 현재 행에 퀸 배치
      dfs(n, cur_row+1, candidates) # cur_row+1해서 다른 행으로 이동
      candidates.pop() # 되돌아가기 ( backtracking의 핵심 )

dfs(N, 0, [])
print(cnt)

#####################################
## 두번째 방법
n, ans = int(input()), 0
a, b, c = [False]*n, [False]*(2*n-1), [False]*(2*n-1)

def dfs(i):
  global ans
  if i == n:
    ans +=1
    return
  
  for j in range(n):
    if not(a[j] or b[i+j] or c[i-j+n-1]):
      a[j] = b[i+j] = c[i-j+n-1] = True
      dfs(i+1)
      a[j] = b[i+j] = c[i-j+n-1] = False # back tracking

dfs(0)
print(ans)