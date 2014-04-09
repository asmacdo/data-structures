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
        int i;
        while (true) {
            int cmp = newNode.compareTo(curr);
            // newNode is less than curr
            if (cmp == -1) {
                i = 0; // links to left 
            } else if (cmp == 1) {
                i = 1; // links to right
            } else { return false;} // must be 0, node is already there
            if (curr.links[i]== null) {
                curr.links[i] = newNode;
                curr.links[i].height = curr.height + 1;
                return true;
            } else {
            curr = curr.links[i];
            }
        }
    }

    public Node searchFor(E data) {
        Node curr = root;
        int i;
        while (true) {
            int cmp = data.compareTo((E)curr.data); 
            if (cmp == -1) {
                i = 0;  
            } else if (cmp == 1) {
                i = 1;
            } else if (cmp == 0) {
                return curr;
            } else {
                return null;
            }
            if (curr.links[i] != null) {
                curr = curr.links[i];
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
        s += prettyPrint(curr.links[1]); // right child
        return s;
    }
}
