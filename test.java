import java.util.*;

public class test {
    public static void main(String[] args){
        int j = verifyInteger(3);
        System.out.print("Valid input of " + j);
    }

    public static int verifyInteger(int limit) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean isValid = false;
        
        while (!isValid) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num > 0 && num <= limit) {
                    isValid = true;
                }
                else {
                    System.out.print("Entry out of Range. ");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear the input buffer
            }
        }
        return num;
    }
}