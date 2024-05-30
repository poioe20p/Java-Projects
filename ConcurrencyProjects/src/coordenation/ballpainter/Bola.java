package ConcurrencyProjects.src.coordenation.ballpainter;

import ConcurrencyProjects.src.coordenation.ballpainter.DrawableBall;

import java.awt.Color;
import java.util.Observable;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bola extends Observable implements DrawableBall, Runnable {
	private float estado=0;
	private Color color=new Color((int)(Math.random()*256),
			(int)(Math.random()*256), (int)(Math.random()*256));

	private CyclicBarrier barrier;

	public Bola(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		while(!bolaAtingiuLimite()) {
			estado += (float) ((Math.random() * 0.1) + 0.01);
			setChanged();
			notifyObservers();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		try {
			barrier.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean bolaAtingiuLimite(){
		return estado>=1;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public float getX() {
		return estado;
	}

	@Override
	public int getSize() {
		return 10;
	}

}
