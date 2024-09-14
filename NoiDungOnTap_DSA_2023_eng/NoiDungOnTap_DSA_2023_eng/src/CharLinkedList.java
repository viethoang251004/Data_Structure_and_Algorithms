class CharLinkedList implements ListInterface {
    private Node head;

    public CharLinkedList() {
        // head = null;
        head = null;
    }

    @Override
    public Node getHead() {
        // code here
        // return head;
        return head;
    }

    @Override
    public void addFirst(char data) {
        // code here
        // Node newNode = new Node(data, head);
        // head = newNode;
        Node newNode = new Node(data, head);
        head = newNode;
    }

    @Override
    public boolean addAfterFirstKey(char data, char key) {
        // code here
        // Node currentNode = head;
        // while (currentNode != null) {
        // if (currentNode.getData() == key) {
        // Node newNode = new Node(data, currentNode.getNext());
        // currentNode.setNext(newNode);
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        // return false;
        // Node currentNode = head;
        // while (currentNode != null) {
        // if (currentNode.getData() == key) {
        // Node newNode = new Node(data, currentNode.getNext());
        // currentNode.setNext(newNode);
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        // return false;
        // Node currentNode = head;
        // while (currentNode != null) {
        // if (currentNode.getData() == key) {
        // Node newNode = new Node(data, currentNode.getNext());
        // currentNode.setNext(newNode);
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        // return false;
        // Node currentNode = head;
        // while (currentNode != null) {
        // if (currentNode.getData() == key) {
        // Node newNode = new Node(data, currentNode.getNext());
        // currentNode.setNext(newNode);
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        // return false;
        // Node currentNode = head;
        // while (currentNode != null) {
        // if (currentNode.getData() == key) {
        // Node newNode = new Node(data, currentNode.getNext());
        // currentNode.setNext(newNode);
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        // return false;
        // Node currentNode = head;
        // while (currentNode != null) {
        // if (currentNode.getData() == key) {
        // Node newNode = new Node(data, currentNode.getNext());
        // currentNode.setNext(newNode);
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        // return false;
        // Node currentNode = head;
        // while (currentNode != null) {
        // if (currentNode.getData() == key) {
        // Node newNode = new Node(data, currentNode.getNext());
        // currentNode.setNext(newNode);
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        // return false;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == key) {
                Node newNode = new Node(data, currentNode.getNext());
                currentNode.setNext(newNode);
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public int largestCharPostition() {
        // if (head == null) {
        // return -1;
        // }

        // char maxChar = head.getData();
        // int position = 0;
        // int maxPosition = 0;

        // Node currentNode = head.getNext();
        // while (currentNode != null) {
        // position++;
        // if (currentNode.getData() > maxChar) {
        // maxChar = currentNode.getData();
        // maxPosition = position;
        // }
        // currentNode = currentNode.getNext();
        // }

        // return maxPosition;
        if (head == null) {
            return -1;
        }

        char maxChar = head.getData();
        int position = 0;
        int maxPosition = 0;
        Node currentNode = head.getNext();
        while (currentNode != null) {
            position++;
            if (currentNode.getData() > maxChar) {
                maxChar = currentNode.getData();
                maxPosition = position;
            }
            currentNode = currentNode.getNext();
        }
        return maxPosition;
    }

    // Helper method to print the linked list
    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // CharLinkedList charList = new CharLinkedList();
        // charList.addFirst('c');
        // charList.addFirst('b');
        // charList.addFirst('A');

        // System.out.println("Original List:");
        // charList.printList();

        // charList.addAfterFirstKey('E', 'b');
        // System.out.println("\nAfter addAfterFirstKey('E', 'b'):");
        // charList.printList();

        // int largestPosition = charList.largestCharPostition();
        // System.out.println("\nPosition of largest character: " + largestPosition);
    }
}
