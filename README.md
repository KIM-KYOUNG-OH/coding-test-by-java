# coding-test-by-java

# 알고리즘 유형
<details>
<summary> Queue </summary>
<div markdown="1">

```java
Queue<Task> q = new LinkedList<>();
q.add(new Task());  // add queue
Task task = q.poll();  // poll queue
```

</div>
</details>  

<details>
<summary> BFS </summary>
<div markdown="1">

```java
int n = 10;  // 행
int m = 10;  // 열
int[] dy = new int[]{-1, 0, 1, 0};
int[] dx = new int[]{0, 1, 0, -1};
int[][] graph = new int[n + 1][m + 1];  // 1은 통과O, 0은 통과X 
boolean[][] visit = new boolean[n + 1][m + 1];

Queue<int[]> q = new LinkedList<>();
q.add(new int[]{1, 1});  // 초기값
while (!q.isEmpty()) {
    int[] cur = q.poll();
    int y = cur[0];
    int x = cur[1];
    
    for (int k = 0; k < 4; k++) {
        int ny = y + dy[k];
        int nx = x + dx[k];
        if (0 < ny && ny <= n && 0 < nx && nx <= m) {
            if (!visit[ny][nx] && graph[ny][nx] >= 1) {
                visit[ny][nx] = true;
                graph[ny][nx] += graph[ny][nx];
                q.add(new int[]{ny, nx});
            }
        }
    }
}
```

</div>
</details>  

<details>
<summary> 에라토스테네스의 체 </summary>
<div markdown="1">

### 제곱근까지만 확인해도 되는 이유?
n = n^0.5 * n^0.5 = a*b 이므로 a ≥ n^0.5 이면 b ≤ n^0.5가 된다.  
결론적으로 제곱근 이상 수들은 이전의 합성수들로 이미 한번 지운 것들을 재방문 하는게 되기 때문에 제곱근 이상의 수는 순회할 필요가 없다.  
```java
int n = 10;  // 순회할 범위
boolean[] isPrime = new boolean[n + 1];
Arrays.fill(isPrime, true);
isPrime[1] = false;
for (int i = 2; i <= Math.sqrt(n); i++) {
    for (int j = i + i; j <= n; j += i) {
        isPrime[j] = false;
    }
}
```

</div>
</details>

<details>
<summary> 백트래킹 </summary>
<div markdown="1">

노드를 탐색하는 방법 중, 어떤 노드의 '유망성'을 판단한 뒤 해당 노드가 유망하지 않다면 부모 노드로 돌아가 다른 자식 노드를 찾는 방법이다.  
즉, 모든 경우의 수를 찾아보지만, 그 중에서도 가능성 있는 경우의 수만 찾아보는 방법이다.  
DFS는 백트래킹의 방법중 하나이다.

</div>
</details>

<details>
<summary> 이진탐색 </summary>
<div markdown="1">

데이터가 이미 정렬되어 있는 상태에서 원하는 값을 찾아내는 알고리즘
데이터 중앙값과 찾고자 하는 값을 비교해 데이터 크기를 절반씩 줄이면서 대상을 찾는 방식
시간복잡도 O(logN)

```java
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int left = 0;
int right = arr.length - 1;
int answer = 0;

int target = 2;

while (left <= right) {
    int mid = (left + right) / 2;
    if (arr[mid] == target) {
        answer = mid;
        break;
    } else if (target < arr[mid]) {
        right = mid - 1;    
    } else {
        left = mid + 1;    
    }
}
return answer;
```

</div>
</details>

<details>
<summary> Lower Bound </summary>
<div markdown="1">

배열 중복 허용될 때, 배열에서 x 이상의 값이 처음으로 나타나는 위치

```java
public static int lowerBound(int target) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;
        
        if (target <= arr[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return left;
}
```

</div>
</details>

<details>
<summary> Upper Bound </summary>
<div markdown="1">

배열 중복 허용될 때, 배열에서 x를 초과하는 값이 처음으로 나타나는 위치

```java
public static int upperBound(int target) {
    int[] arr = {1,3,3,3,4,4,6,8};
    int left = 0;
    int right = array.length;
    
    while (left < right) {
        int mid = (left + right) / 2;
        
        if (array[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    return right;
}
```

</div>
</details>

<details>
<summary> Upper Bound 변형 </summary>
<div markdown="1">

배열 중복 허용될 때, 배열에서 x이하를 만족하는 값들 중 가장 마지막 위치

```java
public static int upperBound2(int target) {
    int[] arr = {1,3,3,3,4,4,6,8};
    int left = 0;
    int right = arr.length - 1;
    
    while(left <= right) {
        int mid = (left+right) / 2;
        
        if(arr[mid] <= target){
            left=mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return right;
}
```

</div>
</details>

- 우선순위큐
- brute force
- greedy
- bfs/dfs
- dynamic programming
- 해시
- 정렬
- lower bound & upper bound
- 하노이 문제
- 에라토스테네스의 체
- knapsack
  - Fraction Knapsack Problem
  - 0/1 Knapsack Problem

# 알고리즘 Tip
- 데이터 범위를 보고 int, long 으로 선언할지 고민

# Java Tip

### 배열 디폴트값 변경
```java
boolean[] arr = new boolean[5];  // 기본값은 모두 false
Arrays.fill(arr, true);  // 모든 요소를 true로 변경
```

### 우선순위큐 정렬
```
//  내림차순 정렬
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

// Comparator를 이용한 객체 내부 성분 정렬
PriorityQueue<Person> pq = new PriorityQueue<>(
            Comparator.comparing(Person::getAge).reversed()
                      .thenComparing(Person::getName)
        );
```

<details>
<summary> 제목 </summary>
<div markdown="1">

내용

</div>
</details>

# 솔루션 보고 푼 문제
- 백준
  - P1931
  - P1912
  - P9663
  - P11729
  - P12865
  - P2805
  - P1002
  - P2805
