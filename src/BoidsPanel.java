import javax.swing.*;
import java.awt.*;

class BoidsPanel extends JPanel {

    BoidsSimulation sim;

    BoidsPanel(BoidsSimulation sim) {
        this.sim = sim;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sim.setBounds(getWidth(), getHeight());

        for (Boid b : sim.boids) {
            int size = (int)(4 + b.position.z / 10);
            int x = (int)b.position.x;
            int y = (int)b.position.y;

            g.fillOval(x, y, size, size);
        }
    }
}
