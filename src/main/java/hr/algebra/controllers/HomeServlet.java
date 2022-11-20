package hr.algebra.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
    private String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        value = config.getInitParameter("test");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        req.setAttribute("Prezime", "This is may prezime");
        req.getSession().setAttribute("Ime", "This is my name");
        req.getSession().setAttribute("res", 50);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Item 1 t");
        strings.add("Item 2 t");
        strings.add("Item 3 t");

        req.getSession().setAttribute("list", strings);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home/Home.jsp");
        requestDispatcher.forward(req, res);
    }
}
