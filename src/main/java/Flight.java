import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private String destination;
    private ArrayList<Passenger> passengersBooked;

    public Flight(String flightNumber, String destination){
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.passengersBooked = new ArrayList<>();
    }

    public void assignPlane(Plane plane){
        this.plane = plane;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getPassengerBookedCount(){
        return this.passengersBooked.size();
    }

    public void bookPassenger(Passenger passenger){
        this.passengersBooked.add(passenger);
    }

    public ArrayList<Passenger> getPassengersBooked() {
        return this.passengersBooked;
    }


    public void boardPassenger(Passenger passenger){
        this.getPlane().addPassenger(passenger);
    }

    public void boardPlane(){
        //for each person in this.getPassengersBooked()
            // board this.passenger(each person)
        for (Passenger person : this.passengersBooked){
            this.boardPassenger(person);
        }
    }

}
