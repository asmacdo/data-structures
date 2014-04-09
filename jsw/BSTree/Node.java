public class Node<E extends Comparable<E>> {
    E data;
    int height;
    Node leftChild;
    Node rightChild;
    
    
    public Node(E data) {
        this.data = data;  
        this.leftChild = null;
        this.rightChild = null;
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
