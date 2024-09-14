public class bubbleSort {
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // 1. Bottom - up Ascending
    public static int[] bubble1(int[] a) {
        int m, t;
        for (int i = 0; i < a.length - 1; ++i) {
            m = i;
            for (int j = a.length - 1; j > 0; --j)
                if (a[j] < a[j - 1]) {
                    t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }

            print(a);
        }
        return a;
    }

    // 2. Bottom - up descending
    public static int[] bubble2(int[] a) {
        int m, t;
        for (int i = 0; i < a.length - 1; ++i) {
            m = i;
            for (int j = a.length - 1; j > 0; --j)
                if (a[j] > a[j - 1]) {
                    t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }

            print(a);
        }
        return a;
    }

    // 3. Up - Bottom Ascending
    public static int[] bubble3(int[] a) {
        int m, t;
        for (int i = 0; i < a.length - 1; ++i) {
            m = i;
            for (int j = 0; j < a.length - 1 - i; ++j)
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }

            print(a);
        }
        return a;
    }

    public static void main(String[] arg) {
        int[] a = { 8, 10, 1, 6, 5 };
        System.out.println("Original Array: ");
        print(a);
        bubble1(a);
        print(a);
        System.out.println("Original Array: ");
        print(a);
        bubble2(a);
        print(a);
        System.out.println("Original Array: ");
        print(a);
        bubble3(a);
        print(a);
    }
}