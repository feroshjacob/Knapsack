package edu.kennesaw.aa;

public class TimeMachine {

    private static long start = 0;
    public static void track(){
        start = System.nanoTime();
    }
    public static void printTime(){
        long end = System.nanoTime();
        long duration =  end- start;
        System.out.println("Execution time " + duration);
    }


}
