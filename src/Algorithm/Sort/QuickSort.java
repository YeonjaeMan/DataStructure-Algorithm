package Algorithm.Sort;

import java.util.Arrays;

// 퀵 정렬 (https://st-lab.tistory.com/250)
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {0, 9, 2, 5, 6, 8, 1, 7, 3, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while(left < right) {
            while(arr[left] < pivot)
                left++;
            while(arr[right] > pivot)
                right--;
            if(arr[left] > arr[right]) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
