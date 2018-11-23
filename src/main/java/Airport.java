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

    public ArrayList<Plane> getHanger1() {
        return this.hanger1;
    }

    public ArrayList<Plane> getHanger2() {
        return this.hanger2;
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

    public void assignBestPlane(Flight flight, ArrayList<Plane> hanger){
        int booked = flight.getPassengerBookedCount();
        ArrayList<Plane> suitablePlanes = new ArrayList();

        for (Plane plane : hanger) {
            if (plane.getCapacity() >= booked) {
                suitablePlanes.add(plane);
            };
        };
        //if plane.capacity is >= booked,
        //add to a new arraylist

        Plane bestPlane = suitablePlanes.get(0);


        flight.assignPlane(bestPlane);
    }

}
