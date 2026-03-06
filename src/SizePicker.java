import javax.swing.*;
import java.awt.*;

public class SizePicker extends JFrame {

    JTextField widthField = new JTextField("800");
    JTextField heightField = new JTextField("600");
    JTextField boidsField = new JTextField("50");
    JTextField speedField = new JTextField("4");

    public SizePicker() {
        setTitle("Simulation Setup");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton start = new JButton("Start");
        start.addActionListener(e -> launch());

        setLayout(new GridLayout(5, 2, 10, 10));
        add(new JLabel("Width:"));
        add(widthField);
        add(new JLabel("Height:"));
        add(heightField);
        add(new JLabel("Boids:"));
        add(boidsField);
        add(new JLabel("Speed:"));
        add(speedField);
        add(new JLabel());
        add(start);

        setVisible(true);
    }

    private void launch() {
        int w = Integer.parseInt(widthField.getText());
        int h = Integer.parseInt(heightField.getText());
        int n = Integer.parseInt(boidsField.getText());
        double speed = Double.parseDouble(speedField.getText());

        dispose();
        new MainFrame(w, h, n, speed);
    }
}

