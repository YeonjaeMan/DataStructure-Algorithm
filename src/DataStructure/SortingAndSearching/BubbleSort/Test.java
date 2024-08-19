package DataStructure.SortingAndSearching.BubbleSort;

// Bubble Sort는 양 옆의 두수를 비교해서 정렬해 나가는 알고리즘
// 가장 큰 값이 맨 뒤부터 정렬된다.
// 시간 복잡도 : O(n^2)
public class Test {
    private static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length - 1); // 재귀 호출로 배열의 마지막 인덱스를 넘겨줌.
    }

    private static void bubbleSort(int[] arr, int last) {
        if(last > 0) {
            for(int i = 1; i <= last; i++) {
                if(arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                }
            }
            bubbleSort(arr, last - 1);
        }
    }

    private static void swap(int[] arr, int source, int target) {
        int tmp = arr[source];
        arr[source] = arr[target];
        arr[target] = tmp;
    }

    private static void printArray(int[] arr) {
        for(int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 1};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
