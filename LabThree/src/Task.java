import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Michelle Bolger
 * @Date 26/10/2021
 * @Licence GNU General Public License v2.0
 *
 */

/**
 * Using semaphores to create a reusable barrier
 *
 */
public class Task implements Runnable {


    private String name; //Name of threads
    private static Semaphore first = new Semaphore(0);
    private static Semaphore second = new Semaphore(1);
    private static Semaphore mutex = new Semaphore(1); //

    private static int numOfThreads = 0 ;
    private static int count = 0; // keep track of threads arriving

    private static int countNumOfThreads = 0;


    /**
     * Set the current number of threads.
     * @param task_1       thread name
     * @param totalThreads number of threads
     */

    public Task(String task_1, int totalThreads) {
        name = task_1;
        numOfThreads = totalThreads;
    }

    /**The first semaphore is locked and the second semaphore is open, when all the threads have arrived at the first the second is locked
     * and the first semaphore is unlocked.
     * When all the threads then arrive at the second semaphore the first semaphore is relocked.
     * Safe for the threads to loop to beginning and open the second semaphore.
     *
     *Forces all the threads to wait twice - once for all the threads to arrive then again for all the threads to execute the critical section.
     */
    public void run() {



        try {

            mutex.acquire();
            count ++;



            if (count == numOfThreads) {
                second.acquire();
                first.release();

            }

            mutex.release();
            first.acquire();
            first.release();

            //critical point

            System.out.println(name + " complete");
            countNumOfThreads ++;

           mutex.acquire();

            count--;

            if (count == 0) {
                first.acquire();
                second.release();
            }

            mutex.release();

            second.acquire();
            second.release();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // System.out.println(countNumOfThreads);

    }

}