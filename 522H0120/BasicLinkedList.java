public class BasicLinkedList<T> implements ListInterface<T> {
    private ListNode<T> head;
    private int size;

    public BasicLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        ListNode<T> newNode = new ListNode<>(element);
        if (head == null) {
            head = newNode;
        } else {
            ListNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        if (index == 0) {
            T removedData = head.getData();
            head = head.getNext();
            size--;
            return removedData;
        } else {
            ListNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            T removedData = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            size--;
            return removedData;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        ListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}