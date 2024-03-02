package ConcurrencyProjects.src;

public class NameThread extends Thread {

    public final int id;
    NameThread(int identificador)  {
       id = identificador;
    }

    public void run() {
        for(int i = 1; i != 50; i++) {
            System.out.println("Eu sou a thread: " + id + " esta é a " + i + " linha");
            try {
                sleep(1000+(int)(Math.random()*1000));
            } catch (InterruptedException iE) {
                return;
            }
        }
    }


    public static void main(String[] args) {
        NameThread t1 = new NameThread(1);
        NameThread t2 = new NameThread(2);

        t1.start();
        t2.start();

        try {
            //Ao fazer join a outra thread o programa principal espera pela aquele ao qual foi referenciado
            //Neste caso a thread principal espera pelo t1 e pelo t2
            Thread.sleep(4000);
            t1.interrupt();
            t2.interrupt();

            System.out.println("Terminou o programa");
        } catch (InterruptedException iE) {
            iE.printStackTrace();
        }
    }

}
