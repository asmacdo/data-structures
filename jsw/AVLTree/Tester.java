public class Tester {

    public static void main(String[] args) {
    
        // Create tree
        // Also insertion
        //Integer[] iArr = {6, 2, 3, 1, 8, 7, 9, 10, 11};
        //AVLTree<Integer> intTree = new AVLTree<Integer>(iArr);

        //// Pretty print
        //System.out.println(intTree.prettyPrint(intTree.root));

        //// Find
        //Node eight = intTree.searchFor(8);

        //// Deletion
        //intTree.removeNode(6);
        //System.out.println(intTree.prettyPrint(intTree.root));
        ////intTree.addNode(6);
        ////System.out.println(intTree.prettyPrint(intTree.root));
        //intTree.removeNode(8);
        //System.out.println(intTree.prettyPrint(intTree.root));
        ////intTree.addNode(8);
        ////System.out.println(intTree.prettyPrint(intTree.root));

        ////Test Rotation
        //Integer[] inOrder = {1, 2, 3};
        //AVLTree<Integer> badTree = new AVLTree<Integer>(inOrder);
        //System.out.println(badTree.prettyPrint(badTree.root));
        //badTree.singleRotate(badTree.root, 0);
        //System.out.println(badTree.prettyPrint(badTree.root));
       
        //Test Double Rotation
        Integer[] nbcOrder = {1, 6, 5};
        AVLTree<Integer> waveTree = new AVLTree<Integer>(nbcOrder);
        System.out.println(waveTree.prettyPrint(waveTree.root));
        waveTree.doubleRotate(waveTree.root, 0);
        System.out.println(waveTree.prettyPrint(waveTree.root));
        
    }
}
