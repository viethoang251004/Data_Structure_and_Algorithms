public class HeapSort {
    public static void heapSort(int[] arr, boolean ascending) {
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        if (ascending) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = maxHeap.extractMax();
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i] = maxHeap.extractMax();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39 };
        System.out.println("Original Array:");
        printArray(arr);
        System.out.println("Ascending Order:");
        heapSort(arr, true);
        printArray(arr);
        System.out.println("Descending Order:");
        heapSort(arr, false);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}