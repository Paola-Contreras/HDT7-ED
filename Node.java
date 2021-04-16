/*  Universidad del Valle de Guatemala 
    Estructura de datos 
    Gabriela Paola Contreras Guerra
    Carné: 20213*/

//Import
import java.util.ArrayList;

public abstract class Node {
    ArrayList<String> key;
    Node left;
    Node right;

    public Node(ArrayList<String> a){ 
        this.key = a; 
        this.left = null;
        this.right = null; 
    }
}
