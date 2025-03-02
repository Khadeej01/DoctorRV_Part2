package Model;

public class User {
    protected int user_id;
    protected String fullname;
    protected String email;
    protected String telephone;
    protected String password;
    protected String role;

    // Constructeur complet
    public User(int user_id, String fullname, String email, String telephone, String password, String role) {
        this.user_id = user_id;
        this.fullname = fullname;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.role = role;
    }

    // Constructeur sans password ni role
    public User(int user_id, String fullname, String email, String telephone) {
        this.user_id = user_id;
        this.fullname = fullname;
        this.email = email;
        this.telephone = telephone;
    }

    // Constructeur sans ID (pour la création d'un utilisateur sans encore d'ID)
    public User(String fullname, String email, String telephone) {
        this.fullname = fullname;
        this.email = email;
        this.telephone = telephone;
    }

    // Getters et Setters
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
