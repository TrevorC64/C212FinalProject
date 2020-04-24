import java.util.List;
import java.util.Scanner;

public class CustomerDriver {
    List<Customer> customers;
    List<Airline> airlines;
    Scanner in;
    Customer user;

    public CustomerDriver(List<Customer> customers, List<Airline> airlines, Scanner in, Customer customer) {
        this.customers = customers;
        this.airlines = airlines;
        this.in = in;
        this.user = customer;
    }

    public void mainMenu(){
        System.out.println("MainMenuCalled");
        boolean running = true;
        String input = "";
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
            if(in.hasNext())
                input = in.next();
            switch (input){
                case "1":
                    this.avaliableFlights();
                    break;
                case "2":
                    this.bookedFlights();
                    break;
                case "3":
                    this.pastFlights();
                    break;
                case "4":
                    this.reviews();
                    break;
                case "-1":
                    System.out.println("AASDE");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice.");
                    break;

            }
        }
    }

    private void pastFlights() {
    }

    private void reviews() {
    }

    private void bookedFlights() {
    }

    private void avaliableFlights() {
    }
}
