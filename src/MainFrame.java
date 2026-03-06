import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    BoidsSimulation simulation;
    BoidsPanel panel;

    MainFrame(int width, int height, int boidCount, double maxSpeed) {
        setTitle("Boids Simulation");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        simulation = new BoidsSimulation(boidCount, width, height);
        simulation.Speed = maxSpeed;
        panel = new BoidsPanel(simulation);

        add(panel, BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);

        setVisible(true);

        Timer timer = new Timer(1, e -> {
            simulation.update();
            panel.repaint();
        });
        timer.start();
    }

    public JPanel createControlPanel() {
        JPanel controls = new JPanel(new GridLayout(3, 2));

        JSlider cohesion = createSlider(0, 100, 50);
        JSlider separation = createSlider(0, 100, 100);
        JSlider alignment = createSlider(0, 100, 50);

        cohesion.addChangeListener(e ->
                simulation.cohesion = cohesion.getValue() / 100.0
        );
        separation.addChangeListener(e ->
                simulation.separation = separation.getValue() / 100.0
        );
        alignment.addChangeListener(e ->
                simulation.alignment = alignment.getValue() / 100.0
        );

        controls.add(new JLabel("Cohesion"));
        controls.add(cohesion);
        controls.add(new JLabel("Separation"));
        controls.add(separation);
        controls.add(new JLabel("Alignment"));
        controls.add(alignment);

        return controls;
    }

    public JSlider createSlider(int min, int max, int value) {
        JSlider s = new JSlider(min, max, value);
        s.setMajorTickSpacing(50);
        s.setMinorTickSpacing(10);
        s.setPaintTicks(true);
        return s;
    }
}



