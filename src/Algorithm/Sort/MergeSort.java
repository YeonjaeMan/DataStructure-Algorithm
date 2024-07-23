package Algorithm.Sort;

import java.util.Arrays;

// 병합 정렬
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {0, 9, 2, 5, 6, 8, 1, 7, 3, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmpArr = new int[arr.length];
        int l = left;
        int r = mid + 1;
        int idx = left;
        while(l <= mid && r <= right) {
            if(arr[l] < arr[r]) {
                tmpArr[idx] = arr[l];
                idx++;
                l++;
            } else {
                tmpArr[idx] = arr[r];
                idx++;
                r++;
            }
        }
        while(l <= mid) {
            tmpArr[idx] = arr[l];
            idx++;
            l++;
        }
        while(r <= right) {
            tmpArr[idx] = arr[r];
            idx++;
            r++;
        }
        for(int i = left; i <= right; i++) {
            arr[i] = tmpArr[i];
        }
    }
}
