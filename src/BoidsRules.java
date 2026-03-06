import java.util.List;

class BoidsRules {

    Vector3 cohesion(Boid b, List<Boid> boids, double radius) {
        Vector3 center = new Vector3(0, 0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != b &&
                    b.position.subtract(other.position).magnitude() < radius) {
                center = center.add(other.position);
                count++;
            }
        }

        if (count == 0) return new Vector3(0, 0, 0);
        center = center.scale(1.0 / count);
        return center.subtract(b.position).normalize();
    }

    Vector3 separation(Boid b, List<Boid> boids, double minDist) {
        Vector3 force = new Vector3(0, 0, 0);

        for (Boid other : boids) {
            double dist = b.position.subtract(other.position).magnitude();
            if (other != b && dist < minDist && dist > 0) {
                force = force.add(b.position.subtract(other.position));
            }
        }

        return force.normalize();
    }

    Vector3 alignment(Boid b, List<Boid> boids, double radius) {
        Vector3 avgVel = new Vector3(0, 0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != b &&
                    b.position.subtract(other.position).magnitude() < radius) {
                avgVel = avgVel.add(other.velocity);
                count++;
            }
        }

        if (count == 0) return new Vector3(0, 0, 0);
        return avgVel.scale(1.0 / count).normalize();
    }
}

