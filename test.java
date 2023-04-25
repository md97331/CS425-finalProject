import java.util.*;

public class test {
    public static void main(String[] args){
        int num = 0;
        System.out.print("Enter an Integer: ");
        Scanner input = new Scanner(System.in);
        while(true) {
            if(input.hasNextInt(Integer.parseInt(input.nextLine()))) {
                System.out.print("Integer");
                break;
            }
            else{
                System.out.print("Not Integer, Please Try Again: ");
                input.hasNextInt();
                input.nextLine();
            }
        }   
    }
}
