public class Test1 {
    public static void Test1() {
        BST b = new BST();

        // Thêm các giá trị vào cây
        b.insert(10);
        b.insert(15);
        b.insert(5);
        b.insert(25);
        b.insert(30);

        // Kiểm tra việc in ra các dạng duyệt đúng không
        System.out.println("Preorder (NLR) Traversal:");
        b.NLR();

        System.out.println("\nInorder (LNR) Traversal:");
        b.LNR();

        System.out.println("\nPostorder (LRN) Traversal:");
        b.LRN();

        // Kiểm tra giá trị nhỏ nhất
        System.out.println("\nMinimum value in the tree: " + b.min());

        // Kiểm tra việc tìm kiếm một giá trị có trong cây hay không
        int keyToSearch = 15;
        Node searchResult = b.search(keyToSearch);
        if (searchResult != null)
            System.out.println("Node with key " + keyToSearch + " found in the tree.");
        else
            System.out.println("Node with key " + keyToSearch + " not found in the tree.");

        // Kiểm tra việc xóa một nút khỏi cây
        int keyToDelete = 10;
        b.delete(keyToDelete);
        System.out.println("After deleting node with key " + keyToDelete + ":");
        b.LNR();

        // Kiểm tra việc kiểm tra sự tồn tại của một giá trị trong cây
        int keyToCheck = 5;
        if (b.contains(keyToCheck)) {
            System.out.println("Key " + keyToCheck + " is in the tree.");
        } else {
            System.out.println("Key " + keyToCheck + " is not in the tree.");
        }
    }

    public static void main(String[] arg) {
        Test1();
    }
}