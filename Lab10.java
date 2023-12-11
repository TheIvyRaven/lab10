//import java.util.Random;
import java.util.Scanner;

public class Lab10 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        scan.close();
    }

    public static void Q1() 
    {
        while (true)
        {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) 
            {
                return;
            }

            if (input.equals("square")) 
            {
                double s; //changed variable name from a to s for Square.
                System.out.println("Enter the length of side a: ");
                s = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the square is: " + s * 4);
                System.out.println("The area of the square is: " + s * s);

            } else if (input.equals("rectangle")) 
            {
                double rl, rw; //changed variable name from a to rl for Rectangle Length. and b to rw for Rectangle Width.
                System.out.println("Enter the length of the rectangle: "); //changed text to say length of rectangle
                rl = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the width of the rectangle: ");//changed text to say width of rectangle
                rw = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the rectangle is: " + (2 * rl + 2 * rw));
                System.out.println("The area of the rectangle is: " + (rl * rw));
            } 
            else if (input.equals("circle")) 
            {//moved this final else if on its own line to make the code more readable
                double c; //changed variable name from r to c for Circle.
                System.out.println("Enter the radius: ");
                c = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the circle is: " + (Math.PI * c * 2));
                System.out.println("The area of the circle is: " + (Math.PI * c * c));
            }
        }
    }
}
