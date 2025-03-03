> 이분 탐색은 기본적인 정렬된 배열 탐색부터, **최적화 문제**나 **결정 문제**까지 다양하게 활용됨.  

---

### 🔹 **1. 기본 이분 탐색 (Binary Search)**
#### ✔ 유형: **정렬된 배열에서 특정 값을 찾기**
- 가장 기본적인 형태로, `O(log n)` 시간 복잡도를 가진다.
- `Collections.binarySearch()` 또는 `Arrays.binarySearch()`를 활용 가능.

 ✔ **자주 사용되는 자료 구조**  
✅ `Array` (배열)  
✅ `ArrayList` (동적 배열)  
✅ `Collections.binarySearch()`  
✅ `Arrays.binarySearch()`

📌 **이유**  
- 정렬된 상태에서 빠르게 **탐색**할 수 있는 자료 구조가 필요.  
- Java에서는 `Collections.binarySearch()`와 `Arrays.binarySearch()`가 기본적으로 제공됨.  

📌 **예제 코드**
```java
int[] arr = {1, 3, 5, 7, 9};
int index = Arrays.binarySearch(arr, 5); // 2
```

#### 🔹 **예제 문제**
1. **정렬된 배열에서 특정 값 찾기**
   - 📌 예제: `A = [1, 3, 5, 7, 9]`에서 `5`를 찾기 → `index 2`
2. **첫 번째 등장 위치 / 마지막 등장 위치 찾기**
   - 📌 `lower_bound` & `upper_bound` 개념 필요 (`Collections.binarySearch()` 활용)
3. **숫자의 존재 여부 확인 (`set`보다 빠른 `O(log n)`)**

#### 🔹 **백준 문제 추천**
- [1920번 - 수 찾기](https://www.acmicpc.net/problem/1920)  
- [10816번 - 숫자 카드 2](https://www.acmicpc.net/problem/10816)  

---

### 🔹 **2. LIS (최장 증가 부분 수열, O(n log n) 방식)**
#### ✔ 유형: **이분 탐색을 이용한 LIS 최적화**
- DP를 이용한 LIS(`O(n^2)`) 대신, **이분 탐색을 활용하면 `O(n log n)`**에 해결 가능.
- `Collections.binarySearch()`를 활용하여 적절한 위치를 찾아 값 대체.

✔ **자주 사용되는 자료 구조**  
✅ `ArrayList` (동적 배열)  
✅ `TreeSet` (중복 없는 정렬된 집합)  
✅ `Collections.binarySearch()`  

📌 **이유**  
- LIS를 빠르게 갱신해야 하므로 **동적 배열**이 필요.  
- `TreeSet`을 사용하면 LIS 길이를 유지하면서도 탐색을 쉽게 할 수 있음.  
- `Collections.binarySearch()`를 이용해 **값을 대체할 위치를 찾기 위해 사용**.

📌 **예제 코드 (ArrayList + binarySearch)**
```java
List<Integer> lis = new ArrayList<>();
for (int num : arr) {
    int idx = Collections.binarySearch(lis, num);
    if (idx < 0) idx = -idx - 1; // 삽입 위치 찾기
    if (idx >= lis.size()) lis.add(num);
    else lis.set(idx, num);
}
```

#### 🔹 **예제 문제**
1. **가장 긴 증가하는 부분 수열 (LIS)**
2. **배열의 부분 증가 수열 찾기 (Strictly Increasing)**

#### 🔹 **백준 문제 추천**
- [12738번 - 가장 긴 증가하는 부분 수열 3](https://www.acmicpc.net/problem/12738)
- [14003번 - 가장 긴 증가하는 부분 수열 5](https://www.acmicpc.net/problem/14003)

---

### 🔹 **3. 매개 변수 탐색 (Parametric Search)**
#### ✔ 유형: **최댓값 / 최솟값을 이분 탐색으로 찾기**
- 답을 특정 범위에서 **"YES/NO"로 결정할 수 있는 문제**에서 사용됨.
- **"이 값이 가능한가?"** 를 이분 탐색으로 탐색.

✔ **자주 사용되는 자료 구조**  
✅ `Array` (배열)  
✅ `PriorityQueue` (우선순위 큐)  
✅ `TreeSet` (정렬된 값 관리)  

📌 **이유**  
- **범위를 이분 탐색으로 좁혀가면서 최적해를 찾는 문제**.  
- 주로 **배열**이 기본이지만, 일부 문제에서는 **최댓값/최솟값을 빠르게 갱신**해야 하므로 `PriorityQueue` 또는 `TreeSet`을 활용.  

📌 **예제 코드 (랜선 자르기 - Parametric Search)**
```java
long left = 1, right = maxCableLength;
while (left <= right) {
    long mid = (left + right) / 2;
    if (canMakeLanCables(mid)) left = mid + 1;
    else right = mid - 1;
}
```

#### 🔹 **예제 문제**
1. **최대 길이 막대 자르기**
   - 📌 `N`개의 나무를 `M`만큼 잘라야 한다면, **최대 나무 길이를 찾는 문제**
2. **배달 가능한 최대 무게**
   - 📌 `K`개의 트럭이 운반할 수 있는 **최대 무게**를 찾는 문제
3. **K번째 수 찾기 (Lower Bound / Upper Bound 활용)**

#### 🔹 **백준 문제 추천**
- [1654번 - 랜선 자르기](https://www.acmicpc.net/problem/1654)  
- [2805번 - 나무 자르기](https://www.acmicpc.net/problem/2805)  
- [2110번 - 공유기 설치](https://www.acmicpc.net/problem/2110)  
- [1300번 - K번째 수](https://www.acmicpc.net/problem/1300)  

---

### 🔹 **4. 삼분 탐색 (Ternary Search)**
#### ✔ 유형: **최적화 문제에서 최댓값/최솟값 찾기**
- 이분 탐색은 `YES/NO`를 결정하는 문제에 적합하지만,  
  **함수의 최댓값/최솟값을 찾을 때는 삼분 탐색**을 활용할 수 있음.

✔ **자주 사용되는 자료 구조**  
✅ `Array` (배열)  
✅ `TreeMap` (정렬된 Key-Value 쌍 저장)  

📌 **이유**  
- **함수의 최댓값/최솟값을 찾을 때 사용**.  
- `TreeMap`은 특정 구간에서 최댓값/최솟값을 **빠르게 갱신**하는 데 유용.

📌 **예제 코드 (삼분 탐색)**
```java
while (high - low > 1e-6) {
    double mid1 = (low * 2 + high) / 3;
    double mid2 = (low + high * 2) / 3;
    if (f(mid1) < f(mid2)) low = mid1;
    else high = mid2;
}
```

#### 🔹 **예제 문제**
1. **볼록한 함수의 최댓값 찾기**
2. **최소 비용 경로에서 최적 지점 찾기**

#### 🔹 **백준 문제 추천**
- [13397번 - 구간 나누기 2](https://www.acmicpc.net/problem/13397)  
- [2261번 - 가장 가까운 두 점](https://www.acmicpc.net/problem/2261)  

---

### 🔹 **5. 두 포인터 + 이분 탐색**
#### ✔ 유형: **배열의 합 문제 최적화**
- 정렬된 배열을 **두 개의 포인터**를 활용하여, 특정 합을 빠르게 찾는 유형.
- 필요하면 **이분 탐색과 결합하여 `O(n log n)`로 최적화**.

✔ **자주 사용되는 자료 구조**  
✅ `Array` (배열)  
✅ `TreeSet` (정렬된 값 관리)  
✅ `HashMap` (빠른 검색)  

📌 **이유**  
- 두 포인터 기법과 함께 이분 탐색을 활용해 **특정 값의 합이나 차이를 빠르게 찾음**.  
- `TreeSet`을 사용하면 정렬된 상태에서 빠르게 탐색할 수 있음.  

📌 **예제 코드 (두 용액 문제)**
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == 0) break;
    if (sum < 0) left++;
    else right--;
}
```

#### 🔹 **예제 문제**
1. **합이 `M`인 두 수 찾기**
2. **배열의 두 수의 차이가 특정 범위를 만족하는 개수 세기**
3. **두 개의 정렬된 배열을 합쳐 특정 조건을 만족하는 값 찾기**

#### 🔹 **백준 문제 추천**
- [2470번 - 두 용액](https://www.acmicpc.net/problem/2470)  
- [3151번 - 합이 0](https://www.acmicpc.net/problem/3151)  

---

### 🔹 **6. 이분 탐색을 활용한 그래프 문제**
#### ✔ 유형: **다익스트라/벨만포드 + 이분 탐색**
- 그래프 문제에서도 **최적의 경로를 찾을 때 이분 탐색이 활용**됨.
- 특정 가중치를 기준으로 최단경로를 찾거나, 경로 제한을 둘 때 사용.

✔ **자주 사용되는 자료 구조**  
✅ `PriorityQueue` (다익스트라 활용)  
✅ `TreeSet` (가중치 기준 정렬)  
✅ `HashMap` (빠른 경로 탐색)  

📌 **이유**  
- 이분 탐색을 활용해 **최대 중량 제한이 있는 경로를 찾는 문제**에서 유용.  
- `PriorityQueue`를 사용하면 **다익스트라와 결합하여 최적화** 가능.  

📌 **예제 코드 (중량 제한 이분 탐색 + BFS)**
```java
while (low <= high) {
    int mid = (low + high) / 2;
    if (canCrossWithWeight(mid)) low = mid + 1;
    else high = mid - 1;
}
```

#### 🔹 **예제 문제**
1. **최대 중량 제한이 있는 다익스트라 문제**
2. **최소 비용 경로를 찾는 플로이드-워셜 문제**

#### 🔹 **백준 문제 추천**
- [1939번 - 중량제한](https://www.acmicpc.net/problem/1939)  
- [4485번 - 녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485)  

---

### **🔹 7. 기타 응용 문제**
#### ✔ 유형: **배열, 수학, 문자열 문제에서 이분 탐색 응용**
1. **정렬된 배열에서 중복된 값 개수 세기**
   - 📌 `lower_bound()`, `upper_bound()` 활용
2. **회전 정렬된 배열에서 특정 값 찾기**
3. **정렬된 배열에서 제곱근 또는 n번째 루트 값 찾기 (O(log n))**

#### 🔹 **백준 문제 추천**
- [10815번 - 숫자 카드](https://www.acmicpc.net/problem/10815)  
- [2343번 - 기타 레슨](https://www.acmicpc.net/problem/2343)  

---

## **📌 정리**
| 유형 | 주요 자료 구조 | 사용 이유 |
|------|--------------|----------|
| **기본 이분 탐색** | `Array`, `ArrayList`, `Collections.binarySearch()` | 정렬된 배열에서 빠른 검색 |
| **LIS (O(n log n))** | `ArrayList`, `TreeSet`, `Collections.binarySearch()` | LIS 길이 유지, 값 대체 최적화 |
| **매개 변수 탐색** | `Array`, `PriorityQueue`, `TreeSet` | 범위를 좁혀가며 최적값 찾기 |
| **삼분 탐색** | `Array`, `TreeMap` | 최댓값/최솟값 찾기 |
| **두 포인터 + 이분 탐색** | `Array`, `TreeSet`, `HashMap` | 정렬된 데이터에서 빠른 탐색 |
| **그래프 + 이분 탐색** | `PriorityQueue`, `TreeSet`, `HashMap` | 최적화된 경로 찾기 |


| 유형 | 대표 문제 |
|------|----------|
| 🔹 기본 이분 탐색 | [1920번 수 찾기](https://www.acmicpc.net/problem/1920) |
| 🔹 LIS (O(n log n)) | [12738번 가장 긴 증가하는 부분 수열 3](https://www.acmicpc.net/problem/12738) |
| 🔹 매개 변수 탐색 | [1654번 랜선 자르기](https://www.acmicpc.net/problem/1654) |
| 🔹 삼분 탐색 | [13397번 구간 나누기 2](https://www.acmicpc.net/problem/13397) |
| 🔹 두 포인터 + 이분 탐색 | [2470번 두 용액](https://www.acmicpc.net/problem/2470) |
| 🔹 그래프 응용 | [1939번 중량제한](https://www.acmicpc.net/problem/1939) |


*Generated By GPT*