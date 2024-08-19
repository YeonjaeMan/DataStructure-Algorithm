package DataStructure.SortingAndSearching.SelectionSort;

// Selection Sort는 배열을 돌면서 가장 작은 값을 찾아 시작점부터 정렬해나가는 알고리즘
// 시간 복잡도 : O(n^2)
public class Test {
    private static void selectionSort(int[] arr) {
        selectionSort(arr, 0); // 재귀 함수를 호출하는 데 정렬이 안된 시작 지점을 같이 넘겨줌
    }

    private static void selectionSort(int[] arr, int start) {
        if(start < arr.length - 1) {
            int min_index = start;
            for(int i = start; i < arr.length; i++) {
                if(arr[i] < arr[min_index]) {
                    min_index = i;
                }
            }
            swap(arr, start, min_index);
            selectionSort(arr, start + 1);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static void printArray(int[] arr) {
        for(int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
