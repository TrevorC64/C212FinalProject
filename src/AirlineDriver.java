import java.util.List;
import java.util.Scanner;

public class AirlineDriver {
    List<Customer> customers;
    List<Airline> airlines;
    Scanner in;
    Airline user;

    public AirlineDriver(List<Customer> customers, List<Airline> airlines, Scanner in, Airline airline) {
        this.customers = customers;
        this.airlines = airlines;
        this.in = in;
        this.user = airline;
    }

    public void mainMenu(){
        boolean running = true;
        String input = "";
        while(running) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                                                         |");
            System.out.printf("| Welcome %15s User   Logout (-1) |%n", user.getUsername());
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
            if(in.hasNext())
                input = in.next();
            switch (input){
                case "1":
                    this.avaliableFlights();
                    break;
                case "2":
                    this.pastFlights();
                    break;
                case "3":
                    this.reviews();
                    break;
                case "4":
                    this.rewards();
                    break;
                case "5":
                    this.blacklist();
                    break;
                case "-1":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice.");
                    break;

            }
        }
    }

    private void blacklist() {
    }

    private void rewards() {
    }

    private void reviews() {
    }

    private void pastFlights() {
    }

    private void avaliableFlights() {
    }

}
