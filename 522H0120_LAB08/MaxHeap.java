// import java.util.NoSuchElementException;

// public class MaxHeap {
//     int[] heap;
//     int heapSize;
//     int maxSize; // maximum size to initialize an heap array

//     public MaxHeap(int capity) {
//         heapSize = 0;
//         this.maxSize = capity + 1;
//         heap = new int[maxSize];
//         heap[0] = -1;
//     }

//     private int parent(int i) {
//         return i / 2;
//     }

//     private int left(int i) {
//         // thinking and filling
//         return 2*i;
//     }

//     private int right(int i) {
//         // thinking and filling
//         return 2*i+1;
//     }

//     private void swap(int i, int j) {
//         int temp = heap[i];
//         heap[i] = heap[j];
//         heap[j] = temp;
//     }

//     public void insert(int key) {
//         if (heapSize == maxSize) {
//             throw new NoSuchElementException("Overflow Exception"); // Remember to import
//                                                                     // java.util.NoSuchElementException;
//         }
//         heapSize += 1;
//         heap[heapSize] = key;

//         shiftUp(heapSize);
//     }

//     private void shiftUp(int i) {
//         while (i > 1 && heap[parent(i)] < heap[i]) {
//             swap(parent(i), i); // this method you have defined before
//             i = parent(i);
//         }
//     }

//     public int extractMax() {
//         if (heapSize == 0) {
//             throw new NoSuchElementException("Underflow Exception");
//         }
//         int max = heap[1];
//         heap[1] = heap[heapSize];
//         heapSize -= 1;
//         shiftDown(1);
//         return max;
//     }

//     private void shiftDown(int i) {
//         while (i <= heapSize) {
//             int max = heap[i];
//             int max_id = i;
//             if (left(i) <= heapSize && max < heap[left(i)]) {
//                 max = heap[left(i)];
//                 max_id = left(i);
//             }
//             if (right(i) <= heapSize && max < heap[right(i)]) {
//                 max = heap[right(i)];
//                 max_id = right(i);
//             }
//             if (max_id != i) {
//                 swap(max_id, i);
//                 i = max_id;
//             } else {
//                 break;
//             }
//         }
//     }

//     public static void heapSort(int[] arr) {
//         // code here
//         MaxHeap maxHeap = new MaxHeap(arr.length);
//         for (int i = 0; i < arr.length; i++) {
//             maxHeap.insert(arr[i]);
//         }
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = maxHeap.extractMax();
//         }
//     }
//     // This function can be implemented in the class that contains themain function.
// }

import java.util.NoSuchElementException;

class MaxHeap {
    int[] heap;
    int heapSize;
    int maxSize; // maximum size to initialize an heap array

    public MaxHeap(int capity) {
        heapSize = 0;
        this.maxSize = capity + 1;
        heap = new int[maxSize];
        heap[0] = -1; // ko su dung phan tu heap[0]
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int key) {
        if (heapSize == maxSize) {
            throw new NoSuchElementException("Overflow Exception"); // Remember to import
                                                                    // java.util.NoSuchElementException;
        }
        heapSize += 1;
        heap[heapSize] = key;
        shiftUp(heapSize);
    }

    private void shiftUp(int i) {
        while (i > 1 && heap[parent(i)] < heap[i]) {
            swap(parent(i), i); // this method you have defined before
            i = parent(i);
        }
    }

    // bo sung
    public void print() {
        for (int i = 1; i <= heapSize; ++i)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public int extractMax() {
        if (heapSize == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        int max = heap[1];
        heap[1] = heap[heapSize];
        heapSize -= 1;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int i) {
        while (i <= heapSize) {
            int max = heap[i];
            int max_id = i;
            if (left(i) <= heapSize && max < heap[left(i)]) {
                max = heap[left(i)];
                max_id = left(i);
            }
            if (right(i) <= heapSize && max < heap[right(i)]) {
                max = heap[right(i)];
                max_id = right(i);
            }
            if (max_id != i) {
                swap(max_id, i);
                i = max_id;
            } else {
                break;
            }
        }
    }

    // Xuat phan tu max
    public int[] printMax() {
        int[] a = new int[heapSize];
        int n = heapSize;
        int max;
        while (heapSize > 0) {
            max = extractMax();
            a[n - 1] = max;
            --n;
            System.out.print(max + " ");
        }
        System.out.println();
        return a;
    }

    // Tu viet
    public static void main(String[] arg) {
        MaxHeap m = new MaxHeap(100);
        String s = "8 10 1 6 5 20 11 9 15";

        String[] t = s.split(" ");
        int a, i;
        for (i = 0; i < t.length; ++i) {
            a = Integer.parseInt(t[i]);
            m.insert(a);
            m.print();
        }
        System.out.println("In phan tu max: ");
        int[] arr = m.printMax();

        // in ra mang tang dan
        System.out.println("Mang a tang dan: ");
        for (i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

}