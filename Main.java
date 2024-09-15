
/* Devlyn Galvan
 * 9/09/2024
 * SDEV200
 * Create a program to get different sides of a triangle and information about the color and opacity of the triangle then display that information to the user as well as the perimeter and area
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner to get triangle sides
        Scanner userTriangle = new Scanner(System.in);

        double side1, side2, side3;
        String triangleColor;
        boolean filled;

        // Prompting user and getting data
        System.out.println("Enter Side 1 : ");
        side1 = userTriangle.nextDouble();

        System.out.println("Enter Side 2 : ");
        side2 = userTriangle.nextDouble();

        System.out.println("Enter Side 3 : ");
        side3 = userTriangle.nextDouble();

        // Getting color from user
        System.out.println("Enter color of the triangle: ");
        triangleColor = userTriangle.next();

        // Getting information on triangle being filled or not
        System.out.println("Is the triangle filled? (true/false): ");
        filled = userTriangle.nextBoolean();

        // Creating Triangle object with user input
        Triangle triangle = new Triangle(side1, side2, side3);
        GeometricObject triangleDesign = new GeometricObject(triangleColor, filled);
        triangleDesign.setColor(triangleColor);
        triangleDesign.setFilled(filled);

        //printing out triangle
        System.out.println("The area of the triangle is: " + triangle.getArea());
        System.out.println("The perimeter of the triangle is: " + triangle.getPerimeter());
        System.out.println("The color of the triangle is: " + triangleDesign.getColor());
        System.out.println("Is the triangle filled? " + triangleDesign.isFilled());

        //closing scanner
        userTriangle.close();

    }
}
/* This section is based primarily off the code in secion 11.2 of the book minus the section on the date created section of that code*/
class GeometricObject {

    private String color;
    private boolean filled;

    public GeometricObject() {
        this.color = "White";
        this.filled = false;

        
    }

    public GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }
    
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public boolean isFilled() {
        return filled;
    }
    
    public String toString() {
        return "Color: " + color + " Filled: " + filled;
    }
}

// this class stores the different sides of the triangle and does calculations based off those sides
class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        // using default values for a pythagorean triangle
        this.side1 = 3.0;
        this.side2 = 4.0;
        this.side3 = 5.0;
    }

    // constructor that creates a triangle with specific sides
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    // accessor methods for each side
    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    // Calculating the area of a triangle
    public double getArea() {
        double s = getPerimeter() / 2; // getting the value of s
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // returning the area
    }

    // getting the perimeter of the triangle
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

}