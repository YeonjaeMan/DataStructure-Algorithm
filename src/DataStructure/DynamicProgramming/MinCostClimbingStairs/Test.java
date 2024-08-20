package DataStructure.DynamicProgramming.MinCostClimbingStairs;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(minCostClimbingStairs(arr));
    }

    private static int minCost(int[] arr) {
        int oneStep = arr[arr.length - 2];
        int twoStep = arr[arr.length - 1];
        int cost = 0;
        return minCost(arr, oneStep, twoStep, arr.length - 3, cost);
    }

    private static int minCost(int[] arr, int oneStep, int twoStep, int index, int cost) {
        if(index < 0)
            return Math.min(oneStep, twoStep);
        cost = Math.min(oneStep, twoStep) + arr[index];
        index--;
        twoStep = oneStep;
        oneStep = cost;
        int current = minCost(arr, oneStep, twoStep, index, 0);
        return current;
    }

    private static int minCostClimbingStairs(int[] cost) {
        int case1 = 0, case2 = 0, current;
        for(int i = cost.length - 1; i >= 0; i--) {
            current = cost[i] + Math.min(case1, case2);
            case2 = case1;
            case1 = current;
        }
        return Math.min(case1, case2);
    }
}
