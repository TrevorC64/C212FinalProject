import java.io.File;
import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineSystemDriver {
    private List<Customer> customers;
    private List<Airline> airlines;
    private List<Flight> flights;
    private List<Ticket> tickets;
    Scanner in;
    String username;
    User loggedInUser;

    public AirlineSystemDriver() {
        //gather all information by reading through /data
        //TODO Implement File Reading System
        //load all users first
        this.in = new Scanner(System.in);
        this.username = "";
        //TODO add proper Implementation (Reading Saved Data)
        this.customers = new ArrayList<>();
        this.airlines = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.loggedInUser = new User("a","a","a");
    }

    public void mainMenu(){
        boolean running = true;
        while(running){
            System.out.println("+----------------------------------+");
            System.out.println("| Select an Option:                |");
            System.out.println("|    1) Login                      |");
            System.out.println("|    2) Create New User            |");
            System.out.println("|    3) Help                       |");
            System.out.println("|    4) Quit                       |");
            System.out.println("+----------------------------------+");
            String input = "";
            if (this.in.hasNext()){
                input = this.in.next();
            }
            switch (input){
                case "1":
                    this.login();
                    break;
                case "2":
                    this.create();
                    break;
                case "3":
                    this.help();
                    break;
                case "4":
                    System.out.println("+----------------------------------+");
                    System.out.println("|             Goodbye              |");
                    System.out.println("+----------------------------------+");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public void login(){
        boolean running = true;
        String user = "";
        String pass = "";
        while (running) {
            System.out.println("+----------------------------------+");
            System.out.println("|Type your username:               |");
            System.out.println("+----------------------------------+");
            if(this.in.hasNext()){
                user = this.in.next();
                running = false;
            }
        }
        running = true;
        while (running){
            System.out.println("+----------------------------------+");
            System.out.println("|Type your password:               |");
            System.out.println("+----------------------------------+");
            if(this.in.hasNext()){
                pass = this.in.next();
                running = false;
            }
        }
        System.out.println("+----------------------------------+");
        System.out.printf("|Username: %-23s |%n", user);
        System.out.printf("|Password: %-23s |%n", pass);
        System.out.println("|Is this correct? (Y/N)            |");
        System.out.println("|                                  |");
        System.out.println("|(-1) to return to main menu.      |");
        System.out.println("+----------------------------------+");
        if (this.in.hasNext()){
            String input = in.next();
            if (input.equals("N") || input.equals("n")){
                this.login();
            }
            else if(input.equals("Y") || input.equals("y")){
                if(this.verifyUser(user,pass)){
                    System.out.println("+----------------------------------+");
                    System.out.println("|Login Success!                    |");
                    System.out.println("+----------------------------------+");
                    System.out.println();
                    if(this.loggedInUser.getType().equals("Airline")) {
                        Airline userAirline = new Airline();
                        for (Airline airline:this.airlines
                             ) {
                            if(airline.getUsername().equals(user))
                                userAirline = airline;

                        }
                        AirlineDriver ad = new AirlineDriver(this.customers, this.airlines, this.in, userAirline);
                        ad.mainMenu();
                    } else if(this.loggedInUser.getType().equals("Customer")){
                        Customer userCustomer = new Customer();
                        for (Customer customer:this.customers
                        ) {
                            if(customer.getUsername().equals(user))
                                userCustomer = customer;

                        }
                        CustomerDriver cd = new CustomerDriver(this.customers, this.airlines, this.in, userCustomer);
                        cd.mainMenu();
                    }
                }else
                {
                    System.out.println("+----------------------------------+");
                    System.out.println("|Login failed, try again!          |");
                    this.login();
                }
            }
            else if(input.equals("-1")){
                running = false;
            } else{
                System.out.println("Invalid Choice.");
            }
        }
    }

    public void create(){
        boolean running = true;
        String user = "";
        String pass = "";
        String type = "";
        String name = "";
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
                        type = "Customer";
                        running = false;
                        break;
                    case "2":
                        type = "Airline";
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Selection.");
                        break;
                }
            }
        }
        if(type.equals("Airline")){
            running = true;
            while (running){
                System.out.println("+-------------------------------------+");
                System.out.println("|Type your Airline's name (no spaces):|");
                System.out.println("+-------------------------------------+");
                if(this.in.hasNext()){
                    name = this.in.next();
                    running = false;
                }
            }
        }
        running = true;
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
            if (this.in.hasNext()) {
                String input = this.in.next();
                if (input.equals("N") || input.equals("n")) {
                    running = false;
                    this.create();
                } else if (input.equals("Y") || input.equals("y")) {
                    running = false;
                    if (type.equals("Airline")) {
                        Airline airline = new Airline(user, pass, user);
                        this.airlines.add(airline);
                        AirlineDriver ad = new AirlineDriver(this.customers, this.airlines, this.in, airline);
                        ad.mainMenu();
                    } else {
                        Customer customer = new Customer(user, pass);
                        this.customers.add(customer);
                        CustomerDriver cd = new CustomerDriver(this.customers, this.airlines, this.in, customer);
                        cd.mainMenu();
                    }
                } else if(input.equals("-1")){
                    running = false;
                }
                else {
                    System.out.println("Invalid Choice.");
                }
            }
        }

    }

    public void help(){
        System.out.println("+----------------------------------+");
        System.out.println("|This Has Yet To Be Implemented    |");
        System.out.println("+----------------------------------+");
    }

    public boolean verifyUser(String username, String pass){
        List<User> users = new ArrayList<>();
        users.addAll(this.customers);
        users.addAll(this.customers);

        for (User user:users) {
            if(user.checkLogin(username,pass))
                this.loggedInUser = user;
                return true;
        }
        return false;
    }

    public void start(){
        this.mainMenu();
    }

    public static void main(String[] args) {
        //TODO Implement user inputs and system navigation
        //this is where the program will be ran

        ArrayList<Customer> cs = new ArrayList<>();
        Customer c1 = new Customer("trejcunn", "coolcool");
        c1.setMilePoints(5000);
        cs.add(c1);

        ArrayList<Airline> als = new ArrayList<>();
        Airline a1 = new Airline("admin", "p", "Delta");
        als.add(a1);

        AirlineSystemDriver airlineDriver = new AirlineSystemDriver();
        airlineDriver.customers = cs;
        airlineDriver.airlines = als;
        airlineDriver.start();
        airlineDriver.in.close();
    }
}
