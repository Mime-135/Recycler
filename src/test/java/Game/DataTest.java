package Game;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

public class DataTest {
    @BeforeClass
    public static void createB(){
        System.out.println("I execute before the class");
    }

    @After
    public void after(){
        System.out.println("I execute after each class");
    }

    @Before
    public void before(){
        System.out.println("I execute before each class");
    }
    @Test
    public void playIndex() {
        Data dat = new Data();
        int size = 10;
        int[] arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }//Cannot use assert method here because the array is random all the time
        //Print to the console instead for testing
    }

    @Test
    public void easyWordData() {
        Data dat = new Data();
        int size = 5;
        int[] arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        String[] easyPy = dat.EasyWordData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(easyPy[i]);
        }
        //Cannot use assert method here because the array is random all the time
        //Print to the console instead for testing
    }

    @Test
    public void mediumWordData() {
        Data dat = new Data();
        int size = 5;
        int[] arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        String[] easyPy = dat.MediumWordData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(easyPy[i]);
        }
        //Cannot use assert method here because the array is random all the time
        //Print to the console instead for testing
    }

    @Test
    public void hardWordData() {
        Data dat = new Data();
        int size = 5;
        int[] arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        String[] hardPy = dat.HardWordData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(hardPy[i]);
        }
        //Cannot use assert method here because the array is random all the time
        //Print to the console instead for testing
    }

    @Test
    public void easyAnsData() {
        Data dat = new Data();
        int size = 5;
        int[] arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        String[] easyAns = dat.EasyAnsData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(easyAns[i]);
        }//Cannot use assert method here because the array is random all the time
        //Print to the console instead for testing
    }

    @Test
    public void mediumAnsData() {
        Data dat = new Data();
        int size = 5;
        int[] arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        String[] medAns = dat.MediumAnsData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(medAns[i]);
        }//Cannot use assert method here because the array is random all the time
        //Print to the console instead for testing
    }

    @Test
    public void hardAnsData() {
        Data dat = new Data();
        int size = 5;
        int[] arr = dat.playIndex(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        String[] hardAns = dat.HardAnsData(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(hardAns[i]);
        }//Cannot use assert method here because the array is random all the time
        //Print to the console instead for testing
    }

}