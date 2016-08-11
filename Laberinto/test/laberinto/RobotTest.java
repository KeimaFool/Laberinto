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
public class RobotTest {
    
    public RobotTest() {
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
     * Test of Sensor method, of class Robot.
     */
    @Test
    public void testSensor() {
        System.out.println("Sensor");
        Robot instance = new Robot();
        String[] expResult = new String[4];
        expResult[1]="1";
        String[] result = instance.Sensor();
        assertEquals(expResult[1], result[1]);

    }

    /**
     * Test of Move method, of class Robot.
     */
    @Test
    public void testMove() {
        System.out.println("Move");
        String c = "F";
        Robot instance = new Robot();
        instance.Move(c);
        String exp="E";
        String x = instance.getCompass();
        assertEquals(exp,x);
    }

    /**
     * Test of fin method, of class Robot.
     */
    @Test
    public void testFin() {
        System.out.println("fin");
        Robot instance = new Robot();
        boolean expResult = false;
        boolean result = instance.fin();
        assertEquals(expResult, result);

    }


    
}
