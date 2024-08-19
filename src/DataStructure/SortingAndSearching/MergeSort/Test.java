package DataStructure.SortingAndSearching.MergeSort;

// Merge Sort는 각 배열이 2개일 때까지 배열을 절반씩 분할하고 다시 합치는 과정에서 정렬하는 알고리즘
// 시간 복잡도 : O(n log n)
// 공간 복잡도 : O(n)
public class Test {
    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length]; // 임시 저장 배열 생성
        mergeSort(arr, tmp, 0, arr.length - 1); // 재귀 호출 시작
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while(part1 <= mid && part2 <= end) {
            if(tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
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
        mergeSort(arr);
        printArray(arr);
    }
}
