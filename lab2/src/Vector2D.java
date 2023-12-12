public class Vector2D implements IVector{
    protected double x;
    protected double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public double abs() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    @Override
    public double cdot(IVector iVector) {
        return this.x * iVector.getComponents()[0] + this.y *iVector.getComponents()[1];
    }

    @Override
    public double[] getComponents() {
        return new double[] {this.x, this.y};
    }
}
