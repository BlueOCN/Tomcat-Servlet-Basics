package com.blueocn.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/search")
public class SearchServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //Collect search string from the form
        String searchString = req.getParameter("search");

        // Call DAO layer and get all products for search criteria

        // Write the products data back to the client browser

    }
}
