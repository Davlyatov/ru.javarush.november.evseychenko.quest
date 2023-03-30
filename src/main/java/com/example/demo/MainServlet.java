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
        String nextQuestion;
        if (req.getParameter("restart") != null) {
            restart(req, resp);
        }

        //После поворота налево
        if (req.getParameter("turnLeft") != null) {
            nextQuestion = "turnLeftNextQuestion";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("jumpInto") != null) {
            nextQuestion = "questionAfterJump";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("continueOnYourWay") != null) {
            nextQuestion = "continueWayWithWin";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (req.getParameter("goBackAnotherWay") != null) {
            nextQuestion = "getBackWithLose";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (req.getParameter("getBack") != null) {
            nextQuestion = "getBackBeforeRiver";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("buildATent") != null) {
            nextQuestion = "loseAfterBuild";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (req.getParameter("dontStop") != null) {
            nextQuestion = "continueWayWithWin";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }

        //После поворота направо
        if (req.getParameter("turnRight") != null) {
            nextQuestion = "turnRightNextQuestion";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("ignore") != null) {
            nextQuestion = "dontCheckWithLose";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (req.getParameter("checkTheBushes") != null) {
            nextQuestion = "questionAfterCheckBushes";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("checkHouse") != null) {
            nextQuestion = "questionAfterCheckHouse";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }

        //Продолжение с ключом
        if (req.getParameter("findKey") != null) {
            nextQuestion = "questionAfterKey";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("openLeft") != null) {
            nextQuestion = "questionAfterLeftDoor";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (req.getParameter("openRight") != null) {
            nextQuestion = "questionAfterRightDoor";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }

        //Подолжение с книгой
        if (req.getParameter("findBook") != null) {
            nextQuestion = "questionAfterBook";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("openBook") != null) {
            nextQuestion = "questionAfterOpen";
            req = setNextQuestion(req, nextQuestion);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (req.getParameter("useSpells") != null) {
            nextQuestion = "winAfterSpells";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (req.getParameter("dontUseSpells") != null) {
            nextQuestion = "winAfterNotSpells";
            req = setRestart(req,nextQuestion);
            getServletContext().getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
    }

    private HttpServletRequest setRestart(HttpServletRequest req, String nextQuestion) {
        req.setAttribute("header1", questions.questionsMap.get(nextQuestion).get("header"));
        req.setAttribute("p1", questions.questionsMap.get(nextQuestion).get("p1"));
        req.setAttribute("p2", questions.questionsMap.get(nextQuestion).get("p2"));
        req.setAttribute("restartBtn", questions.questionsMap.get(nextQuestion).get("restartBtn"));
        if (questions.questionsMap.get(nextQuestion).containsKey("img")){
            req.setAttribute("img", questions.questionsMap.get(nextQuestion).get("img"));
        }
        return req;
    }

    private HttpServletRequest setNextQuestion(HttpServletRequest req, String nextQuestion) {
        req.setAttribute("header1", questions.questionsMap.get(nextQuestion).get("header"));
        req.setAttribute("img", questions.questionsMap.get(nextQuestion).get("img"));
        req.setAttribute("question", questions.questionsMap.get(nextQuestion).get("question"));
        req.setAttribute("answer1", questions.questionsMap.get(nextQuestion).get("answer1"));
        req.setAttribute("answer2", questions.questionsMap.get(nextQuestion).get("answer2"));
        return req;
    }

    private void restart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req = setDefQuestion(req);
        gameCount++;
        req.setAttribute("gameCount", gameCount);
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    private HttpServletRequest setDefQuestion(HttpServletRequest req) {
        req.setAttribute("header1", questions.questionsMap.get("defaultQuestion").get("header"));
        req.setAttribute("img", questions.questionsMap.get("defaultQuestion").get("img"));
        req.setAttribute("question", questions.questionsMap.get("defaultQuestion").get("question"));
        req.setAttribute("answer1", questions.questionsMap.get("defaultQuestion").get("answer1"));
        req.setAttribute("answer2", questions.questionsMap.get("defaultQuestion").get("answer2"));
        return req;
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
        req = setDefQuestion(req);
        req.setAttribute("name", name);
        req.setAttribute("ip", ip);
        req.setAttribute("gameCount", gameCount);
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}
