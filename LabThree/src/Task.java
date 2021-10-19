import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Michelle Bolger
 * @Date 19/10/2021
 * @Licence GNU General Public License v2.0
 *
 */
public class Task implements Runnable {


    private String name;
    private static Semaphore first = new Semaphore(0);
    private static Semaphore second = new Semaphore(1);
    private static Semaphore mutex = new Semaphore(1);

    private static int numOfThreads = 0 ;
    private static int count = 0;

    private static int countNumOfThreads = 0;


    /**
     * @param task_1       thread name
     * @param totalThreads number of threads
     */

    public Task(String task_1, int totalThreads) {
        name = task_1;
        numOfThreads = totalThreads;
    }

    /**
     *
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

        System.out.println(countNumOfThreads);

    }

}