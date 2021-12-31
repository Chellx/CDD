public class Task implements Runnable {

    /**
     *
     * @author Michelle Bolger
     * @Date 31/12/2021
     * @Licence GNU General Public License v2.0
     */


    private Object leftFork;
    private Object rightFork;

    public Task(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            while (true) {

                // thinking
                doAction( " : Thinking");
                synchronized (leftFork) {
                    doAction( " : Picked Up Left Fork");
                    synchronized (rightFork) {
                        // eating
                        doAction( " : Picked Up Right Fork  - Now Eating");

                        doAction( " : Put Down Right Fork");
                    }

                    // Back to thinking
                    doAction( " : Put Down Left Fork - Back To Thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}