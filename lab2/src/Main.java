import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vector2D vectorUsedByAdapter = new Vector2D(2,1);
        Vector2D vectorUsedBtDecorator = new Vector2D(2,5);

        Polar2DAdapter polar2DAdapter = new Polar2DAdapter(vectorUsedByAdapter);
        Vector3DDecorator vector3DDecorator = new Vector3DDecorator(vectorUsedBtDecorator, 5);
        Vector3DInheritance vector3DInheritance = new Vector3DInheritance(3, 7, 4);

        System.out.println("2D: " + doubleArrayToString(polar2DAdapter.getComponents()));

        System.out.printf("2D polar: ( %.3f , %.3f )%n", polar2DAdapter.abs(), polar2DAdapter.getAngle());
        System.out.println("3D inheritance: " + doubleArrayToString(vector3DInheritance.getComponents()));
        System.out.println("3D decorator: " + doubleArrayToString(vector3DDecorator.getComponents()));


        System.out.println("\nmethod cross");
        Vector3DDecorator crossProductA = vector3DDecorator.cross(vector3DDecorator);
        System.out.println("vector3DDecorator cross vector3DDecorator = " + doubleArrayToString(crossProductA.getComponents()));

        //Vector3DInheritance crossProductC = vector3DInheritance.cross(polar2DAdapter);
        //System.out.println("vector3DInheritance cross polar2DAdapter = " + doubleArrayToString(crossProductC.getComponents()));

        Vector3DDecorator crossProductD = vector3DDecorator.cross(polar2DAdapter);
        System.out.println("Vector3DDecorator cross polar2DAdapter = " + doubleArrayToString(crossProductD.getComponents()));

        Vector3DDecorator crossProductB = vector3DDecorator.cross(vector3DInheritance);
        System.out.println("vector3DDecorator cross vector3DInheritance = " + doubleArrayToString(crossProductB.getComponents()));
        System.out.println("\nmethod cdot");
        System.out.println("polar2DAdapter * polar2DAdapter = " + polar2DAdapter.cdot(polar2DAdapter));
        System.out.println("vector3DInheritance * polar2DAdapter = " + vector3DInheritance.cdot(polar2DAdapter));
        System.out.println("vector3DDecorator * polar2DAdapter = " + vector3DDecorator.cdot(polar2DAdapter));
        //System.out.println("vector3DDecorator * vector3DDecorator = " + vector3DDecorator.cdot(vector3DDecorator));
        System.out.println("vector3DInheritance * vector3DInheritance = " + vector3DInheritance.cdot(vector3DInheritance));


    }

    static String doubleArrayToString(double[] array){
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}