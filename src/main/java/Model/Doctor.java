package Model;



import Model.User;

public class Doctor extends User {
    private String specialisation;

    // Constructeur complet
    public Doctor(int user_id, String fullname, String email, String telephone, String password, String specialisation) {
        super(user_id, fullname, email, telephone, password, "DOCTOR");
        this.specialisation = specialisation;
    }

    // Constructeur sans password (si non nécessaire)
    public Doctor(int user_id, String fullname, String email, String telephone, String specialisation) {
        super(user_id, fullname, email, telephone);
        this.role = "DOCTOR";
        this.specialisation = specialisation;
    }

    // Constructeur sans user_id (pour la création d'un nouveau docteur)
    public Doctor(String fullname, String email, String telephone, String password, String specialisation) {
        super(fullname, email, telephone);
        this.password = password;
        this.role = "DOCTOR";
        this.specialisation = specialisation;
    }

    // Getters et Setters
    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialisation='" + specialisation + '\'' +
                ", " + super.toString() +
                '}';
    }
}
