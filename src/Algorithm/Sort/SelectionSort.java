package Algorithm.Sort;

import java.util.Arrays;

// 선택 정렬
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {0, 9, 2, 5, 6, 8, 1, 7, 3, 4};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }
}
