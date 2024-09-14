public class Sorting {
    public static void main(String[] args) {
        System.out.println("minASC");
        int[] a = {64, 25, 12, 22, 11};
        minASC(a);
        System.out.println("maxASC");
        int[] a1 = {76, 25, 12, 22, 11};
        maxASC(a1);
        System.out.println("minDESC");
        int[] a2 = {76, 48, 13, 22, 11};
        minDESC(a2);
        System.out.println("maxDESC");
        int[] a3 = {1, 9, 10, 6, 5};
        maxDESC(a3);
    }

    public static void minASC(int[] a) {
        int m, t;
        for (int i = 0; i < a.length - 1; i++) {
            m = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[m] > a[j]) {
                    m = j;
                }
            }
            print(a);
            t = a[i];
            a[i] = a[m];
            a[m] = t;
        }
    }

    public static void maxASC(int[] a) {
        int m, t;
        for (int i = 0; i < a.length - 1; i++) {
            m = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[m] < a[j]) {
                    m = j;
                }
            }
            print(a);
            t = a[i];
            a[i] = a[m];
            a[m] = t;
        }
    }

    public static void minDESC(int[] a) {
        int m, t;
        for (int i = a.length - 1; i > 0; i--) {
            m = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[m] < a[j]) {
                    m = j;
                }
            }
            print(a);
            t = a[i];
            a[i] = a[m];
            a[m] = t;
        }
    }

    public static void maxDESC(int[] a) {
        int m, t;
        for (int i = a.length - 1; i > 0; i--) {
            m = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[m] > a[j]) {
                    m = j;
                }
            }
            print(a);
            t = a[i];
            a[i] = a[m];
            a[m] = t;
        }
    }


    public static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}