public class Question2 {
    public static int recur(int n, int k) {
        if (k == 0) {
            return 1;
        } else {
            return n * recur(n, k - 1);
        }
    }

    public static void main(String args[]) {
        int n = 5; // Replace with your desired values for n and k
        int k = 3;
        
        int result = recur(n, k);
        System.out.println("A(" + n + ", " + k + ") = " + result);
    }
}