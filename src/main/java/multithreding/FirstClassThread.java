package multithreding;

public class FirstClassThread extends Thread {
    @Override
    public void run() { // не start()
        System.out.println("Hello from new thread !!!!");
    }
}
