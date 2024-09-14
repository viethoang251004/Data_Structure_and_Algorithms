import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numNode;

    public MyLinkedList() {
        head = null;
        numNode = 0;
    }

    @Override
    public void addFirst(E item) {
        head = new Node<E>(item, head);
        numNode++;
    }

    @Override
    public void addAfter(Node<E> curr, E item) {
        if (curr == null) {
            addFirst(item);
        } else {
            Node<E> newNode = new Node<E>(item, curr.getNext());
            curr.setNext(newNode);
        }
        numNode++;
    }

    @Override
    public void addLast(E item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node<E> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            Node<E> newNode = new Node<E>(item, null);
            tmp.setNext(newNode);
            numNode++;
        }
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {
            Node<E> tmp = head;
            head = head.getNext();
            numNode--;
            return tmp.getData();
        }
    }

    @Override
    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if (curr == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {

            Node<E> delNode = curr.getNext();
            if (delNode != null) {
                curr.setNext(delNode.getNext());
                numNode--;
                return delNode.getData();
            } else {
                throw new NoSuchElementException("No next node to remove");
            }
        }
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {
            Node<E> preNode = null;
            Node<E> delNode = head;
            while (delNode.getNext() != null) {
                preNode = delNode;
                delNode = delNode.getNext();
            }

            preNode.setNext(delNode.getNext());
            delNode.setNext(null);
            numNode--;
            return delNode.getData();
        }
    }

    // Cau 2
    public E removeCurr(Node<E> curr) {
        if (curr == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {
            Node<E> p = head;
            Node<E> q = null;
            while (p != null) {
                if (p.getData().equals(curr)) {
                    break;
                }
                q = p;
                p = p.getNext();
            }
            return q.getData();
        }
    }

    @Override
    public void print() {
        if (head != null) {
            Node<E> tmp = head;
            System.out.print("List: " + tmp.getData());
            tmp = tmp.getNext();
            while (tmp != null) {
                System.out.print(" -> " + tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("List is empty!");

        }
    }

    @Override
    public boolean isEmpty() {
        if (numNode == 0)
            return true;
        return false;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't get element from an empty list");
        } else {
            return head.getData();
        }
    }

    @Override
    public Node<E> getHead() {
        return head;
    }

    @Override
    public int size() {
        return numNode;
    }

    @Override
    public boolean contains(E item) {
        Node<E> tmp = head;
        while (tmp != null) {
            if (tmp.getData().equals(item))
                return true;
            tmp = tmp.getNext();
        }
        return false;
    }

    // (a) Count the number of even items in the list.
    public int countEven() {
        int count = 0;
        Node<E> p = head;
        while (p != null) {
            if (p.getData() instanceof Integer) {
                int value = (int) p.getData();
                if (value % 2 == 0) {
                    count++;
                }
            }
            p = p.getNext();
        }
        return count;
    }

    // (b) Count the number of prime items in the list.
    public int countPrime() {
        int count = 0;
        Node<E> p = head;
        while (p != null) {
            if (p.getData() instanceof Integer) {
                int value = (int) p.getData();
                if (isPrime(value)) {
                    count++;
                }
            }
            p = p.getNext();
        }
        return count;
    }

    // Helper function to check if a number is prime.
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // (c) Add item X before the first even element in the list.
    public void addBeforeFirstEven(E item, E newItem) {
        Node<E> prev = null;
        Node<E> curr = head;
        while (curr != null) {
            if (curr.getData() instanceof Integer) {
                int value = (int) curr.getData();
                if (value % 2 == 0) {
                    Node<E> newNode = new Node<>(newItem);
                    if (prev == null) {
                        // Insert at the beginning of the list.
                        newNode.setNext(head);
                        head = newNode;
                    } else {
                        // Insert between prev and curr.
                        newNode.setNext(curr);
                        prev.setNext(newNode);
                    }
                    numNode++;
                    return;
                }
            }
            prev = curr;
            curr = curr.getNext();
        }
        // If no even element was found, add newItem at the end of the list.
        addLast(newItem);
    }

    // (d) Find the maximum number in the list.
    public int findMax() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> curr = head;
        int max = Integer.MIN_VALUE;
        while (curr != null) {
            if (curr.getData() instanceof Integer) {
                int value = (int) curr.getData();
                if (value > max) {
                    max = value;
                }
            }
            curr = curr.getNext();
        }
        return max;
    }

    // (e) (*) Reverse the list without using a temporary list.
    public void reverse() {
        if (head == null || head.getNext() == null) {
            // List is empty or has only one element.
            return;
        }

        Node<E> prev = null;
        Node<E> curr = head;
        Node<E> next;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev; // Update the head to the new first element.
    }

    // // (1) Add item having value X after the first odd item in the linked list.
    // public void addAfterFirstOdd(E item, E newItem) {
    //     Node<E> curr = head;
    //     while (curr != null) {
    //         if (curr.getData() instanceof Integer) {
    //             int value = (int) curr.getData();
    //             if (value % 2 != 0) {
    //                 Node<E> newNode = new Node<>(newItem);
    //                 newNode.setNext(curr.getNext());
    //                 curr.setNext(newNode);
    //                 numNode++;
    //                 return;
    //             }
    //         }
    //         curr = curr.getNext();
    //     }
    //     addLast(newItem);
    // }

    // // (2) Remove the first odd item in the linked list.
    // public void removeFirstOdd() {
    //     if (head == null) {
    //         return; // List is empty, nothing to remove.
    //     }

    //     if (head.getData() instanceof Integer) {
    //         int value = (int) head.getData();
    //         if (value % 2 != 0) {
    //             head = head.getNext(); // Remove the first odd element.
    //             numNode--;
    //             return;
    //         }
    //     }

    //     Node<E> prev = head;
    //     Node<E> curr = head.getNext();

    //     while (curr != null) {
    //         if (curr.getData() instanceof Integer) {
    //             int value = (int) curr.getData();
    //             if (value % 2 != 0) {
    //                 prev.setNext(curr.getNext()); // Remove the first odd element.
    //                 numNode--;
    //                 return;
    //             }
    //         }
    //         prev = curr;
    //         curr = curr.getNext();
    //     }
    // }

    public void addAfterFirstOdd(E item){
        Node <E> p = head;
        while (p!=null){
            if((int)p.getData() % 2 == 1){
                break;
            }
            p = p.getNext();
        }
        if(p!=null){
            Node<E> newNode = new Node<E>(item, p.getNext());
            p.setNext(newNode);
        }
    }

    public void removeAfterFirstOdd(){
        Node <E> p = head;
        Node <E> q = head;
        while (p!=null){
            if((int)p.getData() % 2 == 1){
                break;
            }
            p = p.getNext();
        }
        if(p!=null){
            q.setNext(p.getNext());
        }
    }
}
