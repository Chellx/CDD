import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    // Maximum number of threads in thread pool
    static final int MAX_T = 4;


    /**
     * @param args
     */
    public static void main(String[] args)
    {


        // creates five tasks
        Runnable r1 = new Task("task 1",MAX_T);
        Runnable r2 = new Task("task 2",MAX_T);
        Runnable r3 = new Task("task 3",MAX_T);
        Runnable r4 = new Task("task 4",MAX_T);

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        // pool shutdown ( Step 4)
        pool.shutdown();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      //System.out.println("total is: "+ MAX_T);

    }
}
