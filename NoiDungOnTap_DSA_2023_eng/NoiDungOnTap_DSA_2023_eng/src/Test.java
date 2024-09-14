import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<Integer>();
        intStack.push(2);
        intStack.push(5);
        intStack.push(1);
        while (!intStack.isEmpty()) {
            System.out.print(intStack.pop() + " ");
        }

        CharLinkedList charList = new CharLinkedList();
        charList.addFirst('c');
        charList.addFirst('b');
        charList.addFirst('A');

        System.out.println("Original List:");
        charList.printList();

        charList.addAfterFirstKey('E', 'b');
        System.out.println("\nAfter addAfterFirstKey('E', 'b'):");
        charList.printList();

        int largestPosition = charList.largestCharPostition();
        System.out.println("\nPosition of largest character: " + largestPosition);
    }
}