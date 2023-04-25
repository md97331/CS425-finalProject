import java.util.*;

public class test {

    public static void main(String[] args) {
            
        int pnum = 0; boolean flag = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        do {
            try{
                pnum = Integer.parseInt(input.nextLine());
                flag = false;
            }
            catch(Exception e ){
                System.out.print("Invalid Entry, Enter Integer: ");        
                }

        }
        while(flag == true); 
        input.close();
    }   

}

