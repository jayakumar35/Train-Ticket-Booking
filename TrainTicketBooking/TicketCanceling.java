package TrainTicketBooking;

import java.util.HashMap;
import java.util.Map;

public class TicketCanceling  extends TicketBooking{
    private static char preferenceTrecker ='\0';
    private static int canceledseatNumber =0;

    private static Map<Integer, Character> seatNumberWithBerth =new HashMap<>();

     public static String canceling (int id){
        
        for(Passenger p : confirmedList){
            
            if(p.getId() ==id){
                cancel(p);
                return "success";
            }
        }
        
        for (Passenger p : racQueue) {
            if(p.getId() == id){
                cancel(p);
                return "success";
            }
            
        }
        for(Passenger p : waitingQueue){
            if(p.getId() == id){
                cancel(p);
                return "success";

            }
        }
        return "Invalid Id";
    }

    private static void cancel(Passenger p){
        if(p.getTicketType() == "berth"){
            // Only for RAC
            preferenceTrecker =p.getPreference();
            canceledseatNumber = p.getSeatNumber();
            // Map for reference in future
             seatNumberWithBerth.put(canceledseatNumber,preferenceTrecker);

            deleteFromAllLists(p);
            addRacToBerth(racQueue.poll());
            addWaitingToRac(waitingQueue.poll());
        }
        else if(p.getTicketType() == "rac"){
            racQueue.remove(p);
            addWaitingToRac(waitingQueue.poll());
        }
        else{
            waitingQueue.remove(p);
        }

    }
    private static void addWaitingToRac(Passenger p){
        if(p!=null){
            p.setTicketType("rac");
            racQueue.add(p);

        }
    }
    private static void addRacToBerth(Passenger p){
        if(p!=null){
            p.setPreference(preferenceTrecker);
            p.setSeatNumber(canceledseatNumber);
            p.setTicketType("berth");

            if(preferenceTrecker == 'U'){
                upperList.add(p);
            }
            else if(preferenceTrecker == 'M'){
                middleList.add(p);

            }
            else{
                lowerList.add(p);
            }
            confirmedList.add(p);
            seatNumberWithBerth.remove(canceledseatNumber);
            preferenceTrecker ='\0';
            canceledseatNumber =0;
        }
    }
    private static void deleteFromAllLists(Passenger p){
        confirmedList.remove(p);
        upperList.remove(p);
        lowerList.remove(p);
        middleList.remove(p);

    }

   public static Map<Integer,Character>getSeatNumberWithBerth(){
    return seatNumberWithBerth;
   }
    
    
  
    }
   



