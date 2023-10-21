package tdtu.edu.vn.lab05.Model;

public class user {
    protected int id;
    protected String email;
    protected String username;
    protected  String password;

    public user(String email, String username, String password){
        super();
        this.email =email;
        this.username= username;
        this.password = password;
    }
    public user(int id, String email, String username, String password){
        super();
        this.id = id;
        this.email =email;
        this.username= username;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String name) {
        this.username = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
