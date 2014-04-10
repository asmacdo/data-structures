public class Node<E extends Comparable<E>> {
    E data;
    int height;
    // array of links to other nodes. right, parent, left 
    Node[] links; 
    
    public Node(E data) {
        this.data = data;  
        this.links = new Node[3];
        this.height = 0;
    }

    public int compareTo(Node<E> other) {
        return this.data.compareTo(other.data);
    }

    public String toString() {
        String s = "";
        return s + this.data;
    }
}
