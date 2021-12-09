import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michelle Bolger
 * @Date 9/12/2021
 * @Licence GNU General Public License v2.0
 *  the Leaders-Followers problem
 */

/**
 * Creates 4 threads which are added to a thread pool
 * These threads are executed
 */

public class Main {

    // Maximum number of threads in thread pool
    static final int MAX_T = 6;


    /**
     * @param args
     */
    public static void main(String[] args)
    {


        // creates five tasks
        Runnable r1 = new Leaders("A",new Semaphore(0));
        Runnable r2 = new Leaders("B",new Semaphore(0));
        Runnable r3 = new Leaders("C",new Semaphore(0));
        Runnable r4 = new Followers("1",new Semaphore(0));
        Runnable r5 = new Followers("2",new Semaphore(0));
        Runnable r6 = new Followers("3",new Semaphore(0));


        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
        pool.execute(r6);

        // pool shutdown ( Step 4)
        pool.shutdown();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }




    }
}
