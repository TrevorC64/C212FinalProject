public class Ticket {
    private String flightNumber;
    private int seat;
    private double cost;
    private boolean available;
    private String customerUserName; //null if not purchased
    private int miles;

    public Ticket(String flightNumber, int seat, double cost, boolean available, String customerUserName, int miles) {
        this.flightNumber = flightNumber;
        this.seat = seat;
        this.cost = cost;
        this.available = available;
        this.customerUserName = customerUserName;
        this.miles = miles;
    }

    public String getflightNumber() {
        return flightNumber;
    }

    public void setflightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCustomeruserName() {
        return customerUserName;
    }

    public void setCustomer(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void updateMilePoints(){
        //TODO implement MilePoint System
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "flightNumber=" + flightNumber +
                ", seat=" + seat +
                ", cost=" + cost +
                ", available=" + available +
                ", customerUserName=" + customerUserName +
                ", miles=" + miles +
                '}';
    }


}
