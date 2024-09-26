package CodingTest.DP;

// 프로그래머스 고득점 알고리즘 Kit 동적계획법(Dynamic Programming) Level 4 문제
/*
1. 인덱스 두개를 이용해서 괄호를 정하고 계산 값의 최댓값을 구한다.
ex) 1 - 3 + 5 - 8
[0][0] = 1, [1][1] = 3, [2][2] = 5, [3][3] = 8
[0][1] = 1 - 3 = -2, [1][2] = 3 + 5 = 8, [2][3] = 5 - 8
[0][2] = [0][0] - [1][2] or [0][1] + [2][2] = 1 - 8 or -2 + 5 = -7 or 3 ..
2. 최댓값을 구하기 위해서 부호가 +이면 그냥 더하면 되지만, -이면 큰수에서 작은수를 빼야 최댓값이 나온다.
3. 2번을 위해서 max_dp, min_dp 두 개를 두는 것이다.
* 원리는 이해했지만, 코드 구현을 못했다 복습 필요! *
 */
public class 사칙연산 {
    public int[][] max;
    public int[][] min;

    public int solution(String arr[]) {
        int size = arr.length / 2 + 1;
        max = new int[size][size];
        min = new int[size][size];

        int[] list = new int[size];

        for(int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if(i == 0) {
                list[i / 2] = num;
            } else {
                list[i / 2] = arr[i - 1].equals("+") ? num : -num;
            }
        }

        for(int i = size - 1; i >= 0; i--) {
            for(int j = i; j < size; j++) {
                if(i == j) {
                    min[i][j] = list[i];
                    max[i][j] = list[i];
                } else {
                    min[i][j] = Integer.MAX_VALUE;
                    max[i][j] = Integer.MIN_VALUE;

                    for(int k = i; k < j; k++) {
                        boolean value = k == i ? true : false;
                        calculate(min[i][k], min[k + 1][j], i, j, value);
                        calculate(min[i][k], max[k + 1][j], i, j, value);
                        calculate(max[i][k], min[k + 1][j], i, j, value);
                        calculate(max[i][k], max[k + 1][j], i, j, value);
                    }
                }
            }
        }

        return max[0][size - 1];
    }

    public void calculate(int a, int b, int x, int y, boolean value) {
        if(value && a < 0) {
            min[x][y] = Math.min(min[x][y], Math.min(a - b, a + b));
            max[x][y] = Math.max(max[x][y], Math.max(a - b, a + b));
        } else {
            min[x][y] = Math.min(min[x][y], a + b);
            max[x][y] = Math.max(max[x][y], a + b);
        }
    }
}
