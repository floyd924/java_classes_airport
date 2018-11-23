import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport1;
    Plane plane1;
    Plane plane2;
    Plane plane3;
    Plane plane4;
    Flight flight1;
    Flight flight2;
    Flight flight3;
    Flight flight4;
    Passenger person1;
    Passenger person2;
    Passenger person3;
    Passenger person4;
    Passenger person5;
    Passenger person6;
    Passenger person7;
    Passenger person8;

    @Before
    public void setup(){
        airport1 = new Airport("GVA");
        plane1 = new Plane(PlaneType.LEARJET, "Monarch");
        plane2 = new Plane(PlaneType.TWINOTTER, "EasyJet");
        plane3 = new Plane(PlaneType.CESNA187, "British Airways");
        plane4 = new Plane(PlaneType.BOEING777, "Jet2");
        flight1 = new Flight("A123", "Alicante");
        flight2 = new Flight("B456", "Lyon");
        flight3 = new Flight("C789", "Barra");
        flight4 = new Flight("D234", "London Gatwick");
        person1 = new Passenger();
        person2 = new Passenger();
        person3 = new Passenger();
        person4 = new Passenger();
        person5 = new Passenger();
        person6 = new Passenger();
        person7 = new Passenger();
        person8 = new Passenger();
    }

    @Test
    public void canAddPlaneToHangerAndGetHangerSize(){
        airport1.addPlaneToHanger(plane1, airport1.getHanger1());
        assertEquals(1, airport1.getHangerSize(airport1.getHanger1()));
    }

    @Test
    public void canBookPassengersAndBoardFlight(){
        flight1.bookPassenger(person1);
        flight1.bookPassenger(person2);
        flight1.bookPassenger(person3);
        flight1.bookPassenger(person4);
        flight1.assignPlane(plane1);
        flight1.boardPlane();
        assertEquals(4, plane1.getPassengerCount());
    }

    @Test
    public void canSortHangerByPlaneCapacity(){
        airport1.addPlaneToHanger(plane4, airport1.getHanger2());
        airport1.addPlaneToHanger(plane3, airport1.getHanger2());
        airport1.addPlaneToHanger(plane1, airport1.getHanger2());
        airport1.addPlaneToHanger(plane2, airport1.getHanger2());
//        new ArrayList<Plane>() list = airport1.sortHanger(airport1.getHanger2());
        airport1.sortHanger(airport1.getHanger2());
        assertEquals(4, airport1.getHangerSize(airport1.getHanger2()));

    }

    @Test
    public void canFindTheSmallestPlaneSuitable(){
        airport1.addPlaneToHanger(plane3, airport1.getHanger2());
        airport1.addPlaneToHanger(plane1, airport1.getHanger2());
        airport1.addPlaneToHanger(plane2, airport1.getHanger2());
        airport1.sortHanger(airport1.getHanger2());
        //hanger is now sorted, smallest to largest
        flight1.bookPassenger(person1);
        flight1.bookPassenger(person2);
        flight1.bookPassenger(person3);
        flight1.bookPassenger(person4);
        //flight1 now has 4 passengers
        airport1.assignBestPlane(flight1, airport1.getHanger2());
        assertEquals(PlaneType.TWINOTTER, flight1.getPlane().getPlaneType());


    }

}
