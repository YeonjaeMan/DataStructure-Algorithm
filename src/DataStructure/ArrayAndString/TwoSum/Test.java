package DataStructure.ArrayAndString.TwoSum;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int[] nums = {6, 4, 3, 8, 7, 5, 2};
        int[] result1 = twoSum1(nums, 5);
        int[] result2 = twoSum2(nums, 5);
        int[] result3 = twoSum3(nums, 5);
        System.out.println(result1[0] + ", " + result1[1]);
        System.out.println(result2[0] + ", " + result2[1]);
        System.out.println(result3[0] + ", " + result3[1]);
    }

    private static int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i1 = 0; i1 < nums.length; i1++) {
            Integer i2 = map.get(target - nums[i1]);
            if(i2 != null && i1 != i2) {
                return new int[]{i1, i2};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
