package DAO;

import Model.User;
import Model.Doctor;
import java.sql.*;
import com.Util.DBConnection;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/DoctorRV";
    private static final String USER = "root"; // Remplace par ton user MySQL
    private static final String PASSWORD = "admin"; // Remplace par ton password MySQL

    // Méthode pour obtenir la connexion à la base de données
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Ajouter un utilisateur (Patient ou Médecin)
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users (fullname, email, telephone, password, role) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getTelephone());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());

            stmt.executeUpdate();

            // Récupérer l'ID généré et l'affecter à l'utilisateur
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setUser_id(rs.getInt(1));
            }

            // Si c'est un médecin, on l'ajoute aussi dans la table `doctors`
            if (user instanceof Doctor) {
                addDoctor((Doctor) user);
            }
        }
    }

    // Ajouter un médecin dans la table `doctors`
    private void addDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctors (user_id, specialisation) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, doctor.getUser_id());
            stmt.setString(2, doctor.getSpecialisation());
            stmt.executeUpdate();
        }
    }

    // Récupérer un utilisateur par email (pour login)
    public User getUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                // Vérifier si c'est un médecin et récupérer sa spécialisation
                if (role.equals("DOCTOR")) {
                    String doctorQuery = "SELECT specialisation FROM doctors WHERE user_id = ?";
                    try (PreparedStatement doctorStmt = conn.prepareStatement(doctorQuery)) {
                        doctorStmt.setInt(1, rs.getInt("user_id"));
                        ResultSet doctorRs = doctorStmt.executeQuery();
                        if (doctorRs.next()) {
                            return new Doctor(
                                    rs.getInt("user_id"),
                                    rs.getString("fullname"),
                                    rs.getString("email"),
                                    rs.getString("telephone"),
                                    rs.getString("password"),
                                    doctorRs.getString("specialisation")
                            );
                        }
                    }
                }
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("password"),
                        role
                );
            }
        }
        return null;
    }

    // Vérifier si un utilisateur existe pour l'authentification
    public boolean authenticate(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Retourne true si l'utilisateur existe
        }
    }
    public User validateUser(String username, String password) {
        User user = null;
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role")); // "doctor" ou "patient"
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
}

