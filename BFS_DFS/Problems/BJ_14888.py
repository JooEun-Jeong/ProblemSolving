# 문제 정의: 연산자가 배치될 수 있는 모든 경우의 수
# 문제 유형: 백트래킹
# 수준: 실버 2
# 접근: DFS (백트래킹)
# https://jominseoo.tistory.com/97

N = int(input())
nums = list(map(int, input().split())) # 숫자는 그대로 두고? 연산자만 바꿔도 괜찮을까? => ok.
operators = list(map(int, input().split())) # [=, -, x, /]
results = []

max_val, min_val = -1e9, 1e9 # 큰 수 할당
def dfs(i, s):
  global max_val, min_val
  if i == N-1: # 연산자 개수만큼
    max_val = max(s, max_val)
    min_val = min(s, min_val)
    return
  
  # 유효 조건 1
  if operators[0] > 0:
    operators[0] -= 1 # 백트래킹 핵심
    dfs(i+1, s + nums[i+1])
    operators[0] += 1 # 백트래킹 핵심
  
  # 유효 조건 2
  if operators[1] > 0:
    operators[1] -= 1
    dfs(i+1, s - nums[i+1])
    operators[1] += 1
  
  # 유효 조건 3
  if operators[2] > 0:
    operators[2] -= 1
    dfs(i+1, s * nums[i+1])
    operators[2] += 1
  
  # 유효 조건 4
  if operators[3] > 0:
    operators[3] -= 1
    dfs(i+1, int(s / nums[i+1]))
    operators[3] += 1
  
dfs(0, nums[0])
print(max_val)
print(min_val)