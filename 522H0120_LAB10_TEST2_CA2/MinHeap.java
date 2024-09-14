//TEST2
//PART_2

import java.io.*;
import java.util.*;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert value: " + value);
            return;
        }

        size++;
        int i = size - 1;
        heap[i] = value;

        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);

        return root;
    }

    private void minHeapify(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public void printFirstThreeMinValues() {
        if (size < 3) {
            System.out.println("Heap does not contain at least three elements.");
            return;
        }

        System.out.println("First three min values in the binary min heap:");
        for (int i = 0; i < 3; i++) {
            System.out.print(extractMin() + " ");
        }
        System.out.println();
    }

    public void heapSortDescending() {
        int[] sortedArray = new int[size];
        int originalSize = size;

        for (int i = 0; i < originalSize; i++) {
            sortedArray[i] = extractMin();
        }

        System.out.println("Sorted array in descending order:");
        System.out.println(Arrays.toString(sortedArray));
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(12);

        try {
            File file = new File("text.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int data = scanner.nextInt();
                minHeap.insert(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        minHeap.printFirstThreeMinValues();

        minHeap.heapSortDescending();
    }
}
