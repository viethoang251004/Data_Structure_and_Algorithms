class TestAVL1 {
    public static void main(String[] arg) {
        // String s = "20 10 5 30 40";
        String s = "8 5 2 17 20 10 30 15";

        String[] key = s.split(" ");
        // chuye sang so nguyen
        Integer[] k = new Integer[key.length];
        for (int i = 0; i < k.length; ++i)
            k[i] = Integer.parseInt(key[i]);

        AVL1 b = new AVL1(k[0]);
        for (int i = 1; i < k.length; ++i) {
            b.insert(b.root, k[i]);
            b.root = b.balance(b.root);
        }
        b.NLR(b.root);
        System.out.println();
        b.RNL(b.root);
        System.out.println();

        System.out.println("The height of root: " + b.height(b.root));
        System.out.println("Min of the tree: " + b.min());
        System.out.println("Max of the tree: " + b.max());
        // Them
        int x = 100;
        b.insert(b.root, x);
        b.root = b.balance(b.root);
        b.NLR(b.root);
        System.out.println("The height of root: " + b.height(b.root));

        // xoa
        x = 2;
        b.delete(b.root, x);
        b.NLR(b.root);
        System.out.println();
        System.out.println("The height of root: " + b.height(b.root));

        System.out.println("Sum: " + b.sum(b.root));
        
    }
}