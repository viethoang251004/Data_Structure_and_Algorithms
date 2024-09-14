import java.util.NoSuchElementException;

class MinHeap {
    int[] heap;
    int heapSize;
    int maxSize; // maximum size to initialize an heap array

    public MinHeap(int capacity) {
        heapSize = 0;
        this.maxSize = capacity + 1;
        heap = new int[maxSize];
        heap[0] = Integer.MAX_VALUE; // set a large value as the root
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
            throw new NoSuchElementException("Overflow Exception");
        }
        heapSize += 1;
        heap[heapSize] = key;
        shiftUp(heapSize);
    }

    private void shiftUp(int i) {
        while (i > 1 && heap[parent(i)] > heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public int extractMin() {
        if (heapSize == 0) {
            throw new NoSuchElementException("Underflow Exception");
        }
        int min = heap[1];
        heap[1] = heap[heapSize];
        heapSize -= 1;
        shiftDown(1);
        return min;
    }

    private void shiftDown(int i) {
        while (i <= heapSize) {
            int min = heap[i];
            int minId = i;
            if (left(i) <= heapSize && min > heap[left(i)]) {
                min = heap[left(i)];
                minId = left(i);
            }
            if (right(i) <= heapSize && min > heap[right(i)]) {
                min = heap[right(i)];
                minId = right(i);
            }
            if (minId != i) {
                swap(minId, i);
                i = minId;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MinHeap m = new MinHeap(100);
        String s = "8 10 1 6 5 20 11 9 15";
        String[] t = s.split(" ");
        int a, i;
        for (i = 0; i < t.length; ++i) {
            a = Integer.parseInt(t[i]);
            m.insert(a);
            m.print();
        }
        System.out.println("In phan tu min: ");
        int[] arr = m.printMin();
        // in ra mang tang dan
        System.out.println("Mang a tang dan: ");
        for (i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

    public void print() {
        for (int i = 1; i <= heapSize; ++i)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public int[] printMin() {
        int[] a = new int[heapSize];
        int n = heapSize;
        int min;
        while (heapSize > 0) {
            min = extractMin();
            a[n - 1] = min;
            --n;
            System.out.print(min + " ");
        }
        System.out.println();
        return a;
    }
}