package allexamples;

public class DeadLock {


    public static void main(String[] args) {

        String st1 = "test";
        String st2 = "test1";


        Thread t1 = new Thread(() -> {
            synchronized (st1) {
                System.out.println("Thread 1: Has  ObjectLock1");
            /* Adding sleep() method so that
               Thread 2 can lock ObjectLock2 */
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for ObjectLock 2");
            /*Thread 1 has ObjectLock1
              but waiting for ObjectLock2*/
                synchronized (st2) {
                    System.out.println("Thread 1: No DeadLock");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (st2) {
                System.out.println("Thread 2: Has  ObjectLock2");
            /* Adding sleep() method so that
               Thread 1 can lock ObjectLock1 */
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for ObjectLock 1");
            /*Thread 2 has ObjectLock2
              but waiting for ObjectLock1*/
                synchronized (st1) {
                    System.out.println("Thread 2: No DeadLock");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
