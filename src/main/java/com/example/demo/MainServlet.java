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
        //После поворота налево
        if (req.getParameter("turnLeft") != null) {
            req.setAttribute("question", questions.questions.get("turnLeftNextQuestion"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("jumpInto") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterJump"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("continueOnYourWay") != null) {
            req.setAttribute("question", questions.questions.get("continueWayWithWin"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("goBackAnotherWay") != null) {
            req.setAttribute("question", questions.questions.get("getBackWithLose"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("getBack") != null) {
            req.setAttribute("question", questions.questions.get("getBackBeforeRiver"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("buildATent") != null) {
            req.setAttribute("question", questions.questions.get("loseAfterBuild"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("dontStop") != null) {
            req.setAttribute("question", questions.questions.get("continueWayWithWin"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        //После поворота направо
        if (req.getParameter("turnRight") != null) {
            req.setAttribute("question", questions.questions.get("turnRightNextQuestion"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("ignore") != null) {
            req.setAttribute("question", questions.questions.get("dontCheckWithLose"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("checkTheBushes") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterCheckBushes"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("checkHouse") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterCheckHouse"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("findKey") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterKey"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("openLeft") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterLeftDoor"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("openRight") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterRightDoor"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        //Сюда про книгу
        if (req.getParameter("findBook") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterBook"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("openBook") != null) {
            req.setAttribute("question", questions.questions.get("questionAfterOpen"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("useSpells") != null) {
            req.setAttribute("question", questions.questions.get("winAfterSpells"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if (req.getParameter("dontUseSpells") != null) {
            req.setAttribute("question", questions.questions.get("winAfterNotSpells"));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    private void restart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("question", questions.questions.get("defaultQuestion"));
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
        req.setAttribute("question", questions.questions.get("defaultQuestion"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
