import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Michelle Bolger
 * @Date 9/12/2021
 * @Licence GNU General Public License v2.0
 *
 */

/**
 *
 *
 */public class Followers implements Runnable {

    public String followerName = ""; //Name Of Threads
    public static QueueFIFO followersQueue = new QueueFIFO();
    Semaphore mutex = new Semaphore(1);
    static Semaphore rendezvous = new Semaphore(0);
    public static int followers = 0;

    Semaphore queueSemaphore;

    public static Semaphore followerWait = new Semaphore(0);
    static Semaphore output = new Semaphore(1);


    public Followers(String followerName, Semaphore theSemaphore){
        this.followerName = followerName;
        queueSemaphore = theSemaphore;
    }


    @Override
    public void run() {

        try{
            mutex.acquire();

            if(Leaders.leaders >0){
                Leaders.leaders --;
                Leaders.leadersQueue.signalThread();
            }

            else{
                followers ++;
                mutex.release();
                followersQueue.wait(queueSemaphore);
            }

            output.acquire();
            System.out.print(followerName);
            Leaders.leaderwait.release();
            followerWait.acquire();
            output.release();

            rendezvous.release();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}