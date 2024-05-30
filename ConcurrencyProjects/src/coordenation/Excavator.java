package ConcurrencyProjects.src.coordenation;

public class Excavator extends Thread{

    private Balance balance;

    public Excavator(Balance balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().toString() + "I started running");
        while(true) {
            try {
                balance.put( Math.random() + 0.1);
                sleep(200);
                System.out.println(Thread.currentThread().toString() + "I'm done");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().toString() +
                        "I've been interrupted");
                break;
            }
        }
    }
}
