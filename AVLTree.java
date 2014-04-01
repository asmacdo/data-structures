import java.lang.Math;

public class AVLTree {
    BNode root;

    // Create an array of Nodes from an array of values.
    // Add each to the tree
    public AVLTree(int[] valueArray) {
        for (int i : valueArray) {
            BNode newNode = new BNode(i, null, null);
            addNode(newNode);
        }    
    }

    // Add nodes to tree
    //TODO check for balance
    public boolean addNode(BNode newNode) {
        if (root == null) {
            root = newNode;
            return true;
        }

        // Find the place of each node and add it there.
        BNode curr = root;
        while (true) {
            if (newNode.value < curr.value) {
                if (curr.leftChild == null) {
                    curr.leftChild = newNode;
                    return true;
                }
                curr = curr.leftChild; 
            } else if (newNode.value > curr.value) {
                if (curr.rightChild == null) {
                    curr.rightChild = newNode;
                    return true;
                }
                curr = curr.rightChild;
            } else {
                return false; // value is equal and already in tree
            }
            
        }
    }
    private static int getHeight(BNode curr) {
        int leftH = 0;
        int rightH = 0;
        if (curr.leftChild != null) {
            leftH = getHeight(curr.leftChild);
        }
        if (curr.rightChild != null) {
            rightH = getHeight(curr.rightChild);
        }
        return 1 + Math.max(leftH, rightH);
    }

    private static boolean isBalanced(BNode curr) {
        int leftH = 0;
        int rightH = 0;
        boolean leftBal = true;
        boolean rightBal = true;
        if (curr.leftChild != null){
            leftH = getHeight(curr.leftChild);
            leftBal = isBalanced(curr.leftChild);
        }            
        if (curr.rightChild != null) {
            rightH = getHeight(curr.rightChild);
            rightBal = isBalanced(curr.rightChild);
        }
        if (leftH == 0 && rightH ==0) {return true;}
        int diff = leftH - rightH;
        System.out.println(diff);
        if (diff > 1 || diff < -1) {
            return false;
        } else {
            return leftBal && rightBal; 
        }
    }

    // Binary seach
    public BNode searchFor(int val) {
        BNode curr = root;
        while (true) {
            if (val < curr.value) {
                if (curr.leftChild != null) {
                    curr = curr.leftChild;        
                } else {
                    return null;
                }
            } else if (val > curr.value) {
                if (curr.rightChild != null) {
                    curr = curr.rightChild;
                } else {
                    return null;
                }
            } else if (val == curr.value) {
                return curr;
            } else { return null;}
        }
    }

    // Recursively stringify in preorder
    public String preOrder(BNode curr) {
        String s = "";
        if (curr == null) {return "";}
        s = s + preOrder(curr.leftChild);
        s += curr;
        s += preOrder(curr.rightChild);
        return s;
    }

    // Cannot be called recursivley because BNode has its own toString()
    public String toString() {
        return preOrder(this.root);
    }

    
    // Implements comparable allows... well, it still works with out it.
    // Why do peoople use this??
    private static class BNode {// implements Comparable<BNode> {
        int value;
        BNode leftChild;
        BNode rightChild;

        // Constuctor
        BNode(int value, BNode leftChild, BNode rightChild){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        // Bigger is positive, 0 is equal, less than is negative
        public int compareTo(BNode other) {
            return this.value - other.value;
        }

        public String toString(){
            String s = "" + this.value;
            return s;
        }
    }

    // For testing only
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        AVLTree bt = new AVLTree(a); 
        BNode three = bt.searchFor(3);
        System.out.println(isBalanced(three));
        BNode one = bt.searchFor(1);
        System.out.println(isBalanced(one));
    }
}
