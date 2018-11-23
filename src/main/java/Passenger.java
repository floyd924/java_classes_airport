import java.util.ArrayList;

public class Passenger {

    private static int count;
    private static ArrayList<Passenger> allPassengers = new ArrayList<>();

    public Passenger(){
        count++;
        Passenger.allPassengers.add(this);
    }

    public static int getNumberOfInstances(){
        return count;
    }

    public static ArrayList<Passenger> getAllPassengers(){
        return allPassengers;
    }
}
