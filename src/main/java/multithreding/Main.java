package multithreding;

public class Main {
    public static void main(String[] args)  {
        Counter counter = new Counter();

        for (int i=0;i<5;i++){
            Thread thread = new Thread(new SecondClassThread(counter));
            thread.start();
        }
    }
}
