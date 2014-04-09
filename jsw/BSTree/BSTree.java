public class BSTree<E extends Comparable<E>> {
    Node root;

    public BSTree(E[] dataArray) {
        for (E ob: dataArray) {
            Node newNode = new Node(ob);
            addNode(newNode);
        }
    }

    public boolean addNode(Node newNode) {
        if (root == null) {
            root = newNode;
            return true;
        }
        
        Node curr = root;
        while (true) {
            int cmp = newNode.compareTo(curr);
            // newNode is less than curr
            if (cmp == -1) {
                // if left space is available, place new node there
                if (curr.leftChild == null) {
                    curr.leftChild = newNode;
                    curr.leftChild.height = curr.height + 1;
                    return true;
                // else move to leftChild and repeat
                } else {
                curr = curr.leftChild;
                }
            } else if (cmp == 1) {
                if (curr.rightChild == null) {
                    curr.rightChild = newNode;
                    curr.rightChild.height = curr.height + 1;
                    return true;
                } else {
                    curr = curr.rightChild;
                }
            } else {
                return false; // values are == and already in tree.
            }
        }
    }

    public Node searchFor(E data) {
        Node curr = root;
        while (true) {
            int cmp = data.compareTo((E)curr.data); 
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

    public String prettyPrint(Node curr) {
        String pre = "";
        // base case
        if (curr == null) {return "";}
        // add appropriate spaces based on node height 
        for (int i = 0; i < curr.height; i++) {
            pre += "    ";
        }
        // pre order recursion
        String s = prettyPrint(curr.leftChild);
        s += pre + curr + "\n";
        s += prettyPrint(curr.rightChild);
        return s;
    }
}
