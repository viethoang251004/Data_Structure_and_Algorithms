public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}