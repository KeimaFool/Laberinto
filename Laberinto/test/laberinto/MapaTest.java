/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shin
 */
public class MapaTest {
    
    public MapaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of popLista method, of class Mapa.
     */
    @Test
    public void testPopLista() {
        System.out.println("popLista");
        Mapa instance = new Mapa();
        String[] x = new String[4];
        x[0]="s";
        instance.pushLista(x);
        String[] expResult = x;
        String[] result = instance.popLista();
        assertEquals(expResult[0], result[0]);

    }
    
}
