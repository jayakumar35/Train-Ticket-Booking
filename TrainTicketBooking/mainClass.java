package TrainTicketBooking;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
    
        boolean loop =true;
        while (loop) {
            System.out.println("**-------------------------**");
            System.out.println("\n 1) Book Ticket");
            System.out.println("\n 2) Cancel Ticket ");
            System.out.println("\n 3) Display Confimed list ");
            System.out.println("\n 4) Display RAC list ");
            System.out.println("\n 5) Display Waiting list");
            System.out.println("\n 6) Exit");
            System.out.println("**-------------------------**");
            System.out.println("\n  passenger any one Choose");
            Scanner s =new Scanner(System.in);
            int n = s .nextInt();

            switch (n) {
                case 1:{
                       System.out.print("Enter Name :");
                       String name =s.next();
                       System.out.print("Enter age :");
                       int age =s.nextInt();
                       System.out.print("Enter Berth :");
                       char preference = s.next().charAt(0);
                       if(preference == 'U'  ||  preference == 'M' || preference ==  'L')
                        TicketBooking.bookTicket(new Passenger(name, age, preference));
                       
                       else
                       System.out.println("Invalid berth");
                       break;
                }
                case 2:{
                       System.out.println("Enter Your Ticket Id :");
                       int id =s.nextInt();
                       System.out.println(TicketCanceling.canceling (id));
                       break; 
                }  
                case 3:{
                       TicketBooking.displayConfirmed();
                       break;
                }
                case 4:{
                       TicketBooking.displayRAC();
                       break;
                }
                case 5:{
                       TicketBooking.displayWaiting();
                       break;
                }
                case 6:{
                       System.out.println("\n Thank You!");
                       s.close();
                       loop=false;
                       break; 
                }                               
                default:
                     System.out.println("Invalid Optins ");
                    break;
            }
        }


    }
    
}
