import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** This class handles the menu navigation for an Customer User.
 * Made for C212 SP20 for the final project.
 * @author Team 27
 */
public class CustomerDriver {
    //All the Customers & Airlines in the system
    List<Customer> customers;
    List<Airline> airlines;
    Scanner in;

    //Currently logged-in user
    Customer user;

    public CustomerDriver(List<Customer> customers, List<Airline> airlines, Scanner in, Customer customer) {
        this.customers = customers;
        this.airlines = airlines;
        this.in = in;
        this.user = customer;
    }

    /**
     * Creates the main menu for the Customer User, quitting this menu returns to the main menu found in AirlineSystemDriver
     */
    public void mainMenu(){
        //running used to section off sub menu selections
        boolean running = true;
        String input = "";

        //displays the main menu for Customer Users
        while(running) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.printf("| Welcome %10s   Mile Points: %7d   Logout (-1) |%n", user.getUsername(), user.getMilePoints());
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.println("|  Select an Option:                                      |");
            System.out.println("|     1) View available flight                            |");
            System.out.println("|     2) View booked flights                              |");
            System.out.println("|     3) View Past flights (write reviews here )          |");
            System.out.println("|     4) View reviews                                     |");
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");

            //waits for user to provide an input then processes it
            if(in.hasNext())
                input = in.next();

            //processes the input
            switch (input){
                case "1":
                    //view avaliable flights
                    this.availableFlights();
                    break;
                case "2":
                    //view booked flights
                    this.bookedFlights();
                    break;
                case "3":
                    //view past flights
                    this.pastFlights();
                    break;
                case "4":
                    //view reviews
                    this.reviews();
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
     * Handles the menu navigation for viewing past flights
     */
    private void pastFlights() {
    	 //running used to section off sub menu selections
        boolean runningPastFlights = true;
        String inputPastFlgihts = "";
        List<Flight> CustomerPastFlgihts = new ArrayList<>();
        for(int i = 0; i < this.airlines.size(); i++) {
        	for(int j = 0; j < this.airlines.get(i).getPastFlights().size(); i++) {
        		if(this.airlines.get(i).getPastFlights().get(j).CustomerFlown(this.user.getUsername())) {
        			CustomerPastFlgihts.add(this.airlines.get(i).getPastFlights().get(j));
        		}
        	}
        }
        Collections.sort(CustomerPastFlgihts, new Flight.SortFlightCost());

        //displays the main menu for Customer's Past Flights
        while(runningPastFlights) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.printf("| Welcome %10s   Mile Points: %7d |%n", user.getUsername(), user.getMilePoints());
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            for(Flight f : CustomerPastFlgihts) {
            	System.out.printf("| %-s|",  f.toString());
            }
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.println("|  Select an Option:                                      |");
            System.out.println("|     1) Sort Past flights by Cost(default)               |");
            System.out.println("|     2) Sort Past flights by Destination                 |");
            System.out.println("|     3) Sort Past flights by Starting Location           |");
            System.out.println("|     4) Sort Past flights by Airline#                    |");
            System.out.println("|     5) Write a review                                   |");
            System.out.println("|                                                         |");
            System.out.println("|    -1) back to menu                                     |");
            System.out.println("+---------------------------------------------------------+");

            //waits for user to provide an input then processes it
            if(in.hasNext())
            	inputPastFlgihts = in.next();

            //processes the input
            switch (inputPastFlgihts){
                case "1":
                    //sort past flights by cost
                	Collections.sort(CustomerPastFlgihts, new Flight.SortFlightCost());
                    break;
                case "2":
                	//sort past flights by Destination
                	Collections.sort(CustomerPastFlgihts, new Flight.SortFlightDestination());
                    break;
                case "3":
                	//sort past flights by Starting
                	Collections.sort(CustomerPastFlgihts, new Flight.SortFlightStart());
                    break;
                case "4":
                	//sort past flights by Starting
                	Collections.sort(CustomerPastFlgihts, new Flight.SortFlightAirlineNumber());
                    break;
                case "5":
                    //write reviews
                    this.writeReviews(CustomerPastFlgihts);
                    break;
                case "-1":
                    //exits current menu
                	runningPastFlights = false;
                    break;
                default:
                    //all other inputs are irrelevant for this menu
                    System.out.println("Invalid Choice.");
                    break;

            }
        }
    }
    /**
     * Handles the menu navigation for adding the Customer's reviews
     */
    private void writeReviews(List<Flight> pastFlights) {
    	String flightNumber = "";
    	String message = "";
    	int rating = 0;
    	System.out.println("+---------------------------------------------------------+");
        System.out.println("|                                                         |");
        System.out.printf("| Welcome %10s   Mile Points: %7d |%n", user.getUsername(), user.getMilePoints());
        System.out.println("|                                                         |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|            Enter in a Flight Number                     |");
        if(in.hasNext()) {
        	flightNumber = in.next();
        	for(Flight f : pastFlights) {
        		if (f.getFlightnumber() == flightNumber) {
        			Ticket thisTicket = f.CustomerTicket(this.user.getUsername());
        			Airline thisAirline = f.getAirline();
        			System.out.println("+---------------------------------------------------------+");
        	        System.out.println("|                 Give a rating (0-5)                     |");
        	        if(in.hasNextInt()) {
        	        	rating = in.nextInt();
        	        	if(0 <= rating && rating <= 5) {
        	        		System.out.println("+---------------------------------------------------------+");
                	        System.out.println("|                Write a message                          |");
                	        if(in.hasNextLine()) {
                	        	message = in.nextLine();
                	        	List<Review> theirReviews = this.user.getReviews();
                	        	theirReviews.add(new Review(message, rating, thisAirline, thisTicket, user));
                	        	this.user.setReviews(theirReviews);
                	        	System.out.println("|                Success                                  |");
                	        }
                	        else {
                	        	System.out.println("|               Problem occured                           |");
                	        	break;
                	        }
        	        		
        	        	}
        	        	else {
        	        		System.out.println("|               Incorrect Rating Number                   |");
        	        		break;
        	        	}
        	        }
        		}
        		else {
        			System.out.println("|            Incorrect Flight Number                      |");
        			break;
        		}
        	}
        }
        
    }
    /**
     * Handles the menu navigation for viewing the Customer's reviews
     */
    private void reviews() {
    	System.out.println("+---------------------------------------------------------+");
        System.out.println("|                                                         |");
        System.out.printf("| Welcome %10s   Mile Points: %7d |%n", user.getUsername(), user.getMilePoints());
        System.out.println("|                                                         |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                      Your Reviews                       |");
        for(Review r : this.user.getReviews()) {
        	System.out.println("| "+r.toString()+" |");
        	System.out.println("|                                                         |");
        }
        System.out.println("+---------------------------------------------------------+");
    }

    /**
     * Handles the menu navigation for viewing booked flights
     */
    private void bookedFlights() {
    }

    /**
     * Handles the menu navigation for viewing available flights
     */
    private void availableFlights() {
    }
}
