# 빅오표기법 문제풀이

## Question #1
- Q : time complexity ?
`
int div(int a, int b) {
    int count = 0;
    int sum = b;
    while(sum <= a) {
        sum += b;
        count++;
    }
    return count;
}
`
- A : O(a/b)

## Question #2 : time complexity?
- Q : time complexity ?
`
int sqrt(int n) {
    for(int g = 1; g * g <= n; g++) {
        if(g * g == n) return g;
    }
    return -1;
}
`
- A : O(Sqrt(n))

## Question #3
- Q : if a binary search tree is not balanced, how long might it take (worst case) to find an element in it ?
- (만약 이진검색트리의 균형이 맞지 않는다면, 최악의 경우 시간복잡도는?)
- A : O(n)

## Question #4
- Q : you are looking for specific value in a binary tree, but the tree is not a binary search tree. what is the time complexity of this ?
- (트리 안에서 어떤 특정 값을 찾을 때 트리가 이진검색트리가 아니다. 이경우 시간 복잡도는?)
- A : O(n)

## Question #5
- Q : time complexity ?
`
int[] appendToNew(int[] array, int value) {
    int[] bigger = new int[array.length + 1]; // 인자로 받은 배열의 길이 + 1 만큼의 배열 생성
    for(int i = 0; i < array.length; i++) {
        bigger[i] = array[i]; // 새로운 배열에 기존의 배열 복사
    }
    bigger[bigger.length - 1] = value; // 새로운 배열 마지막 방에 인자로 받은 값 추가
    return bigger;
}

int[] copyArray(int[] array) {
    int[] copy new int[0];
    for(int value : array) {
        copy = appendToNew(copy, value);
    }
    return copy;
}
`
- A : O(n²)

## Question #6
- Q : time complexity ?
`
int sumDigits(int n) {
    int sum = 0;
    while(n > 0) {
        sum += n % 10;
        n /= 10;
    }
}
`
- A : O(log n)

## Question #7
- Q : time complexity ?
`
int intersection(int[] a, int[] b) {
    mergesort(b); // O(b log b)
    int intersect = 0;
    for(int x : a) { // O(a)
        if(binarySearch(b, x) >= 0) { // O(log b)
        intersect++;
        }
    }
    return intersect;
}
`
- A : O(a log b + b log b)