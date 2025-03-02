<%--
  Created by IntelliJ IDEA.
  User: Dev
  Date: 01/03/2025
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    <label>Nom complet :</label>
    <input type="text" name="fullname" required><br>

    <label>Email :</label>
    <input type="email" name="email" required><br>

    <label>Téléphone :</label>
    <input type="text" name="telephone" required><br>

    <label>Mot de passe :</label>
    <input type="password" name="password" required><br>

    <label>Rôle :</label>
    <select name="role" id="role">
        <option value="PATIENT">Patient</option>
        <option value="DOCTOR">Docteur</option>
    </select><br>

    <label>Spécialisation (si Docteur) :</label>
    <input type="text" name="specialisation"><br>

    <button type="submit">S'inscrire</button>
</form>
<a href="LogoutServlet" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
    Logout
</a>


</body>
</html>
