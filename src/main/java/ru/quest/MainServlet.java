package ru.quest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

public class MainServlet extends HttpServlet {

    private final Attributes attributes;
    private final Questions questions;

    public void setAnswer(String answer) {
        attributes.setAnswer(answer);
    }

    public MainServlet() throws UnknownHostException {
        this.attributes = new Attributes();
        this.questions = new Questions();
    }



    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        takeAttributes(req);
        String nextQuestion = "";
        if (req.getParameter("answer") != null) {
            attributes.setAnswer(req.getParameter("answer"));
        }
        //После поворота налево
        if (attributes.getAnswer().equals("turnLeft")) {
            nextQuestion = "turnLeftNextQuestion";
        }
        if (attributes.getAnswer().equals("jumpInto")) {
            nextQuestion = "questionAfterJump";
        }
        if (attributes.getAnswer().equals("continueOnYourWay")) {
            nextQuestion = "continueWayWithWin";
        }
        if (attributes.getAnswer().equals("goBackAnotherWay")) {
            nextQuestion = "getBackWithLose";
        }
        if (attributes.getAnswer().equals("getBack")) {
            nextQuestion = "getBackBeforeRiver";
        }
        if (attributes.getAnswer().equals("buildATent")) {
            nextQuestion = "loseAfterBuild";
        }
        if (attributes.getAnswer().equals("dontStop")) {
            nextQuestion = "continueWayWithWin";
        }

        //После поворота направо
        if (attributes.getAnswer().equals("turnRight")) {
            nextQuestion = "turnRightNextQuestion";
        }
        if (attributes.getAnswer().equals("ignore")) {
            nextQuestion = "dontCheckWithLose";
        }
        if (attributes.getAnswer().equals("checkTheBushes")) {
            nextQuestion = "questionAfterCheckBushes";
        }
        if (attributes.getAnswer().equals("checkHouse")) {
            nextQuestion = "questionAfterCheckHouse";
        }

        //Продолжение с ключом
        if (attributes.getAnswer().equals("findKey")) {
            nextQuestion = "questionAfterKey";
        }
        if (attributes.getAnswer().equals("openLeft")) {
            nextQuestion = "questionAfterLeftDoor";
        }
        if (attributes.getAnswer().equals("openRight")) {
            nextQuestion = "questionAfterRightDoor";
        }

        //Подолжение с книгой
        if (attributes.getAnswer().equals("findBook")) {
            nextQuestion = "questionAfterBook";
        }
        if (attributes.getAnswer().equals("openBook")) {
            nextQuestion = "questionAfterOpen";
        }
        if (attributes.getAnswer().equals("useSpells")) {
            nextQuestion = "winAfterSpells";
        }
        if (attributes.getAnswer().equals("dontUseSpells")) {
            nextQuestion = "winAfterNotSpells";
        }
        //После нажатия "начать заново"
        if (attributes.getAnswer().equals("restart")) {
            req = setDefaultQuestion(req);
            attributes.setGameCount(attributes.getGameCount() + 1);
            takeAttributes(req);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }

        if (nextQuestion.equals("continueWayWithWin") || nextQuestion.equals("getBackWithLose") || nextQuestion.equals("loseAfterBuild")
                || nextQuestion.equals("dontCheckWithLose") || nextQuestion.equals("questionAfterLeftDoor") || nextQuestion.equals("questionAfterRightDoor")
                || nextQuestion.equals("winAfterSpells") || nextQuestion.equals("winAfterNotSpells")) {
            req = setRestart(req, nextQuestion);
            req.getRequestDispatcher("/restart.jsp").forward(req, resp);
        } else {
            req = setNextQuestion(req, nextQuestion);
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
        }


    }

    public HttpServletRequest setRestart(HttpServletRequest req, String nextQuestion) {
        req.setAttribute("header1", questions.getRequiredAttribute(nextQuestion, "header"));
        req.setAttribute("p1", questions.getRequiredAttribute(nextQuestion, "p1"));
        req.setAttribute("p2", questions.getRequiredAttribute(nextQuestion, "p2"));
        if (questions.getRequiredAttribute(nextQuestion, "img") != null) {
            req.setAttribute("img", questions.getRequiredAttribute(nextQuestion, "img"));
        }
        return req;
    }

    public HttpServletRequest setNextQuestion(HttpServletRequest req, String nextQuestion) {
        req.setAttribute("header1", questions.getRequiredAttribute(nextQuestion, "header"));
        req.setAttribute("img", questions.getRequiredAttribute(nextQuestion, "img"));
        req.setAttribute("question", questions.getRequiredAttribute(nextQuestion, "question"));
        req.setAttribute("answer1", questions.getRequiredAttribute(nextQuestion, "answer1"));
        req.setAttribute("btn1", questions.getRequiredAttribute(nextQuestion, "btnName1"));
        req.setAttribute("answer2", questions.getRequiredAttribute(nextQuestion, "answer2"));
        req.setAttribute("btn2", questions.getRequiredAttribute(nextQuestion, "btnName2"));
        return req;
    }

    public HttpServletRequest setDefaultQuestion(HttpServletRequest req) {
        req.setAttribute("header1", questions.getRequiredAttribute("defaultQuestion", "header"));
        req.setAttribute("img", questions.getRequiredAttribute("defaultQuestion", "img"));
        req.setAttribute("question", questions.getRequiredAttribute("defaultQuestion", "question"));
        req.setAttribute("answer1", questions.getRequiredAttribute("defaultQuestion", "answer1"));
        req.setAttribute("btn1", questions.getRequiredAttribute("defaultQuestion", "btnName1"));
        req.setAttribute("answer2", questions.getRequiredAttribute("defaultQuestion", "answer2"));
        req.setAttribute("btn2", questions.getRequiredAttribute("defaultQuestion", "btnName2"));
        return req;
    }

    public void takeAttributes(HttpServletRequest req) {
        req.setAttribute("name", attributes.getName());
        req.setAttribute("ip", attributes.getIp());
        req.setAttribute("gameCount", attributes.getGameCount());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        takeAttributes(req);
        req = setDefaultQuestion(req);
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}
