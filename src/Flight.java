import java.util.Arrays;
import java.util.Map;
import java.util.Comparator;

public class Flight implements Saveable {
	private String flightNumber; //Format as first three letters of airline and unique number 3 digit number => DAL378
    private Map<Integer, Ticket> seats;
    private String date; // format = "mmddyyy" => "11282000" => Nov 28th 2000
    private String time;     //  format = "hr:min"  => "14:23"    => 2:23 pm
    private String startingLocation;
    private String endingLocation;
    private double cost;
    private String[] layovers;
    private int flightTime;
    private Airline airline;
    private int miles;

    public Flight(String flightnumber, Integer seats, String date, String time, String startingLocation, String endingLocation, double cost, String[] layovers, int flightTime, int miles, Airline airline) {
    	this.flightNumber = flightnumber;
    	for(int i = 1; i <= seats; i++) {
    		double newCost = cost;
    		if(seats >= 2 && i <= seats/2) {
    			newCost = cost*1.5;
    		}
    		else {
    			newCost = cost;
    		}
    		this.seats.put(i, new Ticket(flightnumber, i, newCost, false, airline, null, miles));
    	}
        this.date = date;
        this.time = time;
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.cost = cost;
        this.layovers = layovers;
        this.flightTime = flightTime;
        this.airline = airline;
        this.miles = miles;
    }

    public Map<Integer, Ticket> getSeats() {
        return seats;
    }

    public void setSeats(Map<Integer, Ticket> seats) {
        this.seats = seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(String endingLocation) {
        this.endingLocation = endingLocation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String[] getLayovers() {
        return layovers;
    }

    public void setLayovers(String[] layovers) {
        this.layovers = layovers;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public String getFlightnumber() {
    	return flightNumber;
    }
    public void setFlightnumber(String newFlightNumber) {
    	this.flightNumber = newFlightNumber;
    }
    public boolean FlightFull() {
    	boolean fullFlight = true;
    	for(int i = 1; i <= seats.size(); i++) {
    		fullFlight = (seats.get(i).getCustomer() == null) && fullFlight;
    	}
    	return fullFlight;
    }
    public boolean CustomerFlown(String customerUsername) {
    	boolean CustomerHasFlown = false;
    	for(int i = 1; i <= seats.size(); i++) {
    		CustomerHasFlown = (seats.get(i).getCustomer().getUsername() == customerUsername) | CustomerHasFlown;
    	}
    	return CustomerHasFlown;
    }
    public Ticket CustomerTicket(String customerUsername) {
    	Ticket customerTicket = null;
    	for(int i = 1; i <= seats.size(); i++) {
    		if(seats.get(i).getCustomer().getUsername() == customerUsername) {
    			customerTicket = seats.get(i);
    		}
    	}
    	return customerTicket;
    }
    public void setSeatFull(int number, Customer c) {
    	Ticket UpdatedTicket = this.seats.get(number);
    	UpdatedTicket.setCustomer(c);
    	UpdatedTicket.setAvailable(false);
    	this.seats.put(number, UpdatedTicket);
    }
    public boolean getSeatNull(int number) {
    	return (this.seats.get(number).getCustomer() == null);
    }
    public void setSeatnull(int number) {
    	Ticket UpdatedTicket = this.seats.get(number);
    	UpdatedTicket.setCustomer(null);
    	UpdatedTicket.setAvailable(true);
    	this.seats.put(number, UpdatedTicket);
    }

    @Override
    public String toString() {
        return "Flight{" +
        		"flightNumber=" +flightNumber+
                ", seats=" + seats +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", startingLocation='" + startingLocation + '\'' +
                ", endingLocation='" + endingLocation + '\'' +
                ", cost=" + cost +
                ", layovers=" + Arrays.toString(layovers) +
                ", flightTime=" + flightTime +
                ", airline=" + airline +
                ", miles=" + miles +
                '}';
    }

    @Override
    public void save() {

    }
    public static class SortFlightCost implements Comparator<Flight>{
    	// sorts by least cost
		@Override
		public int compare(Flight o1, Flight o2) {
			return Double.compare(o1.getCost(), o2.getCost());
		}
    	
    }
    public static class SortFlightAirlineNumber implements Comparator<Flight>{
    	// sorts by least cost
		@Override
		public int compare(Flight o1, Flight o2) {
			return o1.getFlightnumber().compareTo(o2.getFlightnumber());
		}
    	
    }
    public static class SortFlightDestination implements Comparator<Flight>{
    	// sorts by Destination
		@Override
		public int compare(Flight o1, Flight o2) {
			return o1.getEndingLocation().compareTo(o2.getEndingLocation());
		}
    	
    }
    public static class SortFlightStart implements Comparator<Flight>{
    	// sorts by Starting location
		@Override
		public int compare(Flight o1, Flight o2) {
			return o1.getStartingLocation().compareTo(o2.getStartingLocation());
		}
    	
    }
}
