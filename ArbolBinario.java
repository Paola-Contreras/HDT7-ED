/*  Universidad del Valle de Guatemala 
    Estructura de datos 
    Gabriela Paola Contreras Guerra
    Carné: 20213
    The following class was made with the help of the platform GeekForGeeks and a youtube video made by makigas*/

// import
import java.util.*;

public class ArbolBinario {
    //Atributs 
    Node raiz;

    /**
     * Constructor
     */
    public ArbolBinario(){
        raiz=null;
    }
    /**
     * Method to add a new key
     * @param raiz,key 
     * @return raiz
     */
    public Node GuardarRaiz(Node raiz, ArrayList<String>key){  
        if (raiz == null){
            raiz= new Node(key){}; // creates a new node in case these is empty
            // if the node is not empty it saves a value acording in one of the branches of the tree
        }if (key.get(0).compareTo(raiz.key.get(0))<0){  
            raiz.left = GuardarRaiz(raiz.left, key);
        }else if (key.get(0).compareTo(raiz.key.get(0))>0){
            raiz.right = GuardarRaiz(raiz.right, key);}

        return raiz; // returns the node 
    }

    /**
     * Metod that adds the key 
     * @param key
     */
    public void anadir(ArrayList<String> key){ 
        raiz = GuardarRaiz( raiz, key ); 
    }

    /**
     * Metod to order & show the tree 
     * @param raiz 
     * @return n/a
     */
    public void InOrder( Node raiz ) {
        if ( raiz != null ){
            InOrder(raiz.left);
            System.out.println(raiz.key);
            InOrder(raiz.right);
        }
    }
    /**
     * Metod to show the tree in order 
     */
    public void Ordenado(){
        InOrder(raiz); 
    }
}
