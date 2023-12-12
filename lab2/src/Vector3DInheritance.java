public class Vector3DInheritance extends Vector2D{
    protected double z;
    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public double abs() {
        return Math.sqrt(this.getComponents()[0]*this.getComponents()[0] + this.getComponents()[1]*this.getComponents()[1] + this.z * this.z);
    }

    @Override
    public double cdot(IVector iVector) {
        double z_temp = 0;
        double z_temp_iVector = 0;
        if(iVector.getComponents().length == 3) {
            z_temp = this.z;
            z_temp_iVector = iVector.getComponents()[2];
        }
        return this.getComponents()[0] * iVector.getComponents()[0] + this.getComponents()[1]*iVector.getComponents()[1] + z_temp * z_temp_iVector;
    }

    @Override
    public double[] getComponents() {
        return new double[]{
                this.x,
                this.y,
                this.z
        };
    }
    public Vector3DInheritance cross(IVector iVector) {

        double z_temp_iVector = 0;
        if(iVector.getComponents().length == 3) {
            z_temp_iVector = iVector.getComponents()[2];
        }

        //double x = this.y * iVector.getComponents()[2] - this.z * iVector.getComponents()[1];
        double x = this.y * z_temp_iVector - this.z * iVector.getComponents()[1];
        //double y = this.z * iVector.getComponents()[0] - this.x * iVector.getComponents()[2];
        double y = this.z * iVector.getComponents()[0] - this.x * z_temp_iVector;
        double z = this.x * iVector.getComponents()[1] - this.y * iVector.getComponents()[0];

        return new Vector3DInheritance(x, y, z);
    }
    public void setZ(double z) {
        this.z = z;
    }

}
