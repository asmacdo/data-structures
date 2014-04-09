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
            int cmp = 1 - newNode.compareTo(curr);
            if (cmp == 1) {
                return false;
            }
            if (curr.links[cmp]== null) {
                curr.links[cmp] = newNode;
                curr.links[cmp].height = curr.height + 1;
                return true;
            } else {
                curr = curr.links[cmp];
            }
        }
    }

    public Node searchFor(E data) {
        Node curr = root;
        while (true) {
            int cmp = data.compareTo((E)curr.data) + 1; 
            if (cmp == 1) {
                return null;
            }
            if (curr.links[cmp] != null) {
                curr = curr.links[cmp];
            } else {
                return null;
            }
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
        String s = prettyPrint(curr.links[0]); // leftChild
        s += pre + curr + "\n";
        s += prettyPrint(curr.links[2]); // right child
        return s;
    }
}
