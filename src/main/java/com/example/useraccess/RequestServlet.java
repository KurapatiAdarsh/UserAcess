package com.example.useraccess;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String softwareId = request.getParameter("softwareId");
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");
        String username = (String) request.getSession().getAttribute("username");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username); // Replace with actual user ID logic
            statement.setInt(2, Integer.parseInt(softwareId));
            statement.setString(3, accessType);
            statement.setString(4, reason);
            statement.executeUpdate();
            response.sendRedirect("requestAccess.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("requestAccess.jsp");
        }
    }
}
