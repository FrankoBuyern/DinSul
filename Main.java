public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5, "A");
        tree.insert(3, "B");
        tree.insert(7, "C");
        tree.insert(2, "D");
        tree.insert(4, "E");
        tree.insert(6, "F");
        tree.insert(8, "G");

        System.out.println("BFS:");
        tree.bfs();

        System.out.println("Inorder:");
        tree.inorder();

        System.out.println("Preorder:");
        tree.preorder();

        System.out.println("Postorder:");
        tree.postorder();

        System.out.println("Find 4:");
        Node n = tree.find(4);
        System.out.println(n != null ? n.value : "Not found");

        tree.remove(7);
        System.out.println("After remove 7:");
        tree.inorder();

        // дополнительные задачи
        tree.countDescendants(tree.root);
        tree.computeSum(tree.root);
        tree.computeHeight(tree.root);

        System.out.println("Root descendants: " + tree.root.descendantsCount);
        System.out.println("Root sum: " + tree.root.subtreeSum);
        System.out.println("Root height: " + tree.root.height);
    }
}