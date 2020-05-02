import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Run this main() to run the program
 * Made for C212 SP20 for the final project.
 * @author Team 27
 */
public class AirlineSystemDriver {
    //These Lists are used for the login system
    private List<Customer> customers;
    private List<Airline> airlines;
    private List<Flight> flights;
    private List<Ticket> tickets;

    //scanner to be used by every driver
    Scanner in;

    //current logged in user, used for backend in the login() method
    User loggedInUser;

    /**
     * Constructor
     */
    public AirlineSystemDriver() {
        //gather all information by reading through /data
        //TODO Implement File Reading System

        //load all users first
        this.in = new Scanner(System.in);

        this.customers = new ArrayList<>();
        this.airlines = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.tickets = new ArrayList<>();

        //default values below to avoid NullPointer
        this.loggedInUser = new User("a","a","a");
    }
    public void populateTheSystem(String filepath) {
    	try{
    	    Scanner input = new Scanner(new File(filepath))
    	}
    	catch(FileNotFoundException e) {
    		System.out.println("Incorrect file path, Please try with a different file");
    	}
    }
    public void savingTheSystem(String filepath) {
    	try(PrintWriter saving = new PrintWriter(new File(filepath))){
    		for(Customer c : this.customers) {
    			saving.println(c);
    		}
    		saving.println();
    		for(Airline a : this.airlines) {
    			saving.println(a);
    		}
    	}
    	catch(Exception e) {
    		System.out.println("Saving error");
    	}
    }
    /**
     * Creates the main menu for the Airline System, quitting this menu exits the program
     */
    public void mainMenu(){
        //running used to section off sub menu selections
        boolean running = true;

        while(running){
            System.out.println("+----------------------------------+");
            System.out.println("| Select an Option:                |");
            System.out.println("|    1) Login                      |");
            System.out.println("|    2) Create New User            |");
            System.out.println("|    3) Help                       |");
            System.out.println("|    4) Quit                       |");
            System.out.println("+----------------------------------+");

            //variable to store user's input
            String input = "";

            //wait until user inputs something, then process it
            if (this.in.hasNext()){
                //store user's input in input variable
                input = this.in.next();
            }

            //switch statement to check for user inputs the program cares about
            switch (input){
                case "1":
                    //login selection
                    this.login();
                    break;
                case "2":
                    //create new user selection
                    this.create();
                    break;
                case "3":
                    //pull up help menu
                    this.help();
                    break;
                case "4":
                    //exit the program
                    System.out.println("+----------------------------------+");
                    System.out.println("|             Goodbye              |");
                    System.out.println("+----------------------------------+");
                    running = false;
                    break;
                default:
                    //all other responses are irrelevant, so they are handled with default and the user is prompted
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    /**
     * Handles the login menu system
     */
    public void login(){
        //running used to section off sub menu selections
        boolean running = true;
        String user = "";
        String pass = "";

        //prompts user for username
        while(running) {
            System.out.println("+----------------------------------+");
            System.out.println("|Type your username:               |");
            System.out.println("+----------------------------------+");
            if (this.in.hasNext()) {
                user = this.in.next();
                running = false;
            }
        }
        running = true;
        //prompts user for password
        while(running) {
            System.out.println("+----------------------------------+");
            System.out.println("|Type your password:               |");
            System.out.println("+----------------------------------+");
            if (this.in.hasNext()) {
                pass = this.in.next();
                running = false;
            }
        }
        running = true;

        //shows user what has been inputted and asks for confirmation
        while (running) {
            System.out.println("+----------------------------------+");
            System.out.printf("|Username: %-23s |%n", user);
            System.out.printf("|Password: %-23s |%n", pass);
            System.out.println("|Is this correct? (Y/N)            |");
            System.out.println("|                                  |");
            System.out.println("|(-1) to return to main menu.      |");
            System.out.println("+----------------------------------+");

            //waits for user to give an input, then proccesses it
            if (this.in.hasNext()) {
                String input = in.next();

                //if the information is incorrect
                if (input.equals("N") || input.equals("n")) {
                    //login() is called to restart the login process
                    running = false;
                    this.login();
                }

                //if the user correctly inputted their information
                else if (input.equals("Y") || input.equals("y")) {
                    running = false;

                    //first we must verify the user's login credentials
                    if (this.verifyUser(user, pass)) {
                        System.out.println("+----------------------------------+");
                        System.out.println("|Login Success!                    |");
                        System.out.println("+----------------------------------+");
                        System.out.println();

                        //if the user who signed in is an Airline
                        if (this.loggedInUser.getType().equals("Airline")) {

                            //create a new Airline, to be used as a pointer
                            Airline userAirline = new Airline();

                            //look through all Airlines until the airline with the same username appears
                            for (Airline airline : this.airlines) {
                                if (airline.getUsername().equals(user)) {
                                    //shallow copy the Airline
                                    userAirline = airline;
                                }

                            }
                            //create an AirlineDriver to take over the menu navigation
                            AirlineDriver ad = new AirlineDriver(this.customers, this.airlines, this.in, userAirline);

                            //launch the AirlineDriver's main menu
                            ad.mainMenu();
                        } else if (this.loggedInUser.getType().equals("Customer")) {
                            //if the user is a Customer

                            //create a new Customer, to be used as a pointer
                            Customer userCustomer = new Customer();

                            //look through all Customers until the Customer with the same username appears
                            for (Customer customer : this.customers
                            ) {
                                if (customer.getUsername().equals(user)) {
                                    //shallow copy the Customer
                                    userCustomer = customer;
                                }
                            }
                            //create a CustomerDriver to take over the menu navigation
                            CustomerDriver cd = new CustomerDriver(this.customers, this.airlines, this.in, userCustomer);

                            //launch the CustomerDriver's main menu
                            cd.mainMenu();
                        }
                    } else //if the user inputs the incorrect login credentials
                    {
                        //Notifies the user that the login credentials were incorrect
                        System.out.println("+----------------------------------+");
                        System.out.println("|Login failed, try again!          |");

                        //login() is called to restart the login process
                        this.login();
                    }
                } else if (input.equals("-1")) {
                    //the user wants to go back to the main menu
                    running = false;
                } else {
                    //all other inputs are irrelevant for this menu
                    System.out.println("Invalid Choice.");

                    //login() is called to restart the login process
                    this.login();
                }
            }
        }
    }

    /**
     * Handles the manu system to create a new user
     */
    public void create(){
        //running used to section off sub menu selections
        boolean running = true;

        //instantiate variables to be used in the creation of a new User
        String user = "";
        String pass = "";
        String type = "";
        String name = "";

        //prompts user for a username
        while (running) {
            System.out.println("+----------------------------------+");
            System.out.println("|Type a username:                  |");
            System.out.println("+----------------------------------+");
            if(this.in.hasNext()){
                user = this.in.next();
                running = false;
            }
        }
        running = true;

        //prompts user for a password
        while (running){
            System.out.println("+----------------------------------+");
            System.out.println("|Type a password:                  |");
            System.out.println("+----------------------------------+");
            if(this.in.hasNext()){
                pass = this.in.next();
                running = false;
            }
        }
        running = true;

        //asks user if it's a Customer or an Airline
        while (running){
            System.out.println("+----------------------------------+");
            System.out.println("|What Type of account is this:     |");
            System.out.println("|    1) Customer                   |");
            System.out.println("|    2) Airline                    |");
            System.out.println("+----------------------------------+");

            if(this.in.hasNext()){
                String input = in.next();
                switch (input){
                    case "1":
                        //the user is a customer
                        type = "Customer";
                        running = false;
                        break;
                    case "2":
                        //the user is an Airline
                        type = "Airline";
                        running = false;
                        break;
                    default:
                        //all other inputs are irrelevant for this menu
                        System.out.println("Invalid Selection.");
                        break;
                }
            }
        }

        //if the user specified they are an Airline
        if(type.equals("Airline")){
            //ask for the Airline's name
            running = true;
            while (running){
                System.out.println("+-------------------------------------+");
                System.out.println("|Type your Airline's name (no spaces):|");
                System.out.println("+-------------------------------------+");

                if(this.in.hasNext()){
                    //store their response in name
                    name = this.in.next();
                    running = false;
                }
            }
        }
        running = true;

        //shows the user what has been inputted and asks for confirmation
        while(running) {
            System.out.println("+----------------------------------+");
            System.out.printf("|Username: %-23s |%n", user);
            System.out.printf("|Password: %-23s |%n", pass);
            System.out.printf("|Type: %-18s |%n", type);
            if (!name.equals(""))
                System.out.printf("|Name: %-23s |%n", name);
            System.out.println("|Is this correct? (Y/N)            |");
            System.out.println("|                                  |");
            System.out.println("|(-1) to return to main menu.      |");
            System.out.println("+----------------------------------+");

            //waits for the user to give an input, then proccesse it
            if (this.in.hasNext()) {
                String input = this.in.next();

                //if the information is incorrect
                if (input.equals("N") || input.equals("n")) {
                    //create() is called to restart the creation process
                    running = false;
                    this.create();
                }

                //if the user correctly inputted their information
                else if (input.equals("Y") || input.equals("y")) {
                    running = false;

                    //if they type of User is an Airline
                    if (type.equals("Airline")) {

                        //create a new Airline with the inputted information
                        Airline airline = new Airline(user, pass, name);

                        //add the Airline to airlines
                        this.airlines.add(airline);

                        //create a new AirlineDriver to take over the menu navigation
                        AirlineDriver ad = new AirlineDriver(this.customers, this.airlines, this.in, airline);

                        //launch the AirlineDriver's main menu
                        ad.mainMenu();
                    } else { //the type of User is a Customer

                        //create a Customer with the inputted information
                        Customer customer = new Customer(user, pass);

                        //add the Customer to customers
                        this.customers.add(customer);

                        //create a new CustomerDriver to take over the menu navigation
                        CustomerDriver cd = new CustomerDriver(this.customers, this.airlines, this.in, customer);

                        //launch the CustomerDriver's main menu
                        cd.mainMenu();
                    }
                } else if(input.equals("-1")){
                    //the user wants to go back to the main menu
                    running = false;
                }
                else {
                    //all other inputs are irrelevant for this menu
                    System.out.println("Invalid Choice.");
                }
            }
        }

    }

    /**
     * Displays a help window to aid the user
     */
    public void help(){
        System.out.println("+----------------------------------+");
        System.out.println("|This Has Yet To Be Implemented    |");
        System.out.println("+----------------------------------+");
    }

    /**
     * This determines if the given User credentials are in the system, ultimately deciding if the user inputted the correct username and password
     * @param username the username that needs to be checked
     * @param pass the password that needs to be checked with the username
     * @return true if the user is already in the system, false if the credentials are incorrect or the user is not in the system
     */
    public boolean verifyUser(String username, String pass){
        //create a new list to contain all of the users
        List<User> users = new ArrayList<>();

        //add the customers to the list
        users.addAll(this.customers);

        //add the airlines to the list
        users.addAll(this.airlines);

        //check each User in users
        for (User user:users) {
            //if the username and password match
            if(user.checkLogin(username,pass)){
                //update loggedInUser
                this.loggedInUser = user;

                //the information was correct and registered in the system
                return true;
            }
        }
        //there us no user with the same username and password in the system
        return false;
    }

    public static void main(String[] args) {
        //TODO Implement user inputs and system navigation
        //this is where the program will be ran
    	// "C:\\Users\\jason\\OneDrive\\Desktop\\AirlineSave.txt"

        //---------------------testing code---------------------

        ArrayList<Customer> cs = new ArrayList<>();
        Customer c1 = new Customer("trejcunn", "coolcool");
        c1.setMilePoints(5000);
        cs.add(c1);
        ArrayList<Airline> als = new ArrayList<>();
        Airline a1 = new Airline("admin", "p", "Delta");
        ArrayList<Flight> availableFlights = new ArrayList<>();
        String[] someLayovers = {"Handover", "Dover"}; 
        Flight f1 = new Flight("DEL130", 5, "11283000", "12:30", "Illinois,Chigago", "Indiana,Indianapolis", 35.00, someLayovers, 200, 230, "Delta");
        availableFlights.add(f1);
        a1.setAvailableFlights(availableFlights);
        als.add(a1);

        //run the program by creating an instance of AirlineSystemDriver
        AirlineSystemDriver airlineDriver = new AirlineSystemDriver();
        airlineDriver.customers = cs;
        airlineDriver.airlines = als;

        //then call mainMenu()
        airlineDriver.mainMenu();
        airlineDriver.in.close();
        airlineDriver.savingTheSystem("C:\\Users\\jason\\OneDrive\\Desktop\\AirlineSave.txt");
       // airlineDriver.populateTheSystem("C:\\Users\\jason\\OneDrive\\Desktop\\AirlineSave.txt");
    }
}
