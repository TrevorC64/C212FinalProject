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
    	List<String> runningBlacklist = this.user.getBlacklist();
    	boolean runningBlack = true;
        String inputBlack = "";

        //displays the blackList Menu
        while(runningBlack) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.println("|  Select an Option:                                      |");
            System.out.println("|     1) View BlackList                                   |");
            System.out.println("|     2) Add customer to BlackList                        |");
            System.out.println("|     3) Remove customer from BlackList                   |");
            System.out.println("|    -1) Back to Main Menu                                |");
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");

            //waits for user to give an input
            if(in.hasNext())
            	inputBlack = in.next();
            //processes the input
            switch (inputBlack){
                case "1":
                	//Sorting stuff 
                	Collections.sort(runningBlacklist, null);
                	System.out.println("+---------------------------------------------------------+");
	                System.out.println("|                                                         |");
	               	for(String s : runningBlacklist) {
	               		 System.out.printf("| User: %-32s |%n", s );
	              		 System.out.println("|                                                         |");
	               	}
	               	System.out.println("+---------------------------------------------------------+");
                    break;
                case "2":
                    //adding to blacklist
                	System.out.println("+---------------------------------------------------------+");
	                System.out.println("|                                                         |");
	                System.out.println("|       Enter a Username in the system                    |");
	                System.out.println("|                                                         |");
	                System.out.println("+---------------------------------------------------------+");
                	String NewBlacklister = "";
                	boolean customerExists = false;
                	boolean blackListContains = false;
                	String possibleNewBL = null;
                	//waits for user to give an input
                	if(in.hasNext()) {
                		NewBlacklister = in.next();
                	}
                	for(Customer c : this.customers) {
                	customerExists = (c.getUsername() == NewBlacklister) || customerExists;
                		if(customerExists) {
                			possibleNewBL = c.getUsername();
                		}
                	}
                	for(String s : runningBlacklist) {
                			blackListContains = (s == NewBlacklister) || blackListContains;
                	}
                	if(customerExists && (!blackListContains)) {
                		runningBlacklist.add(possibleNewBL);
                		this.user.setBlacklist(runningBlacklist);
                		System.out.println("|   Added the Customer to the blackList                    |");
                	}
                	else {
                		System.out.println("|   Customer is already in the list or doesn't exist       |");
               		}
                    break;
                case "3":
                    //remove customers from black List
                	System.out.println("+---------------------------------------------------------+");
	                System.out.println("|                                                         |");
	                System.out.println("|       Enter a Username in the system                    |");
	                System.out.println("|                                                         |");
	                System.out.println("+---------------------------------------------------------+");
	                String BlackListremoval = "";
	                boolean Success = false;
	                int location = 0;
                	if(in.hasNext()) {
                		BlackListremoval = in.next();
                	}
                	for(int i = 0; i < runningBlacklist.size(); i++) {
                		if(runningBlacklist.get(i) == BlackListremoval) {
                			Success = true;
                			runningBlacklist.remove(i);
                		}
            		}
                	if(Success) {
                		System.out.println("|   Customer removed                                    |");
                	}
                	else {
                		System.out.println("|   Customer is not on the black List                   |");
                	}
                    break;
                case "-1":
                    //exits current menu
                	runningBlack = false;
                    break;
                default:
                    //all other inputs are irrelevant for this menu
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }
    /**
     * Handles the menu navigation for managing the mile points
     */
    private void rewards() {
    	System.out.println("+---------------------------------------------------------+");
    	System.out.println("|                                                         |");
    	if (this.customers != null) {
    		for(Customer c : this.customers ) {
  
    			System.out.printf("| User: %-32s |", c.getUsername());
        		System.out.println("|                                                         |");
    		}
    	}
    	else {
    		System.out.println("|                    NO Customers                         |");
    		System.out.println("|                                                         |");
    	}
    	System.out.println("+---------------------------------------------------------+");
    	boolean runningRewards = true;
    	String inputRewards = "";

    	//displays the blackList Menu
    	while(runningRewards) {
    		System.out.println("+---------------------------------------------------------+");
    		System.out.println("|                                                         |");
    		System.out.println("|  Select an Option:                                      |");
    		System.out.println("|     1) Reward a Customer 50 Miles                       |");
    		System.out.println("|    -1) Back to Main Menu                                |");
    		System.out.println("|                                                         |");
    		System.out.println("+---------------------------------------------------------+");
    		//waits for user to give an input
    		if(in.hasNext())
    			inputRewards = in.next();
    		
    		//processes the input
    		switch (inputRewards){
    			case "1":
    				//Rewarding a Customer
    				System.out.println("+---------------------------------------------------------+");
	                System.out.println("|                                                         |");
	                System.out.println("|       Enter a Username in the system                    |");
	                System.out.println("|                                                         |");
	                System.out.println("+---------------------------------------------------------+");
	                boolean noSuccess = true;
	                String beingRewarded = "";
	                if(in.hasNext()) {
	                	beingRewarded = in.next();
	                }
	                if(this.customers != null) {
	                	for(int i = 0; i < this.customers.size(); i++ ) {
	                		if(this.customers.get(i).getUsername().equals(beingRewarded)){
	                			noSuccess = false;
	                			Customer c1 = this.customers.get(i);
	                			c1.setMilePoints(c1.getMilePoints()+50);
	                			this.customers.set(i, c1);
	                			System.out.println("|                   Customer Rewarded                     |");
	                		}
	            		}
	                }
	                if(noSuccess) {
	                	System.out.println("|                 Customer NOT Rewarded                   |");
	                }
    				break;
    			case "-1":
    				//exits current menu
    				runningRewards = false;
    				break;
    			default:
    				//all other inputs are irrelevant for this menu
    				System.out.println("Invalid Choice.");
    				break;
    		}
    	}
    }
    /**
     * Handles the menu navigation for customer reviews
     */
    private void reviews() {
    	List<Review> ThisArilineReviews = new ArrayList<Review>();
    	for(Customer c : this.customers) {
    		for (Review r : c.getReviews()) {
    			if(r.getAirlineName().equals(user.getName())) {
    				ThisArilineReviews.add(r);
    			}
    		}
    	}
    	boolean reviewsRunnning = true;
    	 String inputReview = "";
    	while(reviewsRunnning) {
         System.out.println("+---------------------------------------------------------+");
         System.out.println("|                                                         |");
         System.out.println("|  Select an Option:                                      |");
         System.out.println("|     1) View your current reviews by Customer            |");
         System.out.println("|     2) View your current reviews by greatest rating     |");
         System.out.println("|     3) View your current reviews by Lowest rating       |");
         System.out.println("|    -1) Back to Main Menu                                |");
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
            		 System.out.printf("| %-32s User: %s, Rating : %d |%n", r.getAirlineName(), r.getCustomername(),
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
            		 System.out.printf("| %-32s User: %s, Rating : %d |%n", r.getAirlineName(), r.getCustomername(),
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
            		 System.out.printf("| %-32s User: %s, Rating : %d |%n", r.getAirlineName(), r.getCustomername(),
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
    	 //running used to section off sub menu selections
        boolean runningPast = true;
        String inputPast = "";
        List<Flight> runningFlights = this.user.getPastFlights();
        if(runningFlights != null) {
        	Collections.sort(runningFlights, new Flight.SortFlightCost());
        }
        // shows past flights 
        while(runningPast) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            if(runningFlights != null) {
            	for(Flight f : runningFlights) {
            		System.out.printf("|"+f.toString()+" |");
            	}
            }
            else {
            	System.out.println("|                       No Flights                        |");
            }
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.println("|  Select an Option:                                      |");
            System.out.println("|     1) Add to past flights remove from current(means    |");
            System.out.println("|     (means that the flight was sucessfull)              |");
            System.out.println("|     2) Remove a past flight                             |");
            System.out.println("|     3) Sort past flights by cost (default)              |");
            System.out.println("|     4) Sort past flights by Destination                 |");
            System.out.println("|     5) Sort past flights by StartingLocation            |");
            System.out.println("|    -1) To go back                                       |");
            System.out.println("+---------------------------------------------------------+");
            //waits for user to give an input
            if(in.hasNext())
            	inputPast = in.next();

            //processes the input
            switch (inputPast){
                case "1":
                    //add 
                	System.out.println("+---------------------------------------------------------+");
                    System.out.println("|          Enter in an Airline Flight Number              |");
                    String theFlightNumber1 = "";
                    if(in.hasNext())
                   	 theFlightNumber1 = in.next();
                    boolean found1 = false;
                    int iterator1 = -1;
                    for(int i = 0; i < this.user.getAvailableFlights().size(); i++) {
                   	 	if(user.getAvailableFlights().get(i).getFlightnumber() == theFlightNumber1) {
                   	 		found1 = true;
                   	 		iterator1 = i;
                   	 	}
                    }
                    if(found1) {
                    	List<Flight> AF = this.user.getAvailableFlights();
                    	AF.remove(iterator1);
                    	runningFlights.add(this.user.getAvailableFlights().get(iterator1));
                    	this.user.setAvailableFlights(AF);
                    	this.user.setPastFlights(runningFlights);
                   	 	System.out.println("|                   Sucessful                                |");
                    }
                    else {
                    	System.out.println("|       Flight is not in currently avabilve Flights          |");
                    }
                    break;
                case "2":
                	 System.out.println("+---------------------------------------------------------+");
                     System.out.println("|          Enter in an Airline Flight Number              |");
                     String theFlightNumber = "";
                     if(in.hasNext())
                    	 theFlightNumber = in.next();
                     boolean found = false;
                     int iterator = -1;
                     if(runningFlights != null){
                    	 for(int i = 0; i < runningFlights.size(); i++) {
                    		 if(runningFlights.get(i).getFlightnumber().equals(theFlightNumber)) {
                    			 iterator = i;
                    			 found = true;
                    		 }
                    	 }
                     }
                     if(found) {
                    	 runningFlights.remove(iterator);
                    	 this.user.setPastFlights(runningFlights);
                    	 System.out.println("|                   Sucessful                                |");
                     }
                     else {
                    	 System.out.println("|       Flight is not in current past Flights          |");
                     }
                    break;
                case "3":
                    //Sorts by Price
                	if(runningFlights != null) {
                		Collections.sort(runningFlights, new Flight.SortFlightCost());
                	}
                	break;
                case "4":
                    //Sorts by Destination
                	if(runningFlights != null) {
                		Collections.sort(runningFlights, new Flight.SortFlightDestination());
                	}
                    break;
                case "5":
                    //Sorts by Starting Point
                	if(runningFlights != null) {
                		Collections.sort(runningFlights, new Flight.SortFlightStart());
                	}
                    break;
                case "-1":
                    //exits current menu
                	runningPast = false;
                    break;
                default:
                    //all other inputs are irrelevant for this menu
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }
    /**
     * Handles the menu navigation for managing the available flights
     */
    private void availableFlights() {
    	boolean runningAvaiable = true;
        String inpustAvaiable = "";
        List<Flight> theAvaiableFlights = this.user.getAvailableFlights();
        Collections.sort(theAvaiableFlights, new Flight.SortFlightCost());
        while(runningAvaiable) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            for(Flight f : theAvaiableFlights) {
            	 System.out.printf("|"+f.toString()+" |");
            }
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.println("|  Select an Option:                                      |");
            System.out.println("|     1) Add to Avaible flights                           |");
            System.out.println("|     2) Remove Avaible flight                            |");
            System.out.println("|     3) Sort Avaible flights by cost (default)           |");
            System.out.println("|     4) Sort Avaible flights by Destination              |");
            System.out.println("|     5) Sort Avaible flights by StartingLocation         |");
            System.out.println("|    -1) To go back                                       |");
            System.out.println("|                                                         |");
            System.out.println("+---------------------------------------------------------+");
            
            //waits for user to give an input
            if(in.hasNext())
            	inpustAvaiable = in.next();
           
            switch (inpustAvaiable){
            case "1":
            	//add Airline
                System.out.println("|          Enter in an number of seats                     |");
                int seatNumber = 0;
                if(in.hasNextInt()){
                	seatNumber = in.nextInt();}
                System.out.println("|   Enter FlightNumber (Example: ABC123) first 3 letters of airline, and unique 3 number   |");
                String flightnumber = "";
                if(in.hasNext()) {
                	flightnumber = in.next();
                	boolean notUnique = false;
                	for(Flight f : theAvaiableFlights) {
                		if(flightnumber == f.getFlightnumber()) {
                			System.out.println("|    The Flight number was not unique                     |");
                			notUnique = true;
                		}
                	}
                	if(notUnique) {
                		break;}
                }
                String date = "";
                System.out.println("| Enter Date   format => 11282000 => Nov 28th 2000     |");
                if(in.hasNext()) {
                	date = in.next();}
                String time = "";
                System.out.println("| Enter Time   format => 14:23    => 2:23 pm           |");
                if(in.hasNext()) {
                	time = in.next();}
                String startingLocation = "";
                System.out.println("|             Enter Starting location                  |");
                if(in.hasNext()) {
                	startingLocation = in.next();}
                String endingLocation = "";
                System.out.println("|              Enter Ending location                   |");
                if(in.hasNext()) {
                	endingLocation = in.next();}
                double cost = 0.0;
                System.out.println("|          Enter Ending Cost (example: 25.00)          |");
                if(in.hasNextDouble()) {
                	cost = in.nextDouble();}
                ArrayList<String> aLLayovers = new ArrayList<>();
                System.out.println("|List of Layovers by spaces (Example: Alabama Indiana )|");
                String myLayovers = "";
                if(in.hasNext()) {
					myLayovers = in.nextLine();
                }
                Scanner linescanner = new Scanner(myLayovers);
                while(linescanner.hasNext()) {
                	aLLayovers.add(in.next());
                }
                linescanner.close();
                String[] layovers = new String[aLLayovers.size()];
                layovers = aLLayovers.toArray(layovers);
                int flightTime = 0;
                System.out.println("|          Enter integer for flight time               |");
                if(in.hasNextInt()) {
                	flightTime = in.nextInt();
                }
                int miles = 0;
                System.out.println("|          Enter integer for miles                     |");
                if(in.hasNext()) {
                	miles = in.nextInt();
                }
                Airline myAirline = this.user;
            	Flight addedFlight = new Flight(flightnumber, seatNumber, date, time,
            			startingLocation, endingLocation, cost, layovers, flightTime,miles, myAirline.getName());
            	theAvaiableFlights.add(addedFlight);
            	this.user.setAvailableFlights(theAvaiableFlights);
            	System.out.println("|                     Success                          |");
                break;
            case "2":
            	//removes from available flight
            	 System.out.println("+---------------------------------------------------------+");
                 System.out.println("|          Enter in an Airline Flight Number              |");
                 String thisFliNum1 = "";
                 if(in.hasNext())
                	 thisFliNum1 = in.next();
                 boolean flifound1 = false;
                 int iter1 = -1;
                 for(int i = 0; i < theAvaiableFlights.size(); i++) {
                	 if(theAvaiableFlights.get(i).getFlightnumber().equals(thisFliNum1)) {
                		 iter1 = i;
                		 flifound1 = true;
                	 }
                 }
                 if(flifound1) {
                	 theAvaiableFlights.remove(iter1);
                	 this.user.setAvailableFlights(theAvaiableFlights);;
                	 System.out.println("|                   Sucessful                              |");
                 }
                 else {
                	 System.out.println("|       Flight is not in Available Flights                 |");
                 }
                break;
            case "3":
                //Sorts by Price
            	Collections.sort(theAvaiableFlights, new Flight.SortFlightCost());
                break;
            case "4":
                //Sorts by Destination
            	Collections.sort(theAvaiableFlights, new Flight.SortFlightDestination());
                break;
            case "5":
                //Sorts by Starting Point
            	Collections.sort(theAvaiableFlights, new Flight.SortFlightStart());
                break;
            case "-1":
                //exits current menu
            	runningAvaiable = false;
                break;
            default:
                //all other inputs are irrelevant for this menu
                System.out.println("Invalid Choice.");
                break;
            }
        }
    }
}
