package com.example.web_appp;

import java.io.*;
import java.security.ProtectionDomain;

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
         // or we can use response.sendDirect("login.jsp"); we can use this as well

        // something change
        // jouj chimouat
        // again something will change
        // version control test
    }

    protected void doPost ( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        String first_input = request.getParameter("first_number");
        String second_input = request.getParameter("second_number");

        int first_number = Integer.parseInt(first_input);
        int second_number = Integer.parseInt(second_input);

        request.setAttribute("num1" , first_number );
        request.setAttribute("num2" , second_number );
        request.setAttribute("result" , first_number + second_number );

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}