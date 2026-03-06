class Vector3 {
    double x, y, z;

    Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vector3 add(Vector3 other) {
        double newX = x + other.x;
        double newY = y + other.y;
        double newZ = z + other.z;
        return new Vector3(newX, newY, newZ);
    }

    Vector3 subtract(Vector3 other) {
        double newX = x - other.x;
        double newY = y - other.y;
        double newZ = z - other.z;
        return new Vector3(newX, newY, newZ);
    }

    Vector3 scale(double s) {
        double newX = x * s;
        double newY = y * s;
        double newZ = z * s;
        return new Vector3(newX, newY, newZ);
    }

    double magnitude() {
        double length = Math.sqrt(x * x + y * y + z * z);
        return length;
    }

    Vector3 normalize() {
        double length = magnitude();
        if (length == 0) {
            return new Vector3(0, 0, 0);
        }
        double scaleFactor = 1.0 / length;
        return scale(scaleFactor);
    }
}

