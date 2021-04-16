/*  Universidad del Valle de Guatemala 
    Estructura de datos 
    Gabriela Paola Contreras Guerra
    Carné: 20213*/

import static org.junit.jupiter.api.Assertions.*;
import java.beans.Transient;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ArbolBinarioTest{
    @Test
    void test(){
        ArrayList<String>key= new ArrayList();
        Node raiz;
        key.add("house");
        try {
            raiz = GuardarRaiz( raiz, key ); 
        }catch(Exception e){
            System.out.println("No se añadio correctamente");
        }
    }
}
