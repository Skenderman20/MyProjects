import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BoidsSimulation {

    List<Boid> boids = new ArrayList<>();
    BoidsRules rules = new BoidsRules();

    int width, height;
    double depth = 50;

    double cohesion = 0.5;
    double separation = 1.0;
    double alignment = 0.5;

    double neighborRadius = 60;
    double separationDist = 20;
    double Speed = 4;


    void setBounds(int width, int height) {
        this.width = width;
        this.height = height;
    }

    BoidsSimulation(int count, int width, int height) {
        this.width = width;
        this.height = height;

        Random r = new Random();

        for (int i = 0; i < count; i++) {
            boids.add(new Boid(
                    new Vector3(
                            r.nextDouble() * width,
                            r.nextDouble() * height,
                            r.nextDouble() * depth
                    ),
                    new Vector3(
                            r.nextDouble() * 2 - 1,
                            r.nextDouble() * 2 - 1,
                            r.nextDouble() * 2 - 1
                    )
            ));
        }
    }

    void update() {
        for (Boid b : boids) {
            Vector3 v1 = rules.cohesion(b, boids, neighborRadius).scale(cohesion);
            Vector3 v2 = rules.separation(b, boids, separationDist).scale(separation);
            Vector3 v3 = rules.alignment(b, boids, neighborRadius).scale(alignment);

            b.velocity = b.velocity.add(v1).add(v2).add(v3);

            if (b.velocity.magnitude() > Speed) {
                b.velocity = b.velocity.normalize().scale(Speed);
            }

            b.position = b.position.add(b.velocity);

            bounce(b);

        }
    }

    void bounce(Boid b) {
        int r = 6;

        if (b.position.x < r) {
            b.position.x = r;
            b.velocity.x *= -1;
        }
        if (b.position.x > width - r) {
            b.position.x = width - r;
            b.velocity.x *= -1;
        }

        if (b.position.y < r) {
            b.position.y = r;
            b.velocity.y *= -1;
        }
        if (b.position.y > height - r) {
            b.position.y = height - r;
            b.velocity.y *= -1;
        }

        if (b.position.z < 0) {
            b.position.z = 0;
            b.velocity.z *= -1;
        }
        if (b.position.z > depth) {
            b.position.z = depth;
            b.velocity.z *= -1;
        }
    }


}


