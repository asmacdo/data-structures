public class BSTree<E extends Comparable<E>> {
    Node root;

    // Create a node for each value and add it to the tree
    public BSTree(E[] dataArray) {
        for (E data: dataArray) {
            addNode(data);
        }
    }

    public boolean addNode(E data) {
        // Add the first node
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node curr = root;

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
                newNode.links[1] = curr; // set parent
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

    public boolean removeNode(E data) {
        // Find the node to remove
        Node curr = this.searchFor(data);

        if (curr == null){ return false;} 

        // Internal Nodes
        if (curr.links[0] != null && curr.links[2] != null) {
            Node remove = curr;
            
            // Take the leftmost node of the ride child
            curr = curr.links[0];
            while (curr.links[2] != null) { curr = curr.links[2];}

            // remove node by copying over it, remove extra
            removeNode((E)curr.data);
            remove.data = curr.data;
        } // not internal, has at least 1 null child

        // point parent to curr
        int par = (curr.links[1].links[0] == curr) ? 0 : 2;

        // both links are null, remove parental link
        if (curr.links[0] == null && curr.links[2] == null){
            curr.links[1].links[par] = null;
            return true;
        }

        // 1 and only 1 of the nodes is null
        // point to curr's child
        int child = (curr.links[0] != null) ? 0 : 2;

        curr.links[child].links[1] = curr.links[1]; //parent of child = parent
        curr.links[1].links[par] = curr.links[child]; //child of parent = child
        decrementHeight(curr.links[child]); // decrement all childrens' height
        return true;

        
    }
   
    // recursion is simplest
    public void decrementHeight(Node curr) {
        curr.height--;
        if (curr.links[0] != null) {decrementHeight(curr.links[0]);}
        if (curr.links[2] != null) {decrementHeight(curr.links[2]);}
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
