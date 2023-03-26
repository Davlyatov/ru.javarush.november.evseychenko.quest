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
    private String defaultQuestion = "<h1>Ты потерял память.</h1>\n" +
            "<p>     Принять вызов НЛО?</p>" +
            "<form method=\"post\">\n" +
            "<input id=\"yes\" value=\"pickUp\" type=\"radio\" name=\"question\">\n" +
            "<label for=\"yes\">Принять вызов</label><br>\n" +
            "<input id=\"no\" value=\"dontPickUp\" type=\"radio\" name=\"question\">\n" +
            "<label for=\"no\">Отклонить вызов</label><br>\n" +
            "<input type = \"submit\" value=\"Ответить на вопрос\" name = \"takeACall\">\n" +
            "</form>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        takeAttributes();
        req.setAttribute("name", name);
        req.setAttribute("ip", ip);
        req.setAttribute("gameCount", gameCount);
        if (req.getParameter("restart")!=null) {
            restart(req, resp);
        } else if (req.getParameter("question").equals("pickUp")) {
            req.removeAttribute("question");
            req.setAttribute("question", "<h1>Ты принял вызов</h1>\n" +
                    "<p>     Поднимаешься на мостик к капитану?</p>" +
                    "<form method=\"post\">\n" +
                    "<input id=\"yes\" value=\"climb\" type=\"radio\" name=\"question\">\n" +
                    "<label for=\"yes\">Поднятся на мостик</label><br>\n" +
                    "<input id=\"no\" value=\"dontClimb\" type=\"radio\" name=\"question\">\n" +
                    "<label for=\"no\">Отказаться подниматься на мостик</label><br>\n" +
                    "<input type = \"submit\" value=\"Ответить на вопрос\" name = \"takeACall\">\n" +
                    "</form>");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if (req.getParameter("question").equals("dontPickUp")) {
            req.removeAttribute("question");
            req.setAttribute("question", "<p>Ты отклонил вызов. Поражение.</p>" +
                    "<form method=\"post\">\n" +
                    "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                    "</form>");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if (req.getParameter("question").equals("climb")) {
            req.removeAttribute("question");
            req.setAttribute("question", "<h1>Ты поднялся на мостик</h1>\n" +
                    "<p>     Ты кто?</p>" +
                    "<form method=\"post\">\n" +
                    "<input id=\"yes\" value=\"dontLie\" type=\"radio\" name=\"question\">\n" +
                    "<label for=\"yes\">Рассказать правду о себе</label><br>\n" +
                    "<input id=\"no\" value=\"lie\" type=\"radio\" name=\"question\">\n" +
                    "<label for=\"no\">Соглать о себе</label><br>\n" +
                    "<input type = \"submit\" value=\"Ответить на вопрос\" name = \"takeACall\">\n" +
                    "</form>");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if (req.getParameter("question").equals("dontClimb")) {
            req.removeAttribute("question");
            req.setAttribute("question", "<p>Ты не пошел на переговоры. Поражение.</p>" +
                    "<form method=\"post\">\n" +
                    "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                    "</form>");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if (req.getParameter("question").equals("dontLie")) {
            req.removeAttribute("question");
            req.setAttribute("question", "<h1>Тебя вернули домой</h1>\n" +
                    "<p>     ПОБЕДА</p>" +
                    "<form method=\"post\">\n" +
                    "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                    "</form>");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else if (req.getParameter("question").equals("lie")) {
            req.removeAttribute("question");
            req.setAttribute("question", "<p>Твою ложь разоблачили. Поражение.</p>" +
                    "<form method=\"post\">\n" +
                    "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                    "</form>");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    private void restart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("question", defaultQuestion);
        gameCount++;
        req.setAttribute("gameCount", gameCount);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
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
        req.setAttribute("question", defaultQuestion);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
