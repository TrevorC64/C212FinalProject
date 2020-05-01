public class Ticket implements Saveable {
    private String flightNumber;
    private int seat;
    private double cost;
    private boolean available;
    private Airline airline;
    private Customer customer; //null if not purchased
    private int miles;

    public Ticket(String flightNumber, int seat, double cost, boolean available, Airline airline, Customer customer, int miles) {
        this.flightNumber = flightNumber;
        this.seat = seat;
        this.cost = cost;
        this.available = available;
        this.airline = airline;
        this.customer = customer;
        this.miles = miles;
    }

    public String getflightNumber() {
        return flightNumber;
    }

    public void setflightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void updateMilePoints(){
        //TODO implement MilePoint System
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "flightNumber=" + flightNumber +
                ", seat=" + seat +
                ", cost=" + cost +
                ", available=" + available +
                ", airline=" + airline +
                ", customer=" + customer +
                ", miles=" + miles +
                '}';
    }

    @Override
    public void save() {

    }
}
