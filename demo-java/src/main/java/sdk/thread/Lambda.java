package sdk.thread;

public class Lambda  {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("ds");
        });
        thread.start();
    }
}
