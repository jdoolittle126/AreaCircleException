
package areacircleexception;

import java.util.Scanner;

public class AreaCircleException 
{
    /*
     * I moved the variables into the main function. You don't really need global variables unless they are constants 
     * or you have multiple classes. I would recommend using local variables. I don't think it messed anything up here
     * but having local variables and global variables with the same name can get confusing and isnt good practice.
     */
    
    public static void main(String[] args) {
    	while(true) start();
    }
    
    public static void start() {
    	double x1, y1, x2, y2, radius;
    	
        try {
        	//You can use just one scanner over and over!
        	Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter x1: ");
	        x1 = scanner.nextDouble();
	        System.out.println("Enter x2: ");
	        x2 = scanner.nextDouble();
	        System.out.println("Enter y1: ");
	        y1 = scanner.nextDouble();
	        System.out.println("Enter y2: ");
	        y2 = scanner.nextDouble();
	        
	        radius = findRadius(x1, y1, x2, y2);
	        System.out.println("Area = " + areaCircle(radius));
	        
	        //Don't forget to close ya scanners!
	        scanner.close();
	        System.exit(0);
        } catch (Exception e) {
           foundException(e);
        }
    }
    
    //Find Radius will find the radius and then put that information into the other one
    public static double findRadius (double x1, double y1, double x2, double y2) {
    	/*
    	 * I removed the printing and saved that for the main function
    	 * Its good to keep functions simple and only return what you need,
    	 * so you can use them in other programs if you wanted!
    	 */
    	
    	//Side note this math does not make sense to me, if |dx| != |dy| its not a circle
    	//I think you are going for the area of an ellipse, and that formula is PI*a*b where a is the x radius b is the y radius
    	
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dsquared = dx*dx + dy*dy;
        return Math.sqrt (dsquared);
    } 
    
    // This one takes the area given by findRadius and uses it to calculate the area
    public static double areaCircle(double radius) {
    	//Used Math.PI constant instead of 3.14
        return 2*Math.PI*radius;
    }
    
    public static void foundException(Exception e) {
    	if(e instanceof java.util.InputMismatchException) {
    		System.out.println("Please enter numbers only! Restarting!");
    		main(null);
    	} else {
    		System.out.println("Unknown error! Restarting!");
    	}
    	
    }
    

    

    
}


    

