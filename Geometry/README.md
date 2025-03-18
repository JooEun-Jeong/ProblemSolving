기하학(Geometry) 관련 코딩 문제 유형은 여러 가지가 있으며, 기본 개념을 잘 이해하면 풀기 쉬워진다. 여기서는 **유형별 문제 예시와 해결 방법**을 소개할게.

---

## 📌 1. **기본적인 기하 연산**
### ✔ 유형:
- 두 점 사이의 거리 구하기
- 선분과 선분의 교차 여부 판단
- 내적(Dot Product), 외적(Cross Product) 계산

### 🛠 해결 방법:
- 유클리드 거리 공식:  
  \[
  d = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
  \]
- 외적을 이용한 **CCW(Counter Clockwise) 알고리즘**을 활용해 점들의 방향을 판단할 수 있음.

#### ✅ 예제: 두 점 사이의 거리
```java
public double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
}
```

#### ✅ 예제: CCW 알고리즘 (반시계 방향 확인)
```java
public int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
    int result = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    if (result > 0) return 1;  // 반시계 방향
    if (result < 0) return -1; // 시계 방향
    return 0;  // 일직선
}
```

---

## 📌 2. **다각형 문제**
### ✔ 유형:
- 다각형의 면적 구하기 (**신발끈 공식**)
- 다각형 내부 점 판별 (**홀짝 법칙 / 반직선 교차법**)
- 볼록 다각형(Convex Hull) 구하기 (**Andrew’s Algorithm, Graham’s scan**)

### 🛠 해결 방법:
#### ✅ 예제: 신발끈 공식을 이용한 다각형 면적 구하기
```java
public double polygonArea(int[] x, int[] y, int n) {
    double sum1 = 0, sum2 = 0;
    for (int i = 0; i < n; i++) {
        int next = (i + 1) % n;
        sum1 += x[i] * y[next];
        sum2 += y[i] * x[next];
    }
    return Math.abs(sum1 - sum2) / 2.0;
}
```

#### ✅ 예제: 점이 다각형 내부에 있는지 확인 (반직선 교차법)
```java
public boolean isInsidePolygon(int[] x, int[] y, int n, int px, int py) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        int next = (i + 1) % n;
        if ((y[i] > py) != (y[next] > py)) {
            double intersectX = (double)(x[next] - x[i]) * (py - y[i]) / (y[next] - y[i]) + x[i];
            if (px < intersectX) count++;
        }
    }
    return count % 2 == 1;
}
```

---

## 📌 3. **볼록 껍질(Convex Hull) 문제**
### ✔ 유형:
- 주어진 점들을 포함하는 최소 다각형 찾기 (**Convex Hull**)
- 볼록 다각형의 성질을 이용한 문제

### 🛠 해결 방법:
- **Graham's scan** 또는 **Andrew’s Algorithm**을 사용하여 Convex Hull을 구할 수 있음.
- CCW 판별을 활용하여 볼록 다각형의 점들을 선택함.

#### ✅ 예제: Convex Hull (Andrew’s Algorithm)
```java
import java.util.*;

public class ConvexHull {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
        public int compareTo(Point p) { return x == p.x ? y - p.y : x - p.x; }
    }

    public static int ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static List<Point> convexHull(Point[] points) {
        Arrays.sort(points);
        List<Point> hull = new ArrayList<>();

        for (int phase = 0; phase < 2; phase++) {
            int start = hull.size();
            for (Point p : points) {
                while (hull.size() >= start + 2 && ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0) {
                    hull.remove(hull.size() - 1);
                }
                hull.add(p);
            }
            hull.remove(hull.size() - 1);
            Collections.reverse(Arrays.asList(points));
        }

        return hull;
    }
}
```

---

## 📌 4. **원과 직선 문제**
### ✔ 유형:
- 두 원이 접하는지 확인
- 원과 선분의 교차 여부
- 삼각형 내접원/외접원 구하기

### 🛠 해결 방법:
- 두 원이 접하는지 확인하려면 중심 거리와 반지름을 비교
- 원과 직선의 거리는 **점과 직선 사이 거리 공식** 사용

#### ✅ 예제: 두 원이 접하는지 확인
```java
public boolean isCircleTouching(int x1, int y1, int r1, int x2, int y2, int r2) {
    double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    return dist == r1 + r2 || dist == Math.abs(r1 - r2);
}
```

---

## 📌 5. **삼각형 문제**
### ✔ 유형:
- 삼각형의 내심, 외심, 수심 구하기
- 삼각형이 존재하는지 확인
- 삼각형의 유형 판별 (직각삼각형, 둔각삼각형 등)

### 🛠 해결 방법:
- 세 변이 `a, b, c`일 때, 삼각형이 존재하려면 **삼각 부등식**이 성립해야 함:  
  \[
  a + b > c, \quad b + c > a, \quad c + a > b
  \]
- **피타고라스 정리**를 이용해 삼각형이 직각인지 판별 가능

#### ✅ 예제: 삼각형이 존재하는지 확인
```java
public boolean isTriangle(int a, int b, int c) {
    return (a + b > c) && (b + c > a) && (c + a > b);
}
```

#### ✅ 예제: 삼각형이 직각인지 판별
```java
public boolean isRightTriangle(int a, int b, int c) {
    int[] sides = {a, b, c};
    Arrays.sort(sides);
    return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
}
```

---

## 🚀 기하 문제를 푸는 팁
1. **기본 연산(거리, 내적, 외적, CCW)**을 확실히 익히자.
2. **부동소수점 오차를 고려**해 `double`이 아닌 **정수 연산을 사용할 수 있는지 확인**.
3. **신발끈 공식, CCW, Convex Hull 등 알고리즘을 숙지**하자.
4. **테스트 케이스를 다양하게 고려**하자 (특히 직선, 겹치는 점 등 경계 상황).
5. **반올림 관련 문제**는 `printf("%.1f")` 등 **출력 형식**을 잘 맞춰야 함.




### 📌 기하학 문제를 풀 때 필요한 **수학 공식 정리**

---

### ✅ 1. **기본 기하 연산**
#### 📌 두 점 사이의 거리 (Euclidean Distance)
\[
d = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
\]

#### 📌 내적 (Dot Product)
\[
\mathbf{A} \cdot \mathbf{B} = x_1 x_2 + y_1 y_2
\]
- **용도**: 두 벡터가 직교(90도)하는지 판별 (내적 = 0이면 직교)

#### 📌 외적 (Cross Product)
\[
\mathbf{A} \times \mathbf{B} = x_1 y_2 - y_1 x_2
\]
- **용도**: CCW 알고리즘(반시계 방향 판별), 삼각형 면적 계산

#### 📌 CCW (Counter Clockwise, 반시계 방향 판별)
\[
CCW = (x_2 - x_1) \cdot (y_3 - y_1) - (y_2 - y_1) \cdot (x_3 - x_1)
\]
- `CCW > 0` → 반시계 방향
- `CCW < 0` → 시계 방향
- `CCW = 0` → 일직선

---

### ✅ 2. **다각형 관련 공식**
#### 📌 신발끈 공식 (Shoelace Theorem, 다각형 면적)
\[
\text{Area} = \frac{1}{2} \left| \sum (x_i y_{i+1}) - \sum (y_i x_{i+1}) \right|
\]
- **순서**: `(x1, y1), (x2, y2), ..., (xn, yn)` 마지막 점 다음에 첫 점을 넣어야 함.

#### 📌 다각형 내부 판별 (홀짝 법칙, Ray Crossing Algorithm)
- 점 **(px, py)**가 다각형 내부에 있는지 확인하는 방법:
  - 다각형의 한쪽 방향으로 **반직선**을 긋고, 다각형의 선분과 교차하는 횟수를 셈.
  - 교차 횟수가 **홀수면 내부, 짝수면 외부**.

---

### ✅ 3. **삼각형 관련 공식**
#### 📌 삼각형 존재 여부 (삼각 부등식)
\[
a + b > c, \quad b + c > a, \quad c + a > b
\]
- 위 조건이 성립하면 삼각형을 만들 수 있음.

#### 📌 삼각형 넓이 공식 (헤론 공식)
\[
s = \frac{a + b + c}{2}
\]
\[
\text{Area} = \sqrt{s(s-a)(s-b)(s-c)}
\]
- **a, b, c**: 삼각형의 세 변

#### 📌 삼각형의 내심 (Incenter, 내접원의 중심)
\[
I_x = \frac{a x_A + b x_B + c x_C}{a + b + c}, \quad
I_y = \frac{a y_A + b y_B + c y_C}{a + b + c}
\]
- **(xA, yA), (xB, yB), (xC, yC)**: 삼각형의 세 점 좌표
- **a, b, c**: 각각의 변 길이

#### 📌 삼각형의 외심 (Circumcenter, 외접원의 중심)
\[
(x, y) = \left( \frac{(x_A^2 + y_A^2)(y_B - y_C) + (x_B^2 + y_B^2)(y_C - y_A) + (x_C^2 + y_C^2)(y_A - y_B)}{2 D}, \frac{(x_A^2 + y_A^2)(x_C - x_B) + (x_B^2 + y_B^2)(x_A - x_C) + (x_C^2 + y_C^2)(x_B - x_A)}{2 D} \right)
\]
\[
D = x_A(y_B - y_C) + x_B(y_C - y_A) + x_C(y_A - y_B)
\]

---

### ✅ 4. **원과 관련된 공식**
#### 📌 두 원이 접하는지 판별
\[
\text{distance} = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
\]
- 접할 조건:
  - **외접**: `distance = r1 + r2`
  - **내접**: `distance = |r1 - r2|`
  - **겹침**: `distance < r1 + r2`
  - **떨어짐**: `distance > r1 + r2`

#### 📌 점과 직선 사이 거리
직선의 방정식이 **Ax + By + C = 0**일 때, 점 (px, py)에서 직선까지의 거리:
\[
d = \frac{|A p_x + B p_y + C|}{\sqrt{A^2 + B^2}}
\]

---

### ✅ 5. **Convex Hull (볼록 껍질)**
#### 📌 Graham's scan을 이용한 정렬 기준
- 기준점 **P**를 잡고, 각 점을 **반시계 방향으로 정렬**하기 위해 **각도를 정렬**해야 함.
- 두 점 **A, B**에 대해 기준점 **P**를 기준으로 정렬하는 방법:
\[
\theta = \tan^{-1} \left(\frac{y_B - y_A}{x_B - x_A}\right)
\]

---

### ✅ 6. **벡터와 회전**
#### 📌 벡터 회전 (2D 회전 변환)
- 점 (x, y)를 원점 중심으로 **θ만큼 회전**시킨 새로운 좌표 (x', y'):
\[
x' = x \cos\theta - y \sin\theta
\]
\[
y' = x \sin\theta + y \cos\theta
\]

---

### ✅ 7. **직선과 선분 교차 여부**
#### 📌 두 선분 (A, B)와 (C, D)가 교차하는지 판별
- CCW를 활용하여 두 선분이 교차하는지 판별:
\[
CCW(A, B, C) \times CCW(A, B, D) < 0
\]
\[
CCW(C, D, A) \times CCW(C, D, B) < 0
\]
- 위 두 조건을 만족하면 선분이 교차함.

---

## 🔥 정리
| 유형 | 공식 |
|---|---|
| 두 점 사이 거리 | \( \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2} \) |
| 내적 | \( x_1 x_2 + y_1 y_2 \) |
| 외적 | \( x_1 y_2 - y_1 x_2 \) |
| CCW | \( (x_2 - x_1)(y_3 - y_1) - (y_2 - y_1)(x_3 - x_1) \) |
| 삼각 부등식 | \( a + b > c, \quad b + c > a, \quad c + a > b \) |
| 벡터 회전 | \( x' = x \cos\theta - y \sin\theta, \quad y' = x \sin\theta + y \cos\theta \) |

*Generated By ChatGPT*