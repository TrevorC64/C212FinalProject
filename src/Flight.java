import java.util.Arrays;
import java.util.Map;

public class Flight implements Saveable {
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

    public Flight(Integer seats, String date, String time, String startingLocation, String endingLocation, double cost, String[] layovers, int flightTime, int miles, Airline airline) {
        //TODO Use seats ^^^^^^ to generate Tickets for the Flight
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

    @Override
    public String toString() {
        return "Flight{" +
                "seats=" + seats +
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
}
