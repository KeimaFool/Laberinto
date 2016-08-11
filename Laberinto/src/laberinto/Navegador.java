/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

/**
 *
 * @author Shin
 */
public class Navegador {
    //atributos
    private Mapa mapa;
    private Robot rob;
    private String[] space;
//constructor
    public Navegador() {
        mapa=new Mapa();
        rob=new Robot();
    }
    //El algoritmo para resolverlo. Es recursivo y se llama a si mismo.
    public boolean Recursivo(){
        //Llama al sensor para ver el alrededor
        space=rob.Sensor();
        //Si se encuentra en la posicion del final regresa true
        if (rob.fin()){
            return true;
        }
        //Si no hay salida regresa false
        if (space[0].equals("0") && space[1].equals("0") && space[2].equals("0")){
            return false;
        }
        //si la izquierda esta abierta, convierte ese valor en cero y se vuelve a llamar
        if (space[0].equals("1")){
            space[0]="0";
            mapa.pushLista(space);
            System.out.println("\nMover: Izquierda");
            rob.Move("L");
            if(Recursivo()){
                return true;
            }
            else{
                //si no hay nada, se jala el valor de la pila y continua.
                space=mapa.popLista();
                System.out.println("\nRegresar");
                rob.volver(space[3]);
            }
        }
        //si la del frente esta abierta, convierte ese valor en cero y se vuelve a llamar
        if (space[1].equals("1")){
            space[1]="0";
            mapa.pushLista(space);
            System.out.println("\nMover: Al Frente");
            rob.Move("F");
            if(Recursivo()){
                return true;
            }
            else{
                space=mapa.popLista();
                System.out.println("\nRegresar");
                rob.volver(space[3]);
            }
        }
        //si la derecha esta abierta, convierte ese valor en cero y se vuelve a llamar
        if (space[2].equals("1")){
            space[2]="0";
            mapa.pushLista(space);
            System.out.println("\nMover: Derecha");
            rob.Move("R");
            if(Recursivo()){
                return true;
            }
            else{
                space=mapa.popLista();
                System.out.println("\nRegresar");
                rob.volver(space[3]);
            }
        }
        
        return false;
    }
    
}
