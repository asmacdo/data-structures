import java.lang.Math;

public class AVLTree<E extends Comparable<E>> {
    Node root;

    // Create a node for each value and add it to the tree
    public AVLTree(E[] dataArray) {
        for (E data: dataArray) {
            addNode(data);
        }
    }

    public boolean addNode(E data) {
        // Add the first node
        System.out.println("Adding: " + data);
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
        int cmp = newNode.compareTo(curr) + 1;
        while (cmp != 1) {
            // A spot for the new node is found. put it there.
            if (curr.links[cmp] == null) {
                curr.links[cmp] = newNode;
                newNode.links[1] = curr; // set parent
                curr.links[cmp].height = curr.height + 1;
                --cmp;
                curr.balance += cmp;
                curr = curr.links[1];
                while (curr != null) {
                    int lBal = -1; 
                    int rBal = -1;
                    if (curr.links[0] != null) {lBal = curr.links[0].balance;}
                    if (curr.links[2] != null) {rBal = curr.links[2].balance;}

                    if (curr.balance > 0) {
                        curr.balance += rBal - lBal;
                    } else if (curr.balance < 0) {
                        curr.balance -= rBal - lBal;
                    //if (curr.balance > 0) {
                    //    curr.balance += Math.abs(cmp);
                    //} else if (curr.balance < 0) {
                    //    curr.balance -= Math.abs(cmp);
                    } else {
                        curr.balance = rBal - lBal;
                    }
                    if (curr.balance > 1 || curr.balance < -1){
                        rotate(curr);
                        Node save = curr;
                        while (curr != null) {
                            lBal = rBal = -1;
                            if (curr.links[0] != null) {lBal = curr.links[0].balance;}
                            if (curr.links[2] != null) {rBal = curr.links[2].balance;}
                            if (curr.balance > 0) {
                                curr.balance += rBal - lBal;
                            } else if (curr.balance < 0) {
                                curr.balance -= rBal - lBal;
                            } else { curr.balance = rBal - lBal;}
                            curr = curr.links[1]; 
                        }
                        curr = save;
                        System.out.println(curr);
                        
                    } 
                        curr = curr.links[1];
                }
                return true;
            } else {
                curr = curr.links[cmp];
                // reset cmp and loop
                cmp = newNode.compareTo(curr) + 1;
            }
        }
        return false;
    }

    public Node searchFor(E data) {
        Node curr = root;
        // As with addNode, the cmp variable is the index of the correct
        // child unless it is 1, in this case the node is found.
        int cmp = data.compareTo((E)curr.data) + 1; 
        while (cmp != 1) {
            if (curr.links[cmp] != null) {
                curr = curr.links[cmp];
                cmp = data.compareTo((E)curr.data) + 1; 
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
        if (curr == null){ return false;} // data not in tree

        // Internal Nodes
        if (curr.links[0] != null && curr.links[2] != null) {
            Node remove = curr;
            
            // Get the rightmost node of the left child
            curr = curr.links[0];
            while (curr.links[2] != null) { curr = curr.links[2];}

            // remove node by copying over it, remove extra
            removeNode((E)curr.data);
            remove.data = curr.data;
            return true;
        } 

        // External Nodes
        // points parent to curr
        int par = (curr.links[1].links[0] == curr) ? 0 : 2;

        // both children are null, remove parental link
        if (curr.links[0] == null && curr.links[2] == null){
            curr.links[1].links[par] = null;
            return true;
        }

        // 1 child 
        // point to curr's non-null child
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

    public void setHeight(Node curr, int height) {
        curr.height = height;
        if (curr.links[0] != null) {setHeight(curr.links[0], height + 1);}
        if (curr.links[2] != null) {setHeight(curr.links[2], height + 1);}
    }

    public void rotate(Node curr) {
        System.out.println(this);
        if (curr.balance > 1) {
            if (curr.links[2].balance > 0) {singleRotate(curr, 0);}
            else {doubleRotate(curr, 0);}
        } else {
            if (curr.links[0].balance < 0) {singleRotate(curr, 2);}
            else {doubleRotate(curr, 2);} 
        }
        System.out.println("After: \n" + this);
    }

    public void singleRotate(Node curr, int dir) {
        System.out.println("single rotate");
        int other = (dir + 2) % 4; //opposite of dir
   
        Node child = curr.links[other];
        Node gchild = child.links[other];
        Node leaf1 = curr.links[dir];
        Node leaf2 = child.links[dir];
        
        curr.links[other] = leaf2; 
        child.links[dir] = curr;
        child.links[1] = curr.links[1];
        curr.links[1] = child;
        decrementHeight(child);
        curr.height = child.height + 1;
        curr.balance = child.balance = child.links[dir].balance = 0;
        if (leaf1 != null) {setHeight(leaf1, leaf1.links[1].height + 1);}
        if (leaf2 != null) {
            leaf2.links[1] = curr;
            setHeight(leaf2, leaf2.links[1].height + 1);
        }
        if (curr == this.root) {
            this.root = child;
        } else {child.links[1].links[other] = child;}
        if (leaf2 != null) {System.out.println("curr"+leaf2.links[1]);}
    }

    public void doubleRotate(Node curr, int dir) {
        System.out.println("double rotate");
        int other = (dir + 2) % 4; // opposite of dir
        Node child = curr.links[other];
        Node gchild = child.links[dir];
        while (gchild.links[dir] != null) {gchild = gchild.links[dir];}
        gchild.links[1] = curr.links[1];

        gchild.links[dir] = curr;
        curr.links[1] = gchild;

        gchild.links[other] = child;
        child.links[1] = gchild;

        if (child.links[dir] == gchild) {
            child.links[dir] = null;
        } else {child.links[dir].links[dir] = null;}

        curr.links[other] = null;

        gchild.height = curr.height;
        setHeight(curr, gchild.height + 1);
        curr.balance = child.balance = gchild.balance = 0;
        if (curr.links[dir] != null) {curr.links[dir].height = curr.height + 1;}
        if (curr == this.root) {this.root = gchild;}
        else {
            int par = (gchild.links[1].links[0] == curr) ? 0 : 2;
            gchild.links[1].links[par] = gchild;
        }
    }

    // Print sideways with spaces proportional to height. Looks like a tree!
    public String prettyPrint(Node curr) {
        String pre = "";
        // base case
        if (curr == null) {return "";}
        // add appropriate spaces based on node height 
        for (int i = 0; i < curr.height; i++) {
            pre += "      ";
        }
        // Tree rotated counterclockwise. so right children are at the top 
        String s = prettyPrint(curr.links[2]); // right child
        s += pre + curr + "\n";
        s += prettyPrint(curr.links[0]); // leftChild
        return s;
    }
    
    public String toString(){
        return this.prettyPrint(this.root);
    }
}
