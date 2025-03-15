import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fullMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] abbrMonths = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
        String[] threeLetterMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] daysInCommonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int monthIndex = -1;
        int year = -1;
        
        while (monthIndex == -1) {
            System.out.print("Enter a month (name, abbreviation, three letters, or number 1-12): ");
            String monthInput = scanner.next();
            
            for (int i = 0; i < 12; i++) {
                if (monthInput.equalsIgnoreCase(fullMonths[i]) ||
                    monthInput.equalsIgnoreCase(abbrMonths[i]) ||
                    monthInput.equalsIgnoreCase(threeLetterMonths[i]) ||
                    monthInput.equals(String.valueOf(i + 1))) {
                    monthIndex = i;
                    break;
                }
            }
            
            if (monthIndex == -1) {
                System.out.println("Invalid month. Please enter again.");
            }
        }
        
        while (year < 0) {
            System.out.print("Enter a valid year (non-negative full number): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Invalid year. Please enter again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
        
        int days = daysInCommonYear[monthIndex];
        
        // Check for leap year and adjust February
        if (monthIndex == 1 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            days = 29;
        }
        
        System.out.println("The number of days in " + fullMonths[monthIndex] + " " + year + " is: " + days);
        
        scanner.close();
    }
}