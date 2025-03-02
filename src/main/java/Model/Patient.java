package Model;

public class Patient extends User {

    // Constructeur avec tous les attributs
    public Patient(int user_id, String fullname, String email, String telephone, String password, String role) {
        super(user_id, fullname, email, telephone, password, role);
    }

    // Constructeur sans password ni role (par défaut "PATIENT")
    public Patient(int user_id, String fullname, String email, String telephone) {
        super(user_id, fullname, email, telephone);
    }

    // Constructeur sans ID (pour création d'un nouveau patient)
    public Patient(String fullname, String email, String telephone) {
        super(fullname, email, telephone);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "user_id=" + user_id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                "} " + super.toString();
    }
}
