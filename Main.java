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
    ArbolBinario Ab= new ArbolBinario();
    Scanner scan = new Scanner(System.in);
    ArrayList<String>Data = new ArrayList<>();
    ArrayList<ArrayList<String>> Dic =  new ArrayList<ArrayList<String>>();
    
        try{
            File Info= new File("diccionario.txt");
            Scanner readFile= new Scanner(Info);
            while(readFile.hasNextLine()){
                String Lineas = readFile.nextLine();
                String[] Separa = Lineas.split(",");
                ArrayList<String> Inf_separada = new ArrayList<>();

                // Se declara ciclo for para agregar las palabras separadas por coma.
                for(int i=0;i<Separa.length;i++){
                    Inf_separada.add(Separa[i]); 
                }
                    Dic.add(Inf_separada); 
            }  
        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo");
        }

        try{
            File Info= new File("traduce.txt");
            Scanner readFile= new Scanner(Info);
            while(readFile.hasNextLine()){
                String Lineas = readFile.nextLine();
                String[] Separa = Lineas.split(" ");
                ArrayList<String> Inf_separada = new ArrayList<>();

                // Se declara ciclo for para agregar las palabras separadas por coma.
                for(int i=0;i<Separa.length;i++){
                    Data.add(Separa[i]); 
                }
            }  
        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo");
        }

        for (ArrayList<String> word: Dic){
            Ab.anadir(word);
        }

        System.out.println("Bienvenido a su diccionario");
        System.out.println("Actualmente este es su diccionario");
        Ab.Ordenado();

        while(iniciar== false){
            int opcion= menu();

            if (opcion ==1){
    
                for(int i=0; i<Dic.size(); i++){    
                    for(int k=0; k<Data.size(); k++){
                        if(Dic.get(i).contains(Data.get(k))){
                            Data.set(k, Dic.get(i).get(0));
                        }
                    }
                }

            }if(opcion==2){
    
                for(int i=0; i<Dic.size(); i++){    
                    for(int k=0; k<Data.size(); k++){
                        if(Dic.get(i).contains(Data.get(k))){
                            Data.set(k, Dic.get(i).get(1));
                        }
                    }
                }
    
            }if (opcion==3){

                for(int i=0; i<Dic.size(); i++){    
                    for(int k=0; k<Data.size(); k++){
                        if(Dic.get(i).contains(Data.get(k))){
                            Data.set(k, Dic.get(i).get(2));
                        }
                    }
                }

            }
            // TRADUCCION  
            System.out.println("Su frase ha sido traducida este es el resultado: ");
            



            if (opcion==4){
                iniciar = true;
                System.out.println("Espero que haya tenido una buena experiencia utilizando su diccionario");
            }else{
                System.out.println("UPS Ocurrio un error en la traduccion intente de nuevo");
            }

        }
    }
    public static int menu(){
        int opciones = 5;
        String ops = "";
        boolean validar = true;
        System.out.println("\nSeleccione un idioma");
        System.out.println("1. Ingles");
        System.out.println("2. Espanol");
        System.out.println("3. Frances\n");
        System.out.println("4. Salir\n");
        while(validar == true){
            System.out.println("Ingrese su opcion: ");
            Scanner scan1 = new Scanner(System.in);
            ops = scan1.next();
            opciones = validarNum(ops);
            if(opciones != -1){
                validar = false;
            } else {}
        } return opciones;
    }

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
