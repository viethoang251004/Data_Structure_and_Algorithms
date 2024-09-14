class CharLinkedList implements ListInterface {
    private Node head;

    public CharLinkedList() {
        head = null;
    }

    @Override
    public Node getHead() {
        // code here
        return head;
    }

    @Override
    public void addFirst(char data) {
        // code here
        Node newNode = new Node(data, head);
        head = newNode;
    }

    @Override
    public boolean addAfterFirstKey(char data, char key) {
        // code here
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == key) {
                Node newNode = new Node(data, currentNode.getNext());
                currentNode.setNext(newNode);
                return true;
            }
        }
        return false;
    }

    @Override
    public int largestCharPostition() {
        // code here
        if (head == null) {
            return -1;
        }

        char maxChar = head.getData();
        int position = 0;
        int maxPosition = 0;
        Node 
    }
}
