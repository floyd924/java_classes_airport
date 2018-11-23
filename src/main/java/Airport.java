import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Airport {

    private ArrayList<Plane> hanger1;
    private ArrayList<Plane> hanger2;
    private ArrayList<Flight> departures;
    private String code;

    public Airport(String code){
        this.code = code;
        this.hanger1 = new ArrayList<>();
        this.hanger2 = new ArrayList<>();
        this.departures = new ArrayList<>();
    }

    public ArrayList<Flight> getDepartures() {
        return this.departures;
    }

    public ArrayList<Plane> getHanger1() {
        return this.hanger1;
    }

    public ArrayList<Plane> getHanger2() {
        return this.hanger2;
    }

    public void createFlight(String stringNum, String stringDest){
        Flight flight = new Flight(stringNum, stringDest);
        this.departures.add(flight);
    }

    public void addPlaneToHanger(Plane plane, ArrayList hanger){
        hanger.add(plane);
    }

    public int getHangerSize(ArrayList hanger){
        return hanger.size();
    }

    //sort the hanger small to big
    //make a new array of planes that are big enough
    //give me first array item

    public void sortHanger(ArrayList hanger){
        //hanger.plane.PlaneType.
        hanger.sort(Comparator.comparingInt(Plane::getCapacity));
    }

    public ArrayList returnPlaneArray(Flight flight, ArrayList<Plane> hanger){
        int booked = flight.getPassengerBookedCount();
        ArrayList<Plane> suitablePlanes = new ArrayList();

        for (Plane plane : hanger) {
            if (plane.getCapacity() >= booked) {
                suitablePlanes.add(plane);
            };
        };
        return suitablePlanes;
    }

    public void assignBestPlane(Flight flight, ArrayList<Plane> hanger){
        ArrayList<Plane> suitablePlanes = returnPlaneArray(flight, hanger);
        Plane bestPlane = suitablePlanes.get(0);
        flight.assignPlane(bestPlane);
    }

    public void assignNextBestPlane(Flight flight, ArrayList<Plane> hanger){
        ArrayList<Plane> suitablePlanes = returnPlaneArray(flight, hanger);
        Plane nextBestPlane = suitablePlanes.get(1);
        flight.assignPlane(nextBestPlane);
    }

    public int getTotalPassengersInAirport(){
        return Passenger.getNumberOfInstances();
    }

    public ArrayList<Passenger> getAllPassengersInAirport(){
        return Passenger.getAllPassengers();
    }

    public Passenger findPassengerByAssignedName(Passenger passenger){
        //find passenger by name of instance
        return passenger;
    }

}
