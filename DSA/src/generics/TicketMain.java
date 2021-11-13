package generics;

import java.util.Scanner;

class TicketNotAvailableException extends Exception{

    TicketNotAvailableException(String message)
    {
        super(message);
    }

}



public class TicketMain {
    public static void main(String[] args) {
        System.out.println("Enter how much money you had for movie");

        Scanner sc = new Scanner(System.in);
        int money =sc.nextInt();

        try{
            if(money>0) {
                System.out.println("you are allowed to watch a movie");

                int a=1/0;
            }
            else
            {
                throw new TicketNotAvailableException("you don't have  a valid ticket");

            }
        }

        catch (TicketNotAvailableException te)
        {
            te.printStackTrace();
        }


    }
}
