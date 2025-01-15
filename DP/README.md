### DP 문제 유형
> 문제를 작은 부분의 문제로 쪼개고,  
> 이 부분 문제들의 해를 저장하여 재사용  
> = 점화식 / 메모이제이션

---

#### 1. **Fibonacci 수열**
##### 문제 유형:
- 피보나치 수열의 n번째 값을 계산하기

##### 해결 방법:
1. **재귀적 접근(Top-Down)**:
   - 메모이제이션(Memoization)을 사용하여 이미 계산한 값을 저장.
   ```python
   def fib(n, memo={}):
       if n in memo:
           return memo[n]
       if n <= 1:
           return n
       memo[n] = fib(n-1, memo) + fib(n-2, memo)
       return memo[n]
   ```

2. **반복적 접근(Bottom-Up)**:
   - DP 테이블을 사용하여 작은 값부터 계산.
   ```python
   def fib(n):
       dp = [0] * (n + 1)
       dp[1] = 1
       for i in range(2, n + 1):
           dp[i] = dp[i - 1] + dp[i - 2]
       return dp[n]
   ```

---

#### 2. **배낭 문제(Knapsack Problem)**
##### 문제 유형:
- 물건의 무게와 가치를 고려하여 배낭에 넣을 수 있는 최대 가치를 계산하기.

##### 해결 방법:
1. **DP 테이블 정의**:
   - `dp[i][w]`: i번째 물건까지 고려했을 때, 배낭 용량 w에서의 최대 가치.

2. **점화식**:
   - 물건을 선택하지 않는 경우: `dp[i][w] = dp[i-1][w]`
   - 물건을 선택하는 경우: `dp[i][w] = dp[i-1][w-weight[i]] + value[i]`

3. **구현**:
   ```python
   def knapsack(weights, values, capacity):
       n = len(weights)
       dp = [[0] * (capacity + 1) for _ in range(n + 1)]
       for i in range(1, n + 1):
           for w in range(capacity + 1):
               if weights[i-1] <= w:
                   dp[i][w] = max(dp[i-1][w], dp[i-1][w-weights[i-1]] + values[i-1])
               else:
                   dp[i][w] = dp[i-1][w]
       return dp[n][capacity]
   ```

---

#### 3. **최장 증가 부분 수열(Longest Increasing Subsequence, LIS)**
##### 문제 유형:
- 주어진 배열에서 가장 긴 증가하는 부분 수열의 길이를 계산.

##### 해결 방법:
1. **점화식**:
   - `dp[i]`: i번째 요소를 포함했을 때의 LIS 길이.
   - 점화식: `dp[i] = max(dp[j] + 1)`, (j < i이고, arr[j] < arr[i])

2. **구현**:
   ```python
   def lis(arr):
       n = len(arr)
       dp = [1] * n
       for i in range(1, n):
           for j in range(i):
               if arr[j] < arr[i]:
                   dp[i] = max(dp[i], dp[j] + 1)
       return max(dp)
   ```

---

#### 4. **최소 비용 경로(Minimum Path Sum)**
##### 문제 유형:
- 2D 그리드에서 왼쪽 위에서 오른쪽 아래로 이동할 때, 최소 비용을 계산.

##### 해결 방법:
1. **DP 테이블 정의**:
   - `dp[i][j]`: (i, j)까지 이동하는 데 필요한 최소 비용.

2. **점화식**:
   - `dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])`

3. **구현**:
   ```python
   def min_path_sum(grid):
       m, n = len(grid), len(grid[0])
       dp = [[0] * n for _ in range(m)]
       dp[0][0] = grid[0][0]
       for i in range(m):
           for j in range(n):
               if i == 0 and j == 0:
                   continue
               if i == 0:
                   dp[i][j] = dp[i][j-1] + grid[i][j]
               elif j == 0:
                   dp[i][j] = dp[i-1][j] + grid[i][j]
               else:
                   dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
       return dp[m-1][n-1]
   ```

---

#### 5. **문자열 편집 거리(Edit Distance)**
##### 문제 유형:
- 두 문자열을 변환하는 데 필요한 최소 편집 횟수를 계산.

##### 해결 방법:
1. **DP 테이블 정의**:
   - `dp[i][j]`: 문자열 A의 첫 i개와 B의 첫 j개의 최소 편집 거리.

2. **점화식**:
   - 문자 같을 때: `dp[i][j] = dp[i-1][j-1]`
   - 문자 다를 때: `dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])`

3. **구현**:
   ```python
   def edit_distance(word1, word2):
       m, n = len(word1), len(word2)
       dp = [[0] * (n + 1) for _ in range(m + 1)]
       for i in range(m + 1):
           for j in range(n + 1):
               if i == 0:
                   dp[i][j] = j
               elif j == 0:
                   dp[i][j] = i
               elif word1[i-1] == word2[j-1]:
                   dp[i][j] = dp[i-1][j-1]
               else:
                   dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
       return dp[m][n]
   ```

---

#### 6. **동전 거스름돈(Coin Change)**
##### 문제 유형:
- 주어진 동전을 사용해 특정 금액을 만드는 최소 개수 또는 방법의 수를 계산.

##### 해결 방법:
1. **최소 동전 개수**:
   - `dp[i]`: i 금액을 만드는 최소 동전 개수.
   - 점화식: `dp[i] = min(dp[i - coin] + 1)`

   ```python
   def coin_change(coins, amount):
       dp = [float('inf')] * (amount + 1)
       dp[0] = 0
       for coin in coins:
           for i in range(coin, amount + 1):
               dp[i] = min(dp[i], dp[i - coin] + 1)
       return dp[amount] if dp[amount] != float('inf') else -1
   ```

2. **방법의 수**:
   - `dp[i]`: i 금액을 만드는 방법의 수.
   - 점화식: `dp[i] += dp[i - coin]`

   ```python
   def coin_change_ways(coins, amount):
       dp = [0] * (amount + 1)
       dp[0] = 1
       for coin in coins:
           for i in range(coin, amount + 1):
               dp[i] += dp[i - coin]
       return dp[amount]
   ```

*Generated using ChatGPT by OpenAI*