import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/** This class handles the menu navigation for an Airline User.
 * Made for C212 SP20 for the final project.
 * @author Team 27
 */
public class AirlineDriver {
    //All the Customers & Airlines in the system
    List<Customer> customers;
    List<Airline> airlines;
    Scanner in;

    //Currently logged-in user
    Airline user;

    public AirlineDriver(List<Customer> customers, List<Airline> airlines, Scanner in, Airline airline) {
        this.customers = customers;
        this.airlines = airlines;
        this.in = in;
        this.user = airline;
    }

    /**
     * Creates the main menu for the Airline User, quitting this menu returns to the main menu found in AirlineSystemDriver
     */
    public void mainMenu(){
        //running used to section off sub menu selections
        boolean running = true;
        String input = "";

        //displays the main menu for Airline Users
        while(running) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.printf("| Welcome %-32s    Logout (-1) |%n", user.getName() + " User");
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.println("|  Select an Option:                                      |");
            System.out.println("|     1) View current flights                             |");
            System.out.println("|     2) View past flights                                |");
            System.out.println("|     3) View customer ratings/reviews                    |");
            System.out.println("|     4) Manage reward mile points                        |");
            System.out.println("|     5) Manage blacklist                                 |");
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");

            //waits for user to give an input
            if(in.hasNext())
                input = in.next();

            //processes the input
            switch (input){
                case "1":
                    //view current flights
                    this.availableFlights();
                    break;
                case "2":
                    //view past flights
                    this.pastFlights();
                    break;
                case "3":
                    //view customer reviews
                    this.reviews();
                    break;
                case "4":
                    //manage reward mile points
                    this.rewards();
                    break;
                case "5":
                    //manage Airline blacklist
                    this.blacklist();
                    break;
                case "-1":
                    //exits current menu
                    running = false;
                    break;
                default:
                    //all other inputs are irrelevant for this menu
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }

    /**
     * Handles the menu navigation for managing the blacklist
     */
    private void blacklist() {
    }

    /**
     * Handles the menu navigation for managing the mile points
     */
    private void rewards() {
    }

    /**
     * Handles the menu navigation for customer reviews
     */
    private void reviews() {
    	List<Review> ThisArilineReviews = new ArrayList<Review>();
    	for(Customer c : this.customers) {
    		for (Review r : c.getReviews()) {
    			if(r.getAirline().getName().equals(user.getName())) {
    				ThisArilineReviews.add(r);
    			}
    		}
    	}
    	boolean reviewsRunnning = true;
    	 String inputReview = "";
    	while(reviewsRunnning) {
    	 System.out.println("+---------------------------------------------------------+");
         System.out.println("|                                                         |");
         System.out.printf("| Welcome %-32s    Back to Main Menu (-1) |%n", user.getName() + " User");
         System.out.println("|                                                         |");
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|                                                         |");
         System.out.println("|  Select an Option:                                      |");
         System.out.println("|     1) View your current reviews by Customer            |");
         System.out.println("|     2) View your current reviews by greatest rating     |");
         System.out.println("|     3) View your current reviews by Lowest rating       |");
         System.out.println("|                                                         |");
         System.out.println("+---------------------------------------------------------+");
         //waits for user to give an input
         if(in.hasNext())
        	 inputReview = in.next();
         //processes the input
         switch (inputReview){
             case "1":
                 //view current reviews by Customer
            	 Collections.sort(ThisArilineReviews,new Review.SortReveiwByCustomerUsername());
            	 System.out.println("+---------------------------------------------------------+");
            	 System.out.println("|                                                         |");
            	 for(Review r : ThisArilineReviews) {
            		 System.out.printf("| %-32s User: %s, Rating : %d |%n", r.getAirline().getName(), r.getCustomer().getUsername(),
            				 r.getRating());
            		 System.out.printf("| Message: %s |%n", r.getMessage());
            		 System.out.printf("| Ticket: %s |%n", r.getTicket());
            		 System.out.println("|                                                         |");
            	 }
            	 System.out.println("+---------------------------------------------------------+");
                 break;
             case "2":
                 //view current reviews by greatest Rating
            	 Collections.sort(ThisArilineReviews,new Review.SortReveiwByGreatestRating());
            	 System.out.println("+---------------------------------------------------------+");
            	 System.out.println("|                                                         |");
            	 for(Review r : ThisArilineReviews) {
            		 System.out.printf("| %-32s User: %s, Rating : %d |%n", r.getAirline().getName(), r.getCustomer().getUsername(),
            				 r.getRating());
            		 System.out.printf("| Message: %s |%n", r.getMessage());
            		 System.out.printf("| Ticket: %s |%n", r.getTicket());
            		 System.out.println("|                                                         |");
            	 }
            	 System.out.println("+---------------------------------------------------------+");
                 break;
             case "3":
                 //view current reviews by Lowest Rating 
            	 System.out.println("+---------------------------------------------------------+");
            	 System.out.println("|                                                         |");
            	 for(Review r : ThisArilineReviews) {
            		 System.out.printf("| %-32s User: %s, Rating : %d |%n", r.getAirline().getName(), r.getCustomer().getUsername(),
            				 r.getRating());
            		 System.out.printf("| Message: %s |%n", r.getMessage());
            		 System.out.printf("| Ticket: %s |%n", r.getTicket());
            		 System.out.println("|                                                         |");
            	 }
            	 System.out.println("+---------------------------------------------------------+");
                 break;
             case "-1":
                 //exits current menu
            	 reviewsRunnning = false;
                 break;
             default:
                 //all other inputs are irrelevant for this menu
                 System.out.println("Invalid Choice.");
                 break;
         }
    	}
    }

    /**
     * Handles the menu navigation for viewing past flights
     */
    private void pastFlights() {
    }

    /**
     * Handles the menu navigation for managing the available flights
     */
    private void availableFlights() {
    }

}
