class AVL1 {
    Node root;

    public AVL1() {
        root = null;
    }

    public AVL1(int key) {
        root = new Node(key);
    }

    public int height(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }

    public int checkBalance(Node x) {
        return height(x.left) - height(x.right);
    }

    public Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    public Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    public Node insert(Node x, Integer key) // tuan truoc
    {
        if (x == null)
            return new Node(key);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insert(x.left, key);
        else if (cmp > 0)
            x.right = insert(x.right, key);
        else
            x.key = key;

        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    public Node balance(Node x) {
        if (checkBalance(x) < -1) {
            if (checkBalance(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        } else if (checkBalance(x) > 1) {
            if (checkBalance(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }

    public void NLR(Node x)// tuan truoc
    {
        if (x != null) {
            System.out.print(x.key + "  ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void RNL(Node x) {
        if (x != null) {
            RNL(x.right);
            System.out.print(x.key + " ");
            RNL(x.left);
        }
    }

    public Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public int min() {
        return min(root).key;
    }

    public Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public int max() {
        return max(root).key;
    }

    public Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public Node delete(Node x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else // found
        {
            // node with only one child or no child
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            // node with two children: Get the successor (smallest in the right subtree)
            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
            // predecessor
            // x.key = max(x.left).key;
            // x.left = deleteMax(x.left);
        }
        return x;
    }

    // sum
    public int sum(Node x) {
        if (x == null)
            return 0;
        return x.key + sum(x.left) + sum(x.right);
    }

    public int sum() {
        return sum(root);
    }

    // sum Even
    public int sumEven(Node x) {
        if (x == null)
            return 0;
        else if (x.key % 2 == 0)
            return x.key + sumEven(x.left) + sumEven(x.right);
        else
            return sumEven(x.left) + sumEven(x.right);

    }

    // child
    public int countChild(Node x) {
        if (x == null)
            return 0;
        return 1 + countChild(x.left) + countChild(x.right);
    }
}