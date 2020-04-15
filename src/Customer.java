import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Flight> pastFlights;
    private ArrayList<Flight> bookedFlights;
    private ArrayList<Review> reviews;


    public Customer(String username, String password) {
        super(username, password);
    }

    public ArrayList<Flight> getPastFlights() {
        return pastFlights;
    }

    public void setPastFlights(ArrayList<Flight> pastFlights) {
        this.pastFlights = pastFlights;
    }

    public ArrayList<Flight> getBookedFlights() {
        return bookedFlights;
    }

    public void setBookedFlights(ArrayList<Flight> bookedFlights) {
        this.bookedFlights = bookedFlights;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(){
        //whenever the user wants to add a new review
    }
}
