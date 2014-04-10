public class Tester {

    public static void main(String[] args) {
    
        // Create tree
        // Also insertion
        Integer[] iArr = {6, 2, 3, 1, 8, 7, 9, 10, 11};
        BSTree<Integer> intTree = new BSTree<Integer>(iArr);

        // Pretty print
        System.out.println(intTree.prettyPrint(intTree.root));

        // Find
        Node eight = intTree.searchFor(8);

        // Deletion
        //intTree.removeNode(6);
        //System.out.println(intTree.prettyPrint(intTree.root));
        //intTree.addNode(6);
        //System.out.println(intTree.prettyPrint(intTree.root));
        intTree.removeNode(8);
        System.out.println(intTree.prettyPrint(intTree.root));
        //intTree.addNode(8);
        //System.out.println(intTree.prettyPrint(intTree.root));
    }
}
