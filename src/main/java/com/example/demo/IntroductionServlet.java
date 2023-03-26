package com.example.demo;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Inet4Address;

@WebServlet(name = "IntroductionServlet", value = "/introduction")
public class IntroductionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("start") != null) {
            resp.sendRedirect("/game");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = String.valueOf(Inet4Address.getLocalHost());
        String[] tempName = name.split("/");
        name = tempName[0];
        request.setAttribute("name", name);
        getServletContext().getRequestDispatcher("/introduction.jsp").forward(request, response);
    }
}
