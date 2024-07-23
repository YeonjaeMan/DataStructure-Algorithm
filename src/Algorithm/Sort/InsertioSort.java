package Algorithm.Sort;

import java.util.Arrays;

// 삽입 정렬
public class InsertioSort {
    public static void main(String[] args) {
        int[] arr = {0, 9, 2, 5, 6, 8, 1, 7, 3, 4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
