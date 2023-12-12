public class Polar2DAdapter implements IAdapter2D, IVector{
    private Vector2D srcVector;

    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }
    @Override
    public double getAngle() {
        double[] u = {1.0, 0.0};
        double crossProduct = u[0] * this.srcVector.getComponents()[0] - u[1] *  this.srcVector.getComponents()[1];
        double dotProduct = u[0] *  this.srcVector.getComponents()[0] + u[1] *  this.srcVector.getComponents()[1];

        double theta = Math.atan2(Math.abs(crossProduct), dotProduct);

        return theta;

    }

    @Override
    public double abs() {
        return this.srcVector.abs();
    }

    @Override
    public double cdot(IVector iVector) {
        return this.srcVector.cdot(iVector);
    }

    @Override
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }
}
