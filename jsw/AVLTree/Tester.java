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
       
        ////Test Double Rotation
        //Integer[] nbcOrder = {1, 6, 5};
        //AVLTree<Integer> waveTree = new AVLTree<Integer>(nbcOrder);
        //System.out.println(waveTree.prettyPrint(waveTree.root));
        //waveTree.doubleRotate(waveTree.root, 0);
        //System.out.println(waveTree.prettyPrint(waveTree.root));
        //waveTree.addNode(7);
        //System.out.println(waveTree.prettyPrint(waveTree.root));
        //waveTree.addNode(8);
        //System.out.println(waveTree.prettyPrint(waveTree.root));

        ////Test rotate while add
        //Integer [] a = {1};
        //AVLTree<Integer> slowAdd = new AVLTree<Integer>(a);
        //System.out.println(slowAdd.prettyPrint(slowAdd.root));
        //slowAdd.addNode(2);
        //System.out.println(slowAdd.prettyPrint(slowAdd.root));
        //slowAdd.addNode(3);
        //System.out.println(slowAdd.prettyPrint(slowAdd.root));
        //slowAdd.addNode(5);
        //System.out.println();
        //System.out.println(slowAdd.prettyPrint(slowAdd.root)); 
        //slowAdd.addNode(4);
        //System.out.println();
        //System.out.println(slowAdd.prettyPrint(slowAdd.root)); 
        //slowAdd.addNode(6);
        //System.out.println(slowAdd.prettyPrint(slowAdd.root)); 

        //Single rotate with leaves
        Integer [] a = {1, 2, 3, 4, 5};
        AVLTree<Integer> leavesRot = new AVLTree<Integer>(a);
        System.out.println(leavesRot);
        leavesRot.addNode(6);
        System.out.println(leavesRot);
 
        
    }
}
