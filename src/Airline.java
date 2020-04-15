import java.util.ArrayList;
import java.util.List;

public class Airline extends User implements Saveable{
    private String name;
    private List<Flight> availableFlights;
    private List<Flight> pastFlights;
    private List<Review> reviews;
    private List<Customer> blacklist;
    private List<Customer> reviewable;

    public Airline(String username, String password, String name) {
        super(username, password);
        this.name = name;
        this.availableFlights = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(List<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Flight> getPastFlights() {
        return pastFlights;
    }

    public void setPastFlights(List<Flight> pastFlights) {
        this.pastFlights = pastFlights;
    }

}

