import java.util.Stack;

public class Question3 {
    public static int calculate(String[] expression) {
        Stack<Integer> stack = new Stack<>();

        for (String item : expression) {
            if (isNumber(item)) {
                stack.push(Integer.parseInt(item));
            } else if (item.equals("+")) {
                int o1 = stack.pop();
                int o2 = stack.pop();
                int result = o2 + o1;
                stack.push(result);
            } else if (item.equals("-")) {
                int o1 = stack.pop();
                int o2 = stack.pop();
                int result = o2 - o1;
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String str) {
        return str.matches("0|([1-9][0-9]*)");
    }

    public static void main(String args[]) {
        System.out.println(calculate(new String[]{"3", "4", "+", "2", "1", "+", "-"})); // Output: 4
    }
}
