// import java.util.*;

// public class test {
//     public static void main(String[] args) {
//         int arr[] = {1,2,3,4,5,6,7,8,9,0};
//         for (int i =0; i < arr.length; i++) {
//             System.out.println("Phan tu thu " + i + "la:" + arr[i]);
//         }
//     }
// }
// Viet 1 ham cong tat ca cac phan tu cua mang len 1 va in ra man hinh trong ham main
// public class test {
//     public class Main {
//         // public static void increaseArray(int[] array) {
//         //     for (int i = 0; i < array.length; i++) {
//         //         array[i] += 1;
//         //     }
//         // }

//         // public static void printArray(int[] array) {
//         //     for (int i = 0; i < array.length; i++) {
//         //         System.out.println(array[i]);
//         //     }
//         // }

//         // public static void main(String[] args) {
//         //     int[] array = { 1, 2, 3, 4, 5 };
//         //     increaseArray(array);
//         //     printArray(array);
//         // }

//         // private static void printArray(int[] array) {
//         //     for (int i = 0; i < array.length; i++) {
//         //         System.out.println(array[i]);
//         //     }
//         // }

//         // private static void increaseArray(int[] array) {
//         //     for (int i = 0; i < array.length; i++) {
//         //         array[i] += 1;
//         //     }
//         // }

        
//     }

// }

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        increaseArray(arr);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void increaseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1;
        }
    }
}