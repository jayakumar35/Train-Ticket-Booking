package TrainTicketBooking;

public class Passenger {
    private static int idprovider =0;
    private int id;
    private String name;
    private int age;
    private char preference;
    private String ticketType;
    private int seatNumber;

    public Passenger(String name,int age, char preference){
        this.id =++idprovider;
        this.name = name;
        this.age =age;
        this.preference = preference;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getPreference() {
        return preference;
    }
    public void setPreference(char preference) {
        this.preference = preference;
    }
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    @Override
    public String toString(){
        return "passenger Ticket id : " +id+"\npeassenger name: "+ name
              + "\npassenger Age : "+age +"\npassenger seat no : " +seatNumber
              + "\npassenger prefernce : " +preference;
    }
    
}
