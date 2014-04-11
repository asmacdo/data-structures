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

        ////Single rotate with leaves
        Integer [] a = {1, 2, 4};
        AVLTree<Integer> leavesRot = new AVLTree<Integer>(a);
        System.out.println(leavesRot);
        leavesRot.addNode(6);
        System.out.println(leavesRot);
        leavesRot.addNode(5);
        System.out.println(leavesRot);
        leavesRot.addNode(3);
        System.out.println(leavesRot);

        // Large Data set
        //Integer [] big =  {1,2,3,4,5,6,7,8,9,10,55,33,88,33,345,23,2,53,4,1232,4,2,4,2,3,4,34,4,34,2868,4,34,2,2234,2,32,423,24,34,7,45,2,1,43};
        //AVLTree<Integer> bigSet = new AVLTree<Integer>(big); 
        //System.out.println(bigSet);
    }
}
