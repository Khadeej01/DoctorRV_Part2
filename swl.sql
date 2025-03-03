
CREATE database RVDoctor;
use RVDoctor ;
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telephone VARCHAR(20),
    password VARCHAR(255) NOT NULL,
    role ENUM('PATIENT', 'DOCTOR') NOT NULL
);

CREATE TABLE doctors (
    doc_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE,
    specialisation VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
