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
            System.out.println("|     3) View Past flights                                |");
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
    }

    /**
     * Handles the menu navigation for managing the Customer's reviews
     */
    private void reviews() {
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
