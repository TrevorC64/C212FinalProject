import java.util.Comparator;
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
	
	// Will organize review according to their rating, organized greatest first to least last.
	public static class SortReveiwByGreatestRating implements Comparator<Review>{

		@Override
		public int compare(Review o1, Review o2) {
			return Integer.compare(o2.getRating(), o1.getRating());
		}
		
	}
	// Will Organize review by least to greatest rating
	public static class SortReveiwByLeastRating implements Comparator<Review>{

		@Override
		public int compare(Review o1, Review o2) {
			return Integer.compare(o1.getRating(), o2.getRating());
		}
		
	}
	// sort by User name in Alphabetical order
	public static class SortReveiwByCustomerUsername implements Comparator<Review>{

		@Override
		public int compare(Review o1, Review o2) {
			return o1.customer.getUsername().compareTo(o2.getCustomer().getUsername());
		}
		
	}
	//sort by Airline name in alphabetical order
	public static class SortReveiwByAirLine implements Comparator<Review>{

		@Override
		public int compare(Review o1, Review o2) {
			return o1.getAirline().getName().compareTo(o2.getAirline().getName());
		}
		
	}
}
