package ConcurrencyProjects.src.coordenation.ballpainter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IG {
	ArrayList<Bola> bolas= new ArrayList<>();
	ExecutorService pool = Executors.newFixedThreadPool(6);

	public void addContent(){

		JFrame janela= new JFrame("hh");
		janela.setLayout(new BorderLayout());
		BallPainter painter=new BallPainter();
		janela.add(painter, BorderLayout.CENTER);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CyclicBarrier barrier = new CyclicBarrier(6, new Runnable() {
			@Override
			public void run() {
				pool.shutdown();
			}
		});

		for(int i=0;i<25;i++){
			Bola bola=new Bola(barrier);
			bola.addObserver(painter);
			bolas.add(bola);
			painter.addBall(bola);
		}

		JButton start=new JButton("Start");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO criar ThreadPool. Aqui são simplesmente lançadas as threads.
				for(Bola bola:bolas)
					pool.submit(bola);
			}
		});
		janela.add(start, BorderLayout.SOUTH);
		janela.setSize(800, 600);
		janela.setVisible(true);
	}
	public static void main(String[] args) {
		new IG().addContent();
	}

}
