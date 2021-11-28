/**
 *
 * @author Michelle Bolger
 * @Date 28/11/2021
 * @Licence GNU General Public License v2.0
 * A solution to the producers-consumers problem.
 * The solution must be implemented as one or more Java classes that utilises only semaphores
 */
public class Main {


    public static void main(String args[])
    {
        // creating buffer queue
        Queue theQueue = new Queue();

        //  consumer thread
      Consumer theConsumer =   new Consumer(theQueue);

        // producer thread
       Producer theProduce =  new Producer(theQueue);
    }
}
