/** User class, superclass for Customer & Airline
 * Made for C212 SP20 for the final project.
 * @author Team 27
 */
public class User {
    private String username;
    private String password;
    private String type;

    public User(String username, String password, String type) {
        //Creates new user
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType(){ return type; }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean checkLogin(String username, String pass){
        return (this.username.equals(username) && this.password.equals(pass));
    }

}
