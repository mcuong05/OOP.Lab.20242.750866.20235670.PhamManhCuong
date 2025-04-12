import java.util.Scanner;  

public class Calculator {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        
        // Input two numbers from the user  
        System.out.print("Enter first number: ");  
        String strNum1 = scanner.nextLine();  
        double num1 = Double.parseDouble(strNum1);  
        
        System.out.print("Enter second number: ");  
        String strNum2 = scanner.nextLine();  
        double num2 = Double.parseDouble(strNum2);  
        
        // Calculations  
        double sum = num1 + num2;  
        double difference = num1 - num2;  
        double product = num1 * num2;  
        
        // Check for division by zero  
        double quotient = 0;  
        if (num2 != 0) {  
            quotient = num1 / num2;  
        } else {  
            System.out.println("Cannot divide by zero.");  
        }  

        // Display results  
        System.out.println("Sum: " + sum);  
        System.out.println("Difference: " + difference);  
        System.out.println("Product: " + product);  
        if (num2 != 0) {  
            System.out.println("Quotient: " + quotient);  
        }  
        
        scanner.close();  
    }  
}  