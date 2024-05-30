package ConcurrencyProjects.src.coordenation.textsearchwitchcountdownlatch;

public class CountDownLatch {

    public CountDownLatch ( int count ) {
        this.count = count ;
    }
    private int count ;

    public synchronized void await ()
            throws InterruptedException {
        while (count >0)
            wait();
    }
    public synchronized void countDown (){
        count --;
        if(count ==0)
            notifyAll ();
    }
}