import java.util.ArrayList;

public abstract class Node {
    ArrayList<String> key;
    Node left;
    Node right;

    public Node(ArrayList<String> item){ 
        this.key = item; 
        this.left = null;
        this.right = null; 
    }
}
