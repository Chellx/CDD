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
 */public class Leaders implements Runnable{


    public String leaderName = ""; //Name Of Threads
    public static int leaders = 0;
    public static QueueFIFO leadersQueue = new QueueFIFO();
    Semaphore mutex = new Semaphore(1);
    Semaphore queueSemaphore;
    static Semaphore output = new Semaphore(1);
    public static Semaphore leaderwait = new Semaphore(0);


    public Leaders(String leaderName,Semaphore theSemaphore){
        this.leaderName = leaderName;
        queueSemaphore = theSemaphore;
    }


    @Override
    public void run() {

        try{
            mutex.acquire();

            if(Followers.followers >0){
                Followers.followers --;
                Followers.followersQueue.signalThread();
            }

            else{
                leaders ++;
                mutex.release();
                leadersQueue.wait(queueSemaphore);


            }
            output.acquire();
            System.out.print(leaderName);
            Followers.followerWait.release();
            leaderwait.acquire();
            System.out.println();
            output.release();

            //letter++;
            Followers.rendezvous.acquire();
            mutex.release();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
