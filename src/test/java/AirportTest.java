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
    Passenger cat;

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
        cat = new Passenger();
        System.out.println("Here is where the people are made");
    }

    @Test
    public void canCreateFlight(){
        airport1.createFlight("EZ567", "Marseille");
        assertEquals(1, airport1.getDepartures().size());
        System.out.println("test 1");
    }

    @Test
    public void canAddPlaneToHangerAndGetHangerSize(){
        airport1.addPlaneToHanger(plane1, airport1.getHanger1());
        assertEquals(1, airport1.getHangerSize(airport1.getHanger1()));
        System.out.println("test 2");
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
        System.out.println("test 3");
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
        System.out.println("test 4");
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
        System.out.println("test 5");
    }

    @Test
    public void canFindTheNextSmallestPlane(){
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
        airport1.assignNextBestPlane(flight1, airport1.getHanger2());
        assertEquals(PlaneType.LEARJET, flight1.getPlane().getPlaneType());
        System.out.println("test 6");
    }

    @Test
    public void canGetTotalPeopleInAirport(){
        assertEquals(9, airport1.getTotalPassengersInAirport());
        System.out.println("test 7 total people");
    }
//THIS WORKS WHEN RUN ALONE, BUT NOT IN FILE
    //FILE RUN DOUBLES THIS FIGURE


    @Test
    public void canGetAllInstancesOfPassenger(){
        airport1.getAllPassengersInAirport();
        ArrayList<Passenger> array = new ArrayList<>();
        array.add(person1);
        array.add(person2);
        array.add(person3);
        array.add(person4);
        array.add(person5);
        array.add(person6);
        array.add(person7);
        array.add(person8);
        array.add(cat);
        assertEquals(array, airport1.getAllPassengersInAirport());
        System.out.println("test 8 arraylist of people");
    }
    //THIS WORKS WHEN RUN ALONE, BUT NOT IN FILE
    //FILE RUN DOUBLES THIS FIGURE

    @Test
    public void canFindPassengerByAssignedName(){
        assertEquals(cat, airport1.findPassengerByAssignedName(cat));
        System.out.println("test 9");
    }

    @Test
    public void addBaggageToOnePerson(){
        person1.addBaggage(4);
        person1.addBaggage(6);
        assertEquals(10, person1.getBaggage());
        System.out.println("test 10");
    }

    @Test
    public void cannotBoardPlaneIfThereIsTooMuchLuggage(){
        flight1.bookPassenger(person1);
        flight1.bookPassenger(person2);
        person1.addBaggage(250);
        person2.addBaggage(116);
        airport1.addPlaneToHanger(plane3, airport1.getHanger2());
        airport1.addPlaneToHanger(plane1, airport1.getHanger2());
        airport1.addPlaneToHanger(plane2, airport1.getHanger2());
        airport1.assignBestPlane(flight1, airport1.getHanger2());
        flight1.boardPlane();

        assertEquals(0, flight1.getPlane().getPassengerCount());
        System.out.println("test 11");
    }





}
