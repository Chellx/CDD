
/**
 *
 * @author Michelle Bolger
 * @Date 31/12/2021
 * @Licence GNU General Public License v2.0
 */



public class Main  {

    public static void main(String[] args) throws Exception {

        final Task[] philosophers = new Task[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {

                // The last philosopher picks up the right fork first
                philosophers[i] = new Task(rightFork, leftFork);
            } else {
                philosophers[i] = new Task(leftFork, rightFork);
            }

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();

            if (philosophers.length == 0 ){
                break;
            }


        }
    }
}
