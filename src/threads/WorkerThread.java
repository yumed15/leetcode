package threads;

public class WorkerThread implements Runnable {
    private final String message;

    public WorkerThread(String s){
        this.message=s;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        doSomething();
        System.out.println(Thread.currentThread().getName() + " (End)");
    }
    private void doSomething() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
