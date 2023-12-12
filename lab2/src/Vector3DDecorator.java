public class Vector3DDecorator implements IVector{

    private IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }


    @Override
    public double abs() {
        return Math.sqrt(this.srcVector.getComponents()[0]*this.srcVector.getComponents()[0] + this.srcVector.getComponents()[1]*this.srcVector.getComponents()[1] + this.z * this.z);
    }

    @Override
    public double cdot(IVector iVector) {
        double z_temp = 0;
        double z_temp_iVector = 0;
        if(iVector.getComponents().length == 3) {
            z_temp = this.z;
            z_temp_iVector = iVector.getComponents()[2];
        }
        return this.srcVector.getComponents()[0] * iVector.getComponents()[0] + this.srcVector.getComponents()[1]*iVector.getComponents()[1] + z_temp * z_temp_iVector;
    }

    @Override
    public double[] getComponents() {
        return new double[]{
                this.srcVector.getComponents()[0],
                this.srcVector.getComponents()[1],
                this.z
        };
    }
    public Vector3DDecorator cross(IVector iVector) {
        double z_temp_iVector = 0;
        if(iVector.getComponents().length == 3) {

            z_temp_iVector = iVector.getComponents()[2];
        }
        //double x = this.getComponents()[1] * iVector.getComponents()[2] - this.z * iVector.getComponents()[1];
        //double y = this.z * iVector.getComponents()[0] - this.getComponents()[0] * iVector.getComponents()[2];
        //double z = this.getComponents()[0] * iVector.getComponents()[1] - this.getComponents()[1] * iVector.getComponents()[0];

        double x = this.getComponents()[1] * z_temp_iVector - this.getComponents()[2] * iVector.getComponents()[1];
        double y = this.getComponents()[2] * iVector.getComponents()[0] - this.getComponents()[0] * z_temp_iVector;
        double z = this.getComponents()[0] * iVector.getComponents()[1] - this.getComponents()[1] * iVector.getComponents()[0];
        IVector temp2D = new Vector2D(x, y);
        return new Vector3DDecorator(temp2D, z);
    }
    public void setZ(double z) {
        this.z = z;
    }
    public IVector getSrcV() {
        return this.srcVector;
    }
}
