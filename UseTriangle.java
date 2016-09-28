package TrianglePack;
import static java.lang.System.*;
import java.util.Scanner;

/**
 * Created by jonathan norris on 9/10/16.
 */
public class UseTriangle {
    public static String continueTriangle(String proceed, Scanner in)//quite or keep entering triangles
    {
        boolean err = true;
        do
        {
            if (proceed.equals("Y"))
                err = false;
            else if (proceed.equals("N"))
                err = false;

            if (err == true)
            {
                System.out.println("Error in entry. Press \'Y\' to proceed or \'N\' to exit");
                proceed = in.nextLine();
            }
        }
        while (err == true);
        return proceed; //finished with Y or N
    }
    public static void main(String[] args) {
        String cont = "";
        String triType = "";
        double triSides[] = {0, 0, 0};
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the place where all the triangle fun is.");
        do {

            boolean confirmSides = false;
            boolean badTriangle = true;
            boolean charEntered = false;
            do {
                System.out.println("");
                System.out.println("Input three positive numbers(integer or decimal).");
                for (int i = 0; i < 3; i++)//take three sides from user
                {
                    while (!confirmSides)
                    {
                        try {
                            triSides[i] = Double.parseDouble(input.next()); //confirm triangle sides are double-negative values dealt in isProperTriangle

                        } catch (NumberFormatException nfe) {
                            System.out.println("Error in entry. Enter a number and not a character.");
                        }
                        finally
                        {
                            if (triSides[i] <= 0) {
                                System.out.println("Error in entry. Enter a positive number.");
                                continue;//redo entry if 0 or negative
                            }
                            else
                                confirmSides = true;//exit while loop
                        }
                    } //end while confirmSides
                    confirmSides = false; //reset to continue to next double
                    if (i == 2) //redo triangle if not proper triangle
                    {
                        badTriangle = Triangle.notATriangle(triSides[i - 2], triSides[i - 1], triSides[i]);

                        if (badTriangle == true) {
                            System.out.println("");
                            System.out.println("The sides entered do not create a proper triangle. Please try again.");
                        }
                    }
                }
            }
            while (badTriangle == true);

            String garbage = input.nextLine(); //store /n character- will stop entry error

            Triangle triangle1 = new Triangle(triSides[0], triSides[1], triSides[2]);//create initial triangle object

            if (triangle1.isEquilateral())
                triType = "equilateral";
            else if (triangle1.isIsosceles())
                triType = "isosceles";
            else
                triType = "scalene";

            System.out.println("This is a(n) " + triType + " triangle. Thank you for our using our program.");
            System.out.println("");
            System.out.println("Would you like to create another triangle.");
            System.out.println("Enter \'Y\' to continue or \'N\' to exit.");
            cont = input.nextLine().toUpperCase();//user continue program
            cont = UseTriangle.continueTriangle(cont, input);//continue continue until Y or N
        }
        while (cont.equals("Y"));

        System.out.println("Thank you for our using our program.");
    }
}
