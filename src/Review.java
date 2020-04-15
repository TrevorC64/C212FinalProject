public class Review implements Saveable {
    private String message;
    private int rating; //rating 0-5
    private Airline airline;
    private Ticket ticket;
    private Customer customer;

    public Review(String message, int rating, Airline airline, Ticket ticket, Customer customer) {
        this.message = message;
        this.rating = rating;
        this.airline = airline;
        this.ticket = ticket;
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Review{" +
                "message='" + message + '\'' +
                ", rating=" + rating +
                ", airline=" + airline +
                ", ticket=" + ticket +
                ", customer=" + customer +
                '}';
    }

    @Override
    public void save() {

    }
}
