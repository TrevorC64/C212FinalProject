import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Airline extends User implements Saveable{
    private String name;
    private List<Flight> availableFlights;
    private List<Flight> pastFlights;
    private List<String> blacklist;
    private List<String> reviewable;

    public Airline(String username, String password, String name) {
        super(username, password, "Airline");
        this.name = name;
        this.availableFlights = new ArrayList<>();
        this.blacklist = new ArrayList<>();
        this.reviewable = new ArrayList<>();
    }

    public Airline(){
        super("a","a","Airline");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(List<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public List<Flight> getPastFlights() {
        return pastFlights;
    }

    public void setPastFlights(List<Flight> pastFlights) {
        this.pastFlights = pastFlights;
    }
    
    public List<String> getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(List<String> blacklist) {
		this.blacklist = blacklist;
	}
	public void updateAvailableFlights(Flight updatedFlight) {
		for(int i = 0; i < this.availableFlights.size(); i++) {
			if(this.getAvailableFlights().get(i).getFlightnumber().equalsIgnoreCase(updatedFlight.getFlightnumber())) {
				this.availableFlights.set(i, updatedFlight);
			}
		}
			
	}

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", availableFlights=" + availableFlights +
                ", pastFlights=" + pastFlights +
                ", blacklist=" + blacklist +
                ", reviewable=" + reviewable +
                '}';
    }

    @Override
    public void save() {
        super.save();
    }
    
    //Sorts AirlInes in a List by alphabetical name.
    public class AirLineNameSorter implements Comparator<Airline>{

		@Override
		public int compare(Airline o1, Airline o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
    //Sorts Airlines in a list by number of available Flights
    public class AirLineNumberOfavailableFlightsSorter implements Comparator<Airline>{

		@Override
		public int compare(Airline o1, Airline o2) {
			int length1 = o1.availableFlights.size();
			int length2 = o2.availableFlights.size();
			return Integer.compare(length1, length2);
		}
    }
}

