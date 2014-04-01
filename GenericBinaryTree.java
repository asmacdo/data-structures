// Unbalanced Binary tree
public class GenericBinaryTree<E extends Comparable<E>> {
    BNode root;

    public GenericBinaryTree(E[] valueArray) {
        for (E ob: valueArray) {
            BNode newNode = new BNode(ob, null, null);
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
            int cmp = newNode.compareTo(curr);
            if (cmp == -1) {
                if (curr.leftChild == null) {
                    curr.leftChild = newNode;
                    return true;
                }
                curr = curr.leftChild; 
            } else if (cmp == 1) {
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

    public BNode searchFor(E val) {
        BNode curr = root;
        while (true) {
            int cmp = val.compareTo((E)curr.value);
            if (cmp == -1) {
                if (curr.leftChild != null) {
                    curr = curr.leftChild;        
                } else {
                    return null;
                }
            } else if (cmp == 1) {
                if (curr.rightChild != null) {
                    curr = curr.rightChild;
                } else {
                    return null;
                }
            } else if (cmp == 0) {
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

    
    private static class BNode<E extends Comparable<E>> {
        E value;
        BNode leftChild;
        BNode rightChild;

        BNode(E value, BNode leftChild, BNode rightChild){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public int compareTo(BNode<E> other) {
            E thisVal = this.value;
            E otherVal = other.value;
            return thisVal.compareTo(otherVal);
        }

        public String toString(){
            String s = "" + this.value;
            return s;
        }
    }

    // For testing only
    public static void main(String[] args) {
        Integer[] a = {3, 2, 4};
        GenericBinaryTree<Integer> bt = new GenericBinaryTree<Integer>(a); 
        BNode three = bt.searchFor(3);
        System.out.println(three.leftChild);
    }
}
