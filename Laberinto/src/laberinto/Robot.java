/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Shin
 */
public class Robot {
    //atributos
    int tam;
    String[] store;
    int[] posicion;
    String compass;
    //Constructor
    public Robot() {
        //Busca el laberinto en un txt y lo mueve a un String[]
        File dir = new File(".");
        try{
        File file = new File(dir.getCanonicalPath()+File.separator + "Laberinto.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
       int counter=0;
       String nult=null;
       while((nult = br.readLine()) != null){
           counter++;
       }
       tam=counter;
       store = new String[counter];
        }
         catch(Exception e){ System.out.println("Archivo no encontrado");}
       
        try{
           File file = new File(dir.getCanonicalPath()+File.separator + "Laberinto.txt");
           BufferedReader br = new BufferedReader(new FileReader(file));
            int counter=0;
            String nult=null;
            while((nult = br.readLine()) != null){
           store[counter]=nult;
           counter++;
       }
    }
        catch(Exception e){ System.out.println("Archivo no encontrado");}
    //Busca en el laberinto el punto de inicio.    
        posicion = new int[3];
        for (int i=0;i<tam;i++){
            int x=store[i].lastIndexOf("S");
            if (x!=-1){
                posicion[0]=x;
                posicion[1]=i;
            }
        }
        //Determina en que orientacion comenzar el laberinto
        compass="N";
        
        if (posicion[0]-1<0){
            compass="E";
        }
        if (posicion[0]+1>store[posicion[1]].length()-1){
            compass="O";
        }
        if (posicion[1]-1<0){
            compass="S";
        }
        //Imprime el laberinto para verlo en la salida
        System.out.println("\nEl Laberinto: ");
        for (int i=0;i<store.length;i++){
            System.out.println(store[i]);
        }
        System.out.println("\n'S' = Start\n'F' = Fin\n\nALGORITMO:");
    }
    //Este metodo mira que hay en los alrededores izquierda derecha y el frente y devuelve el resultado en una matriz
    public String[] Sensor(){
        String[] leer = new String[4];
        int[][] sen = new int[3][2];
        leer[3]=compass;
        //DEPENDIENDO DE LA ORIENTACION VA A REVISAR DIFERENTES POSICIONES
        if (compass.equals("N")){
            sen[0][0]=posicion[0]-1;
            sen[0][1]=posicion[1];
            sen[1][0]=posicion[0];
            sen[1][1]=posicion[1]-1;
            sen[2][0]=posicion[0]+1;
            sen[2][1]=posicion[1];
        }
        else if(compass.equals("E")){
            sen[0][0]=posicion[0];
            sen[0][1]=posicion[1]-1;
            sen[1][0]=posicion[0]+1;
            sen[1][1]=posicion[1];
            sen[2][0]=posicion[0];
            sen[2][1]=posicion[1]+1;
        }
        else if(compass.equals("S")){
            sen[0][0]=posicion[0]+1;
            sen[0][1]=posicion[1];
            sen[1][0]=posicion[0];
            sen[1][1]=posicion[1]+1;
            sen[2][0]=posicion[0]-1;
            sen[2][1]=posicion[1];
        }
        else if(compass.equals("O")){
            sen[0][0]=posicion[0];
            sen[0][1]=posicion[1]+1;
            sen[1][0]=posicion[0]-1;
            sen[1][1]=posicion[1];
            sen[2][0]=posicion[0];
            sen[2][1]=posicion[1]-1;
        }
        //MIRA QUE TIENE LA POSICION. SI ES UN '0' SIGNIFICA QUE ES UN ESPACIO LIBRE Y DA '1'
        for (int i=0;i<3;i++){
            leer[i]="0";
            if (sen[i][0]>=0 && sen[i][0]<store[i].length() && sen[i][1]>=0 && sen[i][1]<store.length){
                if(store[sen[i][1]].charAt(sen[i][0])=='0' || store[sen[i][1]].charAt(sen[i][0])=='F'){
                    leer[i]="1";
                }
            }
        }
        System.out.println("\nSensor: Left-"+leer[0]+" Forward-"+leer[1]+" Right-"+leer[2]+"|| Compass-"+leer[3]);
        return leer;
    }
    //Mueve el carro una posicion a cualquier direccion dependiendo del parametro y su orientacion.
    public void Move(String c){
        if (c.equals("L")){
            if (compass.equals("N")){
                posicion[0]=posicion[0]-1;
                compass="O";
            }
            else if (compass.equals("E")){
                posicion[1]=posicion[1]-1;
                compass="N";
            }
            else if (compass.equals("S")){
                posicion[0]=posicion[0]+1;
                compass="E";
            }
            else if (compass.equals("O")){
                posicion[1]=posicion[1]+1;
                compass="S";
            }
        }
        if (c.equals("F")){
            if (compass.equals("N")){
                posicion[1]=posicion[1]-1;
            }
            else if (compass.equals("E")){
                posicion[0]=posicion[0]+1;
            }
            else if (compass.equals("S")){
                posicion[1]=posicion[1]+1;
            }
            else if (compass.equals("O")){
                posicion[0]=posicion[0]-1;
            }
        }
        if (c.equals("R")){
            if (compass.equals("N")){
                posicion[0]=posicion[0]+1;
                compass="E";
            }
            else if (compass.equals("E")){
                posicion[1]=posicion[1]+1;
                compass="S";
            }
            else if (compass.equals("S")){
                posicion[0]=posicion[0]-1;
                compass="O";
            }
            else if (compass.equals("O")){
                posicion[1]=posicion[1]-1;
                compass="N";
            }
        }
        System.out.println(posicion[0]+" "+posicion[1]);
    }
    //Regresa uno para atras cuando no hay salida
    public void volver(String c){
        if (compass.equals("N")){
            posicion[1]=posicion[1]+1;
        }
        else if (compass.equals("E")){
            posicion[0]=posicion[0]-1;
        }
        else if (compass.equals("S")){
            posicion[1]=posicion[1]-1;
        }
        else if (compass.equals("O")){
            posicion[0]=posicion[0]+1;
        }
        compass=c;
        }

    //Revisa si llego al final
    public boolean fin(){
        char end=store[posicion[1]].charAt(posicion[0]);
        if (end=='F'){
            return true;
        }
        return false;
    }
    
    public String[] getStore() {
        return store;
    }

    public void setStore(String[] store) {
        this.store = store;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    public String getCompass() {
        return compass;
    }

    public void setCompass(String compass) {
        this.compass = compass;
    }
    
    
  
}
