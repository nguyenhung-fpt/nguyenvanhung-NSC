package com.example.nguyenvanhungt2009.servlet;

import com.example.nguyenvanhungt2009.dao.UserDao;
import com.example.nguyenvanhungt2009.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        UserDao dao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = dao.getUser(username, password); //'' or 1=1--
        if (user == null) {
            response.sendRedirect("index.jsp");
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}

