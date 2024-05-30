package ConcurrencyProjects.src.coordenation;

import javax.swing.*;
import java.awt.*;

public class BalanceUI extends JFrame {

    JButton button = new JButton("Stop");

    public BalanceUI(JTextField weightField) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setTitle("Balance");
        setLayout(new GridLayout(2,1));
        add(weightField);
        add(button);
        setVisible(true);
    }

    public void setStopButtonAction(Excavator excavator, Goldsmith goldsmith) {
        button.addActionListener(e -> {
            excavator.interrupt();
            goldsmith.interrupt();
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Balance balance = new Balance();
        BalanceUI balanceUI = new BalanceUI(balance.getTextField());
        Excavator excavator = new Excavator(balance);
        Goldsmith goldsmith = new Goldsmith(balance);
        balanceUI.setStopButtonAction(excavator, goldsmith);
        excavator.start();
        goldsmith.start();
        excavator.join();
        goldsmith.join();
    }
}
