package ConcurrencyProjects.src.race.simulator.horses;

import javax.swing.*;

public class Horse extends Thread {

    private int percurso;
    private JTextField posicao;

    private Horse[] horses = new Horse[3];

    Horse(int percurso, JTextField posicao) {
        this.percurso = percurso;
        posicao.setText(String.format("%d", percurso));
        this.posicao = posicao;
    }

    public void setRunningHorses(Horse[] horses) {
        this.horses = horses;
    }

    public void resetRace() {
        percurso = 30;
        posicao.setText(String.format("%d", percurso));
    }
    public void run() {
        while( percurso > 0 ) {
            percurso--;
            posicao.setText(String.format("%d", percurso));
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                return;
            }
        }
        if(percurso == 0) {
            for (int i = 0; i < horses.length; i++) {
                if (!horses[i].equals(this)) {
                    horses[i].interrupt();
                }
            }
        }
    }

    public int getPercurso() {
        return percurso;
    }
}
