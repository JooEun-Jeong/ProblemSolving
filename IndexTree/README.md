> Segment Tree, Fenwick Tree, Lazy Propagation Tree

---

#### **1. 구간 최소/최대/합/곱/최대공약수(GCD) 쿼리**

**📌 유형 설명:**

- 주어진 배열에서 특정 범위 `[L, R]`에 대한 최소값, 최대값, 합, 곱, GCD 등을 빠르게 구하는 문제
- 일반적인 `O(N)` 반복문 탐색 대신, **세그먼트 트리를 사용해 `O(log N)` 시간**에 해결 가능

**✅ 해결 방법:**

1. **세그먼트 트리 초기화 (`build`)**
   - 배열을 기반으로 세그먼트 트리를 구축 (`O(N)`)
2. **구간 쿼리 처리 (`query`)**
   - `[L, R]` 범위 내 값을 구하기 위해 `O(log N)` 시간에 탐색
3. **점 업데이트 (`update`)**
   - 특정 인덱스의 값을 변경한 후, 해당 경로의 노드 값들을 갱신 (`O(log N)`)

**💡 예제:**

- [백준 10868](https://www.acmicpc.net/problem/10868) (최소값 찾기)
- [백준 2042](https://www.acmicpc.net/problem/2042) (구간 합 구하기)

---

#### **2. 구간 업데이트와 구간 쿼리 (Lazy Propagation)**

**📌 유형 설명:**

- 배열의 특정 범위 `[L, R]`의 모든 값에 +X를 더하거나, 특정 값으로 변경하는 등의 **구간 업데이트**가 포함된 문제
- 일반적인 세그먼트 트리의 `update()`를 사용하면 `O(N log N)`이 걸려 비효율적
- **Lazy Propagation 기법을 사용하면 `O(log N)`에 해결 가능**

**✅ 해결 방법:**

1. **Lazy 배열을 추가로 사용**
   - 업데이트가 필요한 범위를 바로 반영하지 않고, Lazy 배열에 저장하여 나중에 한 번에 반영
2. **구간 업데이트 (`update_range`)**
   - Lazy 값을 저장해두고 필요할 때 적용하여 시간 단축
3. **구간 쿼리 (`query_range`)**
   - Lazy 값을 확인하여 필요할 때 트리를 갱신한 후 결과 반환

**💡 예제:**

- [백준 10999](https://www.acmicpc.net/problem/10999) (구간 합과 구간 업데이트)

---

#### **3. 인덱스 트리(Fenwick Tree)와 비교 문제**

**📌 유형 설명:**

- 펜윅 트리(Fenwick Tree, BIT)와 세그먼트 트리를 비교하는 문제
- 주어진 문제에서 두 방법 중 어떤 것이 더 적합한지 분석해야 함

**✅ 해결 방법:**

- **단순한 구간 합 문제:** `펜윅 트리(BIT)`가 더 빠르고 메모리도 적게 차지 (`O(log N)`)
- **최대/최소/GCD/곱 같은 복잡한 연산:** `세그먼트 트리`가 필요

**💡 예제:**

- [백준 11658](https://www.acmicpc.net/problem/11658) (구간 업데이트와 구간 쿼리 비교 문제)

---

#### **4. 이분 탐색을 활용한 세그먼트 트리 문제**

**📌 유형 설명:**

- 세그먼트 트리 내에서 특정 조건을 만족하는 값을 **빠르게 탐색하는 문제**
- 주어진 구간 `[L, R]`에서 **X 이상인 가장 작은 값**을 찾거나, **X보다 큰 값이 처음 등장하는 위치** 등을 찾는 유형

**✅ 해결 방법:**

1. **이분 탐색 (`binary search`)과 세그먼트 트리 조합**
   - `query()` 함수에서 값을 비교하며 이분 탐색 수행
2. **세그먼트 트리를 활용한 최적화**
   - 단순한 `O(N log N)` 풀이 대신, `O(log^2 N)`로 해결 가능

**💡 예제:**

- [백준 13537](https://www.acmicpc.net/problem/13537) (세그먼트 트리를 활용한 lower_bound 탐색)

---

#### **5. 좌표 압축과 세그먼트 트리**

**📌 유형 설명:**

- 배열 크기가 너무 커서 **직접 세그먼트 트리를 만들기 어려운 경우** 등장
- `좌표 압축`을 통해 인덱스를 줄이고, 세그먼트 트리 크기를 최적화해야 함

**✅ 해결 방법:**

1. **좌표 압축 (Coordinate Compression)**
   - 값의 범위가 클 때, **유니크한 값만 추려 작은 범위의 인덱스로 변환**
2. **세그먼트 트리 구성**
   - 압축된 인덱스로 세그먼트 트리를 관리

**💡 예제:**

- [백준 3653](https://www.acmicpc.net/problem/3653) (좌표 압축을 활용한 세그먼트 트리)

---

#### **📌 정리**

| 문제 유형                  | 설명                                                 | 해결 방법                                  |
| -------------------------- | ---------------------------------------------------- | ------------------------------------------ |
| 구간 최소/최대/합/GCD 쿼리 | 특정 범위 `[L, R]`에서 최소/최대/합 등을 구하는 문제 | 세그먼트 트리 기본 구조 활용               |
| 구간 업데이트 + 구간 쿼리  | 특정 범위 `[L, R]`에 값을 변경하고, 빠르게 쿼리 수행 | Lazy Propagation 기법 활용                 |
| 세그먼트 트리 vs 펜윅 트리 | 어느 자료구조가 더 적합한지 분석하는 문제            | 구간 합은 BIT, 복잡한 연산은 세그먼트 트리 |
| 이분 탐색 + 세그먼트 트리  | 조건을 만족하는 값을 빠르게 찾는 문제                | query() 내에서 이분 탐색 수행              |
| 좌표 압축 + 세그먼트 트리  | 배열 범위가 너무 클 때                               | 좌표 압축 후, 세그먼트 트리 구성           |

---

#### **🎯 세그먼트 트리 문제 풀이 팁**

1. **기본 개념부터 익히기**

   - 처음에는 단순한 **구간 최소/최대/합** 문제부터 연습
   - `build()`, `query()`, `update()` 구현을 확실히 익히기

2. **Lazy Propagation 문제 도전하기**

   - 구간 업데이트가 포함된 문제를 풀어보면서 `lazy[]` 배열 활용법 익히기

3. **이분 탐색과 결합된 문제 연습**

   - 특정 값 이상/이하의 인덱스를 찾는 문제에 도전

4. **좌표 압축과 결합된 문제 풀어보기**
   - 입력값의 범위가 클 때 어떻게 압축하는지 연습

_Generated by ChatGPT_
