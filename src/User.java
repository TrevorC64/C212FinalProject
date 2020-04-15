public class User implements Saveable {
    private String username;
    private String password;

    public User(String username, String password) {
        //Creates new user
        this.username = username;
        this.password = password;
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

    public void save(){
        //TODO Implement save function for all Users
        //will be ran to save each user's information
    }


}
