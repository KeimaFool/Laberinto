/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.util.*;

/**
 *
 * @author Shin
 */
public class Mapa {
    private List<String> estados;
    
    public Mapa(){
        estados= new ArrayList<>();
    }
    //empuja valores dentro de la lista
    public void pushLista(String[] x){
        String y=x[0]+" "+x[1]+" "+x[2]+" "+x[3];
        estados.add(y);
    }
    //saca y borra un valor en la lista.
    public String[] popLista(){
        int dir = estados.size();
        dir=dir -1;
        String y = estados.remove(dir);
        String[] x= y.split(" ");
        return x;
    }
}
