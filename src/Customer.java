import java.util.List;

public class Customer extends User implements Saveable{
    private List<Flight> flights;
    private List<Review> reviews;
    private int milePoints;

    public Customer(String username, String password) {
        super(username, password, "Customer");
        //TODO Implement creation of new files
    }
    public Customer(){
        super("a","a","Customer");
    }

    public List<Flight> getFlights() {return this.flights;}

    public void setFlights(List<Flight> flights) {this.flights = flights;}

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void bookFlight(Flight f){
        this.flights.add(f);
    }

    public int getMilePoints() {return this.milePoints;}

    public void setMilePoints(int milePoints) {this.milePoints = milePoints;}

    @Override
    public String toString() {
        return "Customer{" +
                "flights=" + flights +
                ", reviews=" + reviews +
                ", milePoints=" + milePoints +
                '}';
    }

    @Override
    public void save(){
        //TODO Implement save function for Customer
        //will be ran to save each user's information
        super.save();

    }
}
