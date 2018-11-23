import java.util.ArrayList;

public class Plane {

    private PlaneType planeType;
    private String airline;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType planeType, String airline){
        this.planeType = planeType;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public PlaneType getPlaneType() {
        return this.planeType;
    }

    public String getAirline() {
        return this.airline;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public int getPassengerCount(){
        return this.passengers.size();
    }

    public int getCapacity(){
        return this.planeType.getCapacity();
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }
}
