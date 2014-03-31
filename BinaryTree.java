// Unbalanced Binary tree
public class BinaryTree {
    BNode root;

    public BinaryTree(int[] valueArray) {
        for (int i : valueArray) {
            BNode newNode = new BNode(i, null, null);
            addNode(newNode);
        }    
         
    }

    public boolean addNode(BNode newNode) {
        if (root == null) {
            root = newNode;
            return true;
        }
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

    public String preOrder(BNode curr) {
        String s = "";
        if (curr == null) {return "";}
        s = s + preOrder(curr.leftChild);
        s += curr;
        s += preOrder(curr.rightChild);
        return s;
    }

    public String toString() {
        return preOrder(this.root);
    }

    
    private static class BNode implements Comparable<BNode> {
        int value;
        BNode leftChild;
        BNode rightChild;

        BNode(int value, BNode leftChild, BNode rightChild){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

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
        int[] a = {3, 2, 4};
        BinaryTree bt = new BinaryTree(a); 
        BNode two = bt.searchFor(3);
        System.out.println(two.leftChild);
    }
}
