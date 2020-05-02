import java.util.Comparator;

/** Class for reviews for Airlines
 * Made for C212 SP20 for the final project.
 * @author Team 27
 */
public class Review {
    private String message;
    private int rating; //rating 0-5
    private String airlineName;
    private Ticket ticket;
    private String customerUsername;

    public Review(String message, int rating, String airline, Ticket ticket, String customer) {
        this.message = message;
        this.rating = rating;
        this.airlineName = airline;
        this.ticket = ticket;
        this.customerUsername = customer;
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

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airline) {
        this.airlineName = airline;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getCustomername() {
        return customerUsername;
    }

    public void setCustomerName(String customer) {
        this.customerUsername = customer;
    }

    @Override
    public String toString() {
        return "Review{" +
                "message='" + message + '\'' +
                ", rating=" + rating +
                ", airline=" + airlineName +
                ", ticket=" + ticket +
                ", customer=" + customerUsername +
                '}';
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
			return o1.getCustomername().compareTo(o2.getCustomername());
		}
		
	}
	//sort by Airline name in alphabetical order
	public static class SortReveiwByAirLine implements Comparator<Review>{

		@Override
		public int compare(Review o1, Review o2) {
			return o1.getAirlineName().compareTo(o2.getAirlineName());
		}
		
	}
}
