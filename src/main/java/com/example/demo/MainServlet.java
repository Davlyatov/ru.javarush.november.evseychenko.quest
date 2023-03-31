package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class MainServlet extends HttpServlet {

    private String ip;
    private String name;
    private int gameCount = 1;
    Questions questions = new Questions();
    public String answer = "";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        takeAttributes();
        req.setAttribute("name", name);
        req.setAttribute("ip", ip);
        req.setAttribute("gameCount", gameCount);
        String nextQuestion;
        if (req.getParameter("answer") != null){
            answer = req.getParameter("answer");
        }

        //После поворота налево
        if (answer.equals("turnLeft")) {
            nextQuestion = "turnLeftNextQuestion";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("jumpInto")) {
            nextQuestion = "questionAfterJump";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("continueOnYourWay")) {
            nextQuestion = "continueWayWithWin";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (answer.equals("goBackAnotherWay")) {
            nextQuestion = "getBackWithLose";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (answer.equals("getBack")) {
            nextQuestion = "getBackBeforeRiver";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("buildATent")) {
            nextQuestion = "loseAfterBuild";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (answer.equals("dontStop")) {
            nextQuestion = "continueWayWithWin";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }

        //После поворота направо
        if (answer.equals("turnRight")) {
            nextQuestion = "turnRightNextQuestion";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("ignore")) {
            nextQuestion = "dontCheckWithLose";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (answer.equals("checkTheBushes")) {
            nextQuestion = "questionAfterCheckBushes";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("checkHouse")) {
            nextQuestion = "questionAfterCheckHouse";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }

        //Продолжение с ключом
        if (answer.equals("findKey")) {
            nextQuestion = "questionAfterKey";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("openLeft")) {
            nextQuestion = "questionAfterLeftDoor";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (answer.equals("openRight")) {
            nextQuestion = "questionAfterRightDoor";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }

        //Подолжение с книгой
        if (answer.equals("findBook")) {
            nextQuestion = "questionAfterBook";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("openBook")) {
            nextQuestion = "questionAfterOpen";
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        if (answer.equals("useSpells")) {
            nextQuestion = "winAfterSpells";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }
        if (answer.equals("dontUseSpells")) {
            nextQuestion = "winAfterNotSpells";
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        }

        //После нажатия "начать заново"
        if (answer.equals("restart")) {
            restart(req, resp);
        }
    }

    public HttpServletRequest setRestart(HttpServletRequest req, String nextQuestion) {
        req.setAttribute("header1", questions.questionsMap.get(nextQuestion).get("header"));
        req.setAttribute("p1", questions.questionsMap.get(nextQuestion).get("p1"));
        req.setAttribute("p2", questions.questionsMap.get(nextQuestion).get("p2"));
        if (questions.questionsMap.get(nextQuestion).containsKey("img")) {
            req.setAttribute("img", questions.questionsMap.get(nextQuestion).get("img"));
        }
        return req;
    }

    public HttpServletRequest setNextQuestion(HttpServletRequest req, String nextQuestion) {
        req.setAttribute("header1", questions.questionsMap.get(nextQuestion).get("header"));
        req.setAttribute("img", questions.questionsMap.get(nextQuestion).get("img"));
        req.setAttribute("question", questions.questionsMap.get(nextQuestion).get("question"));
        req.setAttribute("answer1", questions.questionsMap.get(nextQuestion).get("answer1"));
        req.setAttribute("btn1", questions.questionsMap.get(nextQuestion).get("btnName1"));
        req.setAttribute("answer2", questions.questionsMap.get(nextQuestion).get("answer2"));
        req.setAttribute("btn2", questions.questionsMap.get(nextQuestion).get("btnName2"));
        return req;
    }

    public void restart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req = setDefQuestion(req);
        gameCount++;
        req.setAttribute("gameCount", gameCount);
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    public HttpServletRequest setDefQuestion(HttpServletRequest req) {
        req.setAttribute("header1", questions.questionsMap.get("defaultQuestion").get("header"));
        req.setAttribute("img", questions.questionsMap.get("defaultQuestion").get("img"));
        req.setAttribute("question", questions.questionsMap.get("defaultQuestion").get("question"));
        req.setAttribute("answer1", questions.questionsMap.get("defaultQuestion").get("answer1"));
        req.setAttribute("btn1", questions.questionsMap.get("defaultQuestion").get("btnName1"));
        req.setAttribute("answer2", questions.questionsMap.get("defaultQuestion").get("answer2"));
        req.setAttribute("btn2", questions.questionsMap.get("defaultQuestion").get("btnName2"));
        return req;
    }

    public void takeAttributes() throws UnknownHostException {
        ip = String.valueOf(Inet4Address.getLocalHost());
        String[] tempIp = ip.split("/");
        ip = tempIp[1];
        name = tempIp[0];
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        takeAttributes();
        req = setDefQuestion(req);
        req.setAttribute("name", name);
        req.setAttribute("ip", ip);
        req.setAttribute("gameCount", gameCount);
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}
