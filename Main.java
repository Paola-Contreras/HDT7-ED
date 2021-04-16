/*  Universidad del Valle de Guatemala 
    Estructura de datos 
    Gabriela Paola Contreras Guerra
    Carné: 20213*/

//Imports
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException{ 
    
    // Atributes 
    Boolean iniciar= false;
    String message="";
    ArbolBinario Ab= new ArbolBinario();
    Scanner scan = new Scanner(System.in);
    ArrayList<String>Data = new ArrayList<>();
    ArrayList<ArrayList<String>> Dic =  new ArrayList<ArrayList<String>>();
    
    // READ FILES 
    // Try & Catch that reads the dictionary and save it on an array separate by , 
        try{
            File Info= new File("diccionario.txt");
            Scanner readFile= new Scanner(Info);
            while(readFile.hasNextLine()){
                String Lineas = readFile.nextLine();
                String[] Separa = Lineas.split(","); 
                ArrayList<String> Inf_separada = new ArrayList<>(); // temporary array to save the words separate

                for(int i=0;i<Separa.length;i++){
                    Inf_separada.add(Separa[i]);  
                }
                    Dic.add(Inf_separada); // adds to the array of dictionary the words
            }  
        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo");
        }
        // Try & Catch to read the file with the phrase to be translate 
        try{
            File Info= new File("traduce.txt");
            Scanner readFile= new Scanner(Info);
            while(readFile.hasNextLine()){
                String Lineas = readFile.nextLine();
                String[] Separa = Lineas.split(" ");
                ArrayList<String> Inf_separada = new ArrayList<>();

                for(int i=0;i<Separa.length;i++){
                    Data.add(Separa[i]); // add the words to the array of data 
                }
            }  
        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo a traducir");
        }
        // Cycle to add the words to the tree 
        for (ArrayList<String> word: Dic){
            Ab.anadir(word);
        }

        // Dictionary order by the Eanglish root 
        System.out.println("--------- Bienvenido a su diccionario ------\n");
        System.out.println("* Actualmente este es su diccionario");
        Ab.Ordenado();

        //Cycle to allow the user choose a lenguaje 
        while(iniciar== false){
            int opcion= menu();
            // Option 1 Eanglish 
            if (opcion ==1){
    
                for(int i=0; i<Dic.size(); i++){    
                    for(int k=0; k<Data.size(); k++){
                        if(Dic.get(i).contains(Data.get(k))){
                            Data.set(k, Dic.get(i).get(0));
                        }
                    }
                }
            // Oprion 2 Spanish 
            }if(opcion==2){
    
                for(int i=0; i<Dic.size(); i++){    
                    for(int k=0; k<Data.size(); k++){
                        if(Dic.get(i).contains(Data.get(k))){
                            Data.set(k, Dic.get(i).get(1));
                        }
                    }
                }
            // Option 3 French 
            }if (opcion==3){

                for(int i=0; i<Dic.size(); i++){    
                    for(int k=0; k<Data.size(); k++){
                        if(Dic.get(i).contains(Data.get(k))){
                            Data.set(k, Dic.get(i).get(2));
                        }
                    }
                }

            }
            
        // TRANSLATE  
            System.out.println("TRADUCCION DE LA FRASE ");
            Data.set(Data.size()-1,(Data.get(Data.size()-1)));
            
                for(int i=0; i< Data.size(); i++){
                    message += (Data.get(i)+" ");
                }
                System.out.println("\nEsta es la traduccion de la frase \n");    
                System.out.println(message);

            // Breaks the cycle 
            if (opcion==4){
                iniciar = true;
                System.out.println("Espero que haya tenido una buena experiencia utilizando su diccionario");
            }
        }
    }

  /**
   * Method to show the user a menu so he/she can choose a lenguaje 
   * @return opciones
   */ 
    public static int menu(){
        int opciones = 4;
        String ops = "";
        boolean validar = true;
        Scanner scan1 = new Scanner(System.in);
        System.out.println("\nSeleccione un idioma");
        System.out.println("1. Ingles");
        System.out.println("2. Espanol");
        System.out.println("3. Frances");
        System.out.println("4. Salir\n");
        while(validar == true){
            System.out.println("Ingrese su opcion: ");
            ops = scan1.next();
            opciones = validarNum(ops);
            if(opciones != -1){
                validar = false;
            } else {}
        } return opciones;
    }

    /**
     * Method tha valid the number 
     * @param rawNumero
     * @return numInt
     */
    public static int validarNum (String rawNumero) {
        int numInt = -1;
        try {
            numInt = Integer.parseInt(rawNumero);
        }catch (NumberFormatException e){
           System.out.println( "\nIngrese un numero valido" );
        }
        return numInt;
    }
}
