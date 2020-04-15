import java.util.ArrayList;

public class Airline extends User implements Saveable{
    private String name;
    private ArrayList<Flight> avaliableFlights;
    private ArrayList<Flight> pastFlights;
    private ArrayList<Review> reviews;

    public Airline(String username, String password, String name) {
        super(username, password);
        this.name = name;
        this.avaliableFlights = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Flight> getAvaliableFlights() {
        return avaliableFlights;
    }

    public void setAvaliableFlights(ArrayList<Flight> avaliableFlights) {
        this.avaliableFlights = avaliableFlights;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Flight> getPastFlights() {
        return pastFlights;
    }

    public void setPastFlights(ArrayList<Flight> pastFlights) {
        this.pastFlights = pastFlights;
    }

}

