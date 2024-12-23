package com.example.web_appp;

import java.io.*;
import java.security.ProtectionDomain;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet. annotation.*;


@WebServlet(name = "HelloServlet", value ={ "/url_servlet"  , "*.php"})
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
         dispatcher.forward(request, response);


         //response.sendDirect("login.jsp");
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first_input = request.getParameter("first_number");
        String second_input = request.getParameter("second_number");

        int first_number = Integer.parseInt(first_input);
        int second_number = Integer.parseInt(second_input);


        int sum = first_number + second_number;

        request.setAttribute("num1", first_number);
        request.setAttribute("num2", second_number);
        request.setAttribute("somme", sum);

        try {
            // Create a database object and insert the operation into the database
            database db = new database();
            db.add_operation(first_number, second_number, sum);
        } catch (SQLException e) {
            e.printStackTrace(); // Log full SQL exception
            request.setAttribute("error", "Database error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Log full ClassNotFoundException
            request.setAttribute("error", "Class not found: " + e.getMessage());
        }

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }

}