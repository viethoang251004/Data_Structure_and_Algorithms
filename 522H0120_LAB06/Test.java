class Test 
{
    public static void main(String[] arg)
    {
        // //ex2
        // String s = "10 15 5 25 30";
        // String[] t = s.split(" ");
        // BST b = new BST();
        // b.root = new Node(Integer.parseInt(t[0]));
        // int a;
        // for(int i = 1; i<t.length; ++i) 
        // {
        //     a = Integer.parseInt(t[i]);
        //     b.insert(b.root, a);
        // }
        
        // b.NLR(b.root);
        // System.out.println();

        // b.LNR(b.root);
        // System.out.println();

        // b.LRN(b.root);
        // System.out.println();

        String s = "10 15 5 25 30";
        String[] t = s.split(" ");
        BST b = new BST();
        b.root = new Node(Integer.parseInt(t[0]));
        for (int i = 1; i < t.length; ++i) {
            int a = Integer.parseInt(t[i]);
            b.insert(a);
        }
        //Ex1
        System.out.println("Preorder (NLR) Traversal:");
        b.NLR();

        System.out.println("\nInorder (LNR) Traversal:");
        b.LNR();

        System.out.println("\nPostorder (LRN) Traversal:");
        b.LRN();

        System.out.println("\nMinimum value in the tree: " + b.min());

        int keyToSearch = 15;
        Node searchResult = b.search(keyToSearch);
        if (searchResult != null)
            System.out.println("Node with key " + keyToSearch + " found in the tree.");
        else
            System.out.println("Node with key " + keyToSearch + " not found in the tree.");

        int keyToDelete = 10;
        b.delete(keyToDelete);
        System.out.println("After deleting node with key " + keyToDelete + ":");
        b.LNR();

        //Ex2
        String a = "10 15 5 25 30";
        BST d = createTree(a);

        System.out.println("Inorder (LNR) Traversal:");
        d.LNR();
        System.out.println("Values of the tree in descending order:");
        b.reverseInorder();
    }

    public static BST createTree(String strKey) {
        String[] keys = strKey.split(" ");
        BST bst = new BST();

        for (String key : keys) {
            int value = Integer.parseInt(key);
            bst.insert(value);
        }

        return bst;
    }

    public boolean containsKey(Node x, Integer key) {
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

    public int height() {
        return calculateHeight(root);
    }
    
    private int calculateHeight(Node x) {
        if (x == null) {
            return -1; // Height of an empty tree is -1
        } else {
            int leftHeight = calculateHeight(x.left);
            int rightHeight = calculateHeight(x.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
}