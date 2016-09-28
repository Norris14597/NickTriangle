package TrianglePack;
import static java.lang.System.*;

/**
 * Created by jonathan norris on 9/10/16.
 */
public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c) //constructor
    {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;

    }
    public static boolean notATriangle(double a, double b, double c)
    {
        return !((a + b > c) && (a + c > b) && (c + b > a));
    }
    public void printTriangle(Triangle triangle) //print triangle sides with index for testing
    {
        System.out.println("You've entered: A = " + triangle.getSideA() + " B = " + triangle.getSideB() + " C = " + triangle.getSideC());
    }
    public boolean isEquilateral()
    {
        return ((this.getSideA() == this.getSideB()) && (this.getSideA() == this.getSideC()));
    }
    public boolean isIsosceles()
    {
        return ((this.getSideA() == this.getSideB() && this.getSideA() != this.getSideC()) ||
                (this.getSideA() == this.getSideC() && this.getSideA() != this.getSideB()) ||
                (this.getSideB() == this.getSideC() && this.getSideB() != this.getSideA()));
    }
    public boolean isScalene()
    {
        return (this.getSideA() != this.getSideB() && this.getSideA() != this.getSideC());
    }
    private double getSideA()
    {
        return this.sideA;
    }
    private double getSideB()
    {
        return this.sideB;
    }
    private double getSideC()
    {
        return this.sideC;
    }

}
