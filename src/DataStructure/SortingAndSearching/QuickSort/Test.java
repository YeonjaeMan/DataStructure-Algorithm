package DataStructure.SortingAndSearching.QuickSort;

// Quick Sort는 임의로 배열의 값을 정하고 이를 기준으로 왼쪽에는 작은 값 오른쪽에는 큰 값이 오도록 하는 과정을 반복하는 알고리즘
// 시간 복잡도 : O(n log n)
public class Test {
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if(start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }
        if(part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while(start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr) {
        for(int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
