public class BSTree<E extends Comparable<E>> {
    Node root;

    // Create a node for each value and add it to the tree
    public BSTree(E[] dataArray) {
        for (E ob: dataArray) {
            Node newNode = new Node(ob);
            addNode(newNode);
        }
    }

    public boolean addNode(Node newNode) {
        // Add the first node
        if (root == null) {
            root = newNode;
            return true;
        }
        Node curr = root

        // compareTo returns -1 for less than, 0 for equal, 1 for greater
        // Because links[0] points to left child, links[2] points to
        // right child. This means that cmp will be the appropriate value 
        // to iterate though the array. This allows symmetric operations
        // to be combined into a single, simpler function.
        int cmp = 1 - newNode.compareTo(curr);
        while (cmp != 1) {
            // A spot for the new node is found. put it there.
            if (curr.links[cmp] == null) {
                curr.links[cmp] = newNode;
                curr.links[cmp].height = curr.height + 1;
                return true;
            } else {
                curr = curr.links[cmp];
                // reset cmp and loop
                cmp = 1 - newNode.compareTo(curr);
            }
        }
        // cmp == 1, so the new node is a duplicate. do not add
        return false;
    }

    public Node searchFor(E data) {
        Node curr = root;
        // As with addNode, the cmp variable is the index of the correct
        // child unless it is 1, in this case the node is found.
        int cmp = 1 - data.compareTo((E)curr.data); 
        while (cmp != 1) {
            if (curr.links[cmp] != null) {
                curr = curr.links[cmp];
                cmp = 1 - data.compareTo((E)curr.data); 
            } else {
                // the child is null so the data is not currently in the tree
                return null;
            }
        }
        // cmp == 1, so the data is a match, return current node
        return curr;
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
