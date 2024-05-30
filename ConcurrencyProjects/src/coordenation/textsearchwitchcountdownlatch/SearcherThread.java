package ConcurrencyProjects.src.coordenation.textsearchwitchcountdownlatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class SearcherThread extends Thread{
	private String myText;
	private String textToFind;
	private CyclicBarrier barrier;
	private CountDownLatch latch;
	private int result=-1;

	public SearcherThread(String myText, String textToFind,
						  CyclicBarrier barrier) {
		this.myText = myText;
		this.textToFind = textToFind;
		this.barrier = barrier;
	}

	public SearcherThread(String myText, String textToFind,
						  CountDownLatch latch) {
		this.myText = myText;
		this.textToFind = textToFind;
		this.latch = latch;
	}

	public String getMyText() {
		return myText;
	}

	public int getResult() {
		return result;
	}

//		@Override
//		public void run() {
//			result=myText.indexOf(textToFind);
//			try {
//				barrier.await();
//				System.err.println("Thread finishing at:"+System.currentTimeMillis());
//			} catch (InterruptedException |
//					BrokenBarrierException e) {
//			}
//		}

	@Override
	public void run() {
		result=myText.indexOf(textToFind);
		System.err.println("Thread finishing at:"+System.currentTimeMillis());
		latch.countDown();
	}


}

