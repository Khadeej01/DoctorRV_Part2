<%@ page import="java.util.List, com.Model.Appointment" %>
<%
    List<Appointment> appointments = (List<Appointment>) request.getAttribute("listAppointments");
%>

<table class="table-auto">
    <thead>
    <tr>
        <th>Patient ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Doctor</th>
        <th>Date</th>
        <th>Motif</th>
    </tr>
    </thead>
    <tbody>
    <% if (appointments != null) {

        for (Appointment appointment : appointments) { %>
    <tr>
        <td><%= appointment.getPatient().getUsername() %></td>
        <td><%= appointment.getPatient().getEmail() %></td>
        <td><%= appointment.getPatient().getTelephone() %></td>
        <td><%= appointment.getDoctorId() %></td>

        <td><%= appointment.getDate() %></td>
        <td><%= appointment.getMotif() %></td>
    </tr>
    <% } } else { %>
    <tr>
        <td colspan="6">Aucun rendez-vous trouvé.</td>
    </tr>
    <% } %>
    </tbody>
</table>
