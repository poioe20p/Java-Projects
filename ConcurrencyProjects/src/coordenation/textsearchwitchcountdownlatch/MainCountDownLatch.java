package ConcurrencyProjects.src.coordenation.textsearchwitchcountdownlatch;

public class MainCountDownLatch {

    static final int NUM_DOCUMENTS_TO_BE_SEARCHED=1000;
    static final int STRING_LENGTH=1024;
    static final String STRING_TO_BE_FOUND="huik";

    public static void main(String[] args) {
        int count = 0;
        final long initTime=System.currentTimeMillis();
        SearcherThread[] threads=new SearcherThread[NUM_DOCUMENTS_TO_BE_SEARCHED];
        CountDownLatch countDownLatch = new CountDownLatch(NUM_DOCUMENTS_TO_BE_SEARCHED);

        RandomString rs=new RandomString(STRING_LENGTH);
        for(int i=0; i!=NUM_DOCUMENTS_TO_BE_SEARCHED;i++){
            threads[i]=new SearcherThread(rs.nextString(),
                    STRING_TO_BE_FOUND, countDownLatch);
            threads[i].start();
        }

        try {
            countDownLatch.await();
            for (SearcherThread t:threads) {
                if(t.getResult()!=-1) {
                    System.out.println("Found at "+t.getResult());//+" in "+t.getMyText());
                    count++;
                }
            }
            System.out.println("Search DONE. Found:"+count+" Time:"+
                    (System.currentTimeMillis()-initTime));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
