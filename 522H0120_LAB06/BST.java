class BST {
    // public Node root;

    // public BST() {
    // root = null;
    // }

    // public Node insert(Node x, Integer key) {
    // if (x == null)
    // return new Node(key);
    // int cmp = key.compareTo(x.key);
    // if (cmp < 0)
    // x.left = insert(x.left, key);
    // else if (cmp > 0)
    // x.right = insert(x.right, key);
    // else
    // x.key = key;
    // return x;
    // }

    // public void NLR(Node x) {
    // if (x != null) {
    // System.out.print(x.key + " ");
    // NLR(x.left);
    // NLR(x.right);
    // }
    // }

    // public void LNR(Node x) {
    // if (x != null) {
    // LNR(x.left);
    // System.out.println(x.key + " ");
    // LNR(x.right);
    // }
    // }

    // public void LRN(Node x) {
    // if (x != null) {
    // LRN(x.left);
    // LRN(x.right);
    // System.out.println(x.key + " ");
    // }
    // }

    // public Node search(Node x, Integer key) {
    // if (x == null)
    // return null;
    // int cmp = key.compareTo(x.key);
    // if (cmp < 0)
    // return search(x.left, key);
    // else if (cmp > 0)
    // return search(x.right, key);
    // else
    // return x;
    // }

    // public Node min(Node x) {
    // if (x.left == null)
    // return x;
    // else
    // return min(x.left);
    // }

    // public Node deleteMin(Node x) {
    // if (x.left == null)
    // return x.right;
    // x.left = deleteMin(x.left);
    // return x;
    // }

    // private Node delete(Node x, Integer key) {
    // if (x == null)
    // return null;
    // int cmp = key.compareTo(x.key);
    // if (cmp < 0)
    // x.left = delete(x.left, key);
    // else if (cmp > 0)
    // x.right = delete(x.right, key);
    // else {
    // // node with only one child or no child
    // if (x.right == null)
    // return x.left;
    // if (x.left == null)
    // return x.right;
    // // node with two childen: Get the successor (smallest in the right subtree)
    // x.key = min(x.right).key;
    // x.right = deleteMin(x.right);
    // }
    // return x;
    // }

    // // ex3
    // // public void LNR(Node x) {
    // // if (x != null) {
    // // LNR(x.left);
    // // System.out.print(x.key + " ");
    // // LNR(x.right);
    // // }
    // // }
    public Node root;

    public BST() {
        root = null;
    }

    public void insert(Integer key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node x, Integer key) {
        if (x == null)
            return new Node(key);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insertNode(x.left, key);
        else if (cmp > 0)
            x.right = insertNode(x.right, key);
        else
            x.key = key;

        return x;
    }

    public void NLR() {
        NLRTraversal(root);
    }

    private void NLRTraversal(Node x) {
        if (x != null) {
            System.out.print(x.key + " ");
            NLRTraversal(x.left);
            NLRTraversal(x.right);
        }
    }

    public void LNR() {
        LNRTraversal(root);
    }

    private void LNRTraversal(Node x) {
        if (x != null) {
            LNRTraversal(x.left);
            System.out.print(x.key + " ");
            LNRTraversal(x.right);
        }
    }

    public void LRN() {
        LRNTraversal(root);
    }

    private void LRNTraversal(Node x) {
        if (x != null) {
            LRNTraversal(x.left);
            LRNTraversal(x.right);
            System.out.print(x.key + " ");
        }
    }

    public Node search(Integer key) {
        return searchNode(root, key);
    }

    private Node searchNode(Node x, Integer key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return searchNode(x.left, key);
        else if (cmp > 0)
            return searchNode(x.right, key);
        else
            return x;
    }

    public Integer min() {
        Node minNode = findMin(root);
        return minNode != null ? minNode.key : null;
    }

    private Node findMin(Node x) {
        if (x == null)
            return null;
        else if (x.left == null)
            return x;
        else
            return findMin(x.left);
    }

    public void delete(Integer key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node x, Integer key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = deleteNode(x.left, key);
        else if (cmp > 0)
            x.right = deleteNode(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;

            x.key = findMin(x.right).key;
            x.right = deleteNode(x.right, x.key);
        }
        return x;
    }

    public void reverseInorder() {
        reverseInorderTraversal(root);
    }

    private void reverseInorderTraversal(Node x) {
        if (x != null) {
            reverseInorderTraversal(x.right);
            System.out.print(x.key + " ");
            reverseInorderTraversal(x.left);
        }
    }

    public boolean contains(Integer key) {
        return containsKey(root, key);
    }

    private boolean containsKey(Node x, Integer key) {
        if (x == null)
            return false;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return containsKey(x.left, key);
        else if (cmp > 0)
            return containsKey(x.right, key);
        else
            return true; // Key found in the tree
    }

    // public boolean contains(Integer key) {
    // if (search(root, key) == null)
    // return false;
    // return true;
    // }

    public void deleteMax() {
        root = deleteMaxNode(root);
    }
    
    private Node deleteMaxNode(Node x) {
        if (x == null)
            return null;
    
        if (x.right == null) {
            // If the right child is null, this node contains the maximum key
            return x.left;
        }
    
        x.right = deleteMaxNode(x.right);
        return x;
    }

    public void delete_pre(Integer key) {
        root = deletePredecessorNode(root, key);
    }
    
    private Node deletePredecessorNode(Node x, Integer key) {
        if (x == null)
            return null;
    
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = deletePredecessorNode(x.left, key);
        } else if (cmp > 0) {
            x.right = deletePredecessorNode(x.right, key);
        } else {
            // Node found, perform deletion
            if (x.left == null) {
                // Node has no left child, so just return the right child
                return x.right;
            } else {
                // Node has a left child, find the predecessor (maximum value in the left subtree)
                x.key = findMax(x.left).key;
                x.left = deleteMaxNode(x.left);
            }
        }
        return x;
    }
    
    private Node findMax(Node x) {
        if (x == null)
            return null;
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }    
}