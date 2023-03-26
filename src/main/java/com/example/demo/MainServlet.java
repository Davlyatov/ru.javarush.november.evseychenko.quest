package com.example.demo;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

@WebServlet(name = "MainServlet", value = "/game")
public class MainServlet extends HttpServlet {

    private String ip;
    private String name;
    private int gameCount = 1;
    Questions questions = new Questions();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        takeAttributes();
        req.setAttribute("name", name);
        req.setAttribute("ip", ip);
        req.setAttribute("gameCount", gameCount);
        if (req.getParameter("restart") != null) {
            restart(req, resp);
        }
        String answer = req.getParameter("question");
        System.out.println(answer);
        if (answer == null) {
            resp.getWriter().println("<script type='text/javascript'>alert('Нужно выбрать вариант ответа')</script>");
            return;
        }
        switch (answer) {
            case "pickUp":
                req.removeAttribute("question");
                req.setAttribute("question", questions.questions.get("climbOrNot"));
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            case "dontPickUp":
                req.removeAttribute("question");
                req.setAttribute("question", questions.questions.get("loseAfterStart"));
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            case "climb":
                req.removeAttribute("question");
                req.setAttribute("question", questions.questions.get("lieOrNot"));
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            case "dontClimb":
                req.removeAttribute("question");
                req.setAttribute("question", questions.questions.get("loseAfterNotClimb"));
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            case "dontLie":
                req.removeAttribute("question");
                req.setAttribute("question", questions.questions.get("win"));
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            case "lie":
                req.removeAttribute("question");
                req.setAttribute("question", questions.questions.get("loseAfterLie"));
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    private void restart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("question", questions.questions.get("startQuestion"));
        gameCount++;
        req.setAttribute("gameCount", gameCount);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void takeAttributes() throws UnknownHostException {
        ip = String.valueOf(Inet4Address.getLocalHost());
        String[] tempIp = ip.split("/");
        ip = tempIp[1];
        name = tempIp[0];
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        takeAttributes();
        req.setAttribute("name", name);
        req.setAttribute("ip", ip);
        req.setAttribute("gameCount", gameCount);
        req.setAttribute("question", questions.questions.get("startQuestion"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
