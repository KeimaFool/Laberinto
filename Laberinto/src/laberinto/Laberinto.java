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
public class Laberinto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Mensaje de inicio de Usuario
        System.out.println("Bienvenidos Al Algoritmo Destructor de Laberintos!!");
        System.out.println("\n(PORFAVOR EDITE EL ARCHIVO LABERINTO.TXT PARA CREAR SU PROPIO LABERINTO!!)");
        System.out.println("\n('S' PARA EL PUNTO DE INICIO ||| 'F' PARA LA SALIDA)");
        System.out.println("\n(EL NUMERO '0' REPRESENTA UN ESPACIO LIBRE! CUALQUIER OTRO CARACTER SERA UNA PARED!!)");
        System.out.println("\n\n(POR RAZONES DE ORIENTACION,PORFAVOR TENER EL INICIO 'S' EN LAS ESQUINAS DEL LABERINTO!!)");
        
        System.out.println("\n\nAqui Demostraremos como esta resuelto!!: ");
        //Corre el programa
        Navegador solver= new Navegador();
        //Mira si tenia solucion
        if(solver.Recursivo()){
            System.out.println("\nEl Laberinto ha sido resuelto");
        }
        else{
            System.out.println("\nEl Laberinto no tiene salida!!");
        }

    }
    
}
