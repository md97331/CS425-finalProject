import java.util.*;

public class test {
    public static void main(String[] args){
        int j = verifyInteger(3);
        System.out.print(j);
    }

    public static int verifyInteger(int limit) {
        int num = 0; Boolean flag = true;
        System.out.print("Enter an Integer: ");
        do {
            try {
                Scanner input = new Scanner(System.in);
                num = input.nextInt();
                input.nextLine();
                if (num > 0 && num <=limit) {
                    flag = false;
                }
                if (num > limit || num == 0) {
                    System.out.print("Input out of range, Please Try again: ");
                }
                else {
                    System.out.print("Invalid Entry, Please Try Again: ");
                }
                input.close();
            }   
            catch (Exception e) {
                System.out.print("Invalid Entry, Enter Integer: "); 
            }

        }
        while (flag == false);
    return num;
    }
}
