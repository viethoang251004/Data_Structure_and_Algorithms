public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.addFirst(new Integer(2));
        list.addFirst(new Integer(3));
        list.addLast(new Integer(4));
        list.addLast(new Integer(5));
        list.addLast(new Integer(6));
        list.addLast(new Integer(10));
        list.print();

        System.out.println(list.countEven());

        // Add an item after the first odd item
        list.addAfterFirstOdd(new Integer(7), new Integer(8));

        // Remove the first odd item
        list.removeFirstOdd();

        list.print();

        MyLinkedList<Fraction> list1 = new MyLinkedList<Fraction>();
        list1.addFirst(new Fraction(8, 9));
        list1.addLast(new Fraction(30, 7));
        list1.addLast(new Fraction(7, 5));
        list1.addLast(new Fraction(8, 6));
        Fraction x = new Fraction(8, 9);
        list1.print();
    }
}
