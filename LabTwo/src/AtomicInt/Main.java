package AtomicInt;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michelle Bolger
 * @Date 16/10/2021
 * @Licence GNU General Public License v2.0
 */

/**
 * Creates 4 threads which are added to a thread pool
 * These threads are executed
 * Total shows number of times threads have executed
 */

public class Main {

    // Maximum number of threads in thread pool
    static final int MAX_T = 4;
    /**
     * @param args
     */

    public static void main(String[] args)
    {
        AtomicInteger atomicTotal = new AtomicInteger(0);
        // creates five tasks
        Runnable r1 = new Task("task 1",atomicTotal);
        Runnable r2 = new Task("task 2",atomicTotal);
        Runnable r3 = new Task("task 3",atomicTotal);
        Runnable r4 = new Task("task 4",atomicTotal);

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
            Logger.getLogger(LabTwo.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("total is: "+atomicTotal.intValue());
    }
}