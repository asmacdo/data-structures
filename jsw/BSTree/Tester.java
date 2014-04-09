public class Tester {

    public static void main(String[] args) {
    
        Integer[] iArr = {6, 2, 3, 1, 8, 7};
        BSTree<Integer> intTree = new BSTree<Integer>(iArr);
        
        System.out.println(intTree.prettyPrint(intTree.root));
    }
}
