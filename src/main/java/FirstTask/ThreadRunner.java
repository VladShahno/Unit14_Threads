package FirstTask;

public class ThreadRunner extends Thread {

    int threadPrio;

    ThreadRunner(String threadName, int threadPrio) {
        super(threadName);
        this.threadPrio = threadPrio;
    }

    public ThreadRunner() {
    }

    public void runThreads() {
        for (int i = 49; i >= 0; i--) {
            ThreadRunner threadRunner = new ThreadRunner("Test Thread", i);
            threadRunner.start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Run by " + Thread.currentThread().getName() + " # " + threadPrio);
    }
}
