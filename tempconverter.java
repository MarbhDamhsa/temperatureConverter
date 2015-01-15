package tempconverter;

import java.math.*;
import java.util.Scanner;

public class MainApp {

    public static BigDecimal centigrade2Fahrenheit(double celsius, int roundScale) {
        BigDecimal cconvert = new BigDecimal((celsius * 9) / 5 + 32);
        cconvert = cconvert.setScale(roundScale, RoundingMode.HALF_UP);
        return cconvert;
    }

    public static BigDecimal Fahrenheit2centigrade(double fahrenheit, int roundScale) {
        BigDecimal fconvert = new BigDecimal((fahrenheit - 32) * 5 / 9);
        fconvert = fconvert.setScale(roundScale, RoundingMode.HALF_UP);
        return fconvert;
    }

    public static void main(String[] args) {
        String choice = "n";
        double minimum = 0;
        double maximum = 100;
        int roundScale = 2;
        int answer;
        double fahrenheit;
        double celsius;
        while (choice.equalsIgnoreCase("n")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Temperature Conversion Program: Please select from the following or any other number to exit");
            System.out.println("(1) Convert Fahrenheit to Celsius");
            System.out.println("(2) Convert Celsius to Fahrenheit");
            answer = sc.nextInt();
            

            if (answer < 1 || answer > 2) {
                continue;
            }

            System.out.print("Please enter the lower value of the Temperature Range: ");
            minimum = sc.nextDouble();
            System.out.print("Please enter the upper value of the Temperature Range: ");
            maximum = sc.nextDouble();
            System.out.print("Please enter rounding scale (default 2): ");
            roundScale = sc.nextInt();

            if (answer == 1) {
                while (true) {
                    System.out.print("Please enter Fahrenheit temperature to convert to Celsius: ");
                    fahrenheit = sc.nextDouble();
                    if (fahrenheit <= maximum && fahrenheit >= minimum) {
                        break;
                    }
                }
                BigDecimal fconvert = Fahrenheit2centigrade(fahrenheit, roundScale);
                System.out.println(+fahrenheit + "F" + " = " + fconvert + "C");
            } else {
                while (true) {
                    System.out.print("Please enter Celsius temperature to convert to Fahrenheit: ");
                    celsius = sc.nextDouble();
                    if (celsius <= maximum && celsius >= minimum) {
                        break;
                    }
                }
                BigDecimal cconvert = centigrade2Fahrenheit(celsius, roundScale);
                System.out.println(+celsius + "C" + " = " + cconvert + "F");
            }
            System.out.print("Would you like to exit the program? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }//main
}//MainApp
