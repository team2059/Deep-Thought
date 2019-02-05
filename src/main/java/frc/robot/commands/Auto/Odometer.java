package frc.robot.commands.Auto;

public class Odometer {
    private double x;
    private double y;
    private double prevLeftEncoder;
    private double prevRightEncoder;

    public Odometer() {
        reset();
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void reset() {
        x = 0;
        y = 0;
        prevLeftEncoder = 0;
        prevRightEncoder = 0;
    }

    public void update(double leftEncoder, double rightEncoder, double angle) {
        double dLeftEncoder = leftEncoder - prevLeftEncoder;
        double dRightEncoder = rightEncoder - prevRightEncoder;
        double distance = (dLeftEncoder + dRightEncoder) / 2;

        x += distance * Math.cos(Math.toRadians(angle));
        y += distance * Math.sin(Math.toRadians(angle));

        prevLeftEncoder = leftEncoder;
        prevRightEncoder = rightEncoder;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
