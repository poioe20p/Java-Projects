package ConcurrencyProjects.src.race.simulator.horses;

import javax.swing.*;
import java.awt.*;

public class HorseRacingSimulator extends JFrame {

    HorseRacingSimulator() {

        setLayout(new GridLayout(2,1));

        JButton iniciar = new JButton("Inicia");
        JPanel posicoes = new JPanel(new GridLayout(1, 3));

        JTextField posicaoC1 = new JTextField("30");
        JTextField posicaoC2 = new JTextField("30");
        JTextField posicaoC3 = new JTextField("30");

        posicoes.add(posicaoC1);
        posicoes.add(posicaoC2);
        posicoes.add(posicaoC3);

        add(posicoes);


        iniciar.addActionListener(e -> {
            Horse[] horses = new Horse[3];
            Horse c1 = new Horse(30, posicaoC1);
            Horse c2 = new Horse(30, posicaoC2);
            Horse c3 = new Horse(30, posicaoC3);
            horses[0] = c1;
            horses[1] = c2;
            horses[2] = c3;
            c1.setRunningHorses(horses);
            c2.setRunningHorses(horses);
            c3.setRunningHorses(horses);
            if (c1.getPercurso() != 30 || c2.getPercurso() != 30 || c3.getPercurso() != 30) {
                c1.resetRace();
                c2.resetRace();
                c3.resetRace();
            }
            c1.start();
            c2.start();
            c3.start();
        });

        add(iniciar);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }


    public static void main(String[] args) {

        HorseRacingSimulator horseRacingSimulator =
                new HorseRacingSimulator();
    }
}
