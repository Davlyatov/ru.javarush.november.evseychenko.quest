package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Questions {

    public final Map<String, String> questions = new HashMap<>();

    {
        questions.put("startQuestion", "<h1>Ты потерял память.</h1>\n" +
                "<p>     Принять вызов НЛО?</p>" +
                "<form method=\"post\">\n" +
                "<input id=\"yes\" value=\"pickUp\" type=\"radio\" name=\"question\">\n" +
                "<label for=\"yes\">Принять вызов</label><br>\n" +
                "<input id=\"no\" value=\"dontPickUp\" type=\"radio\" name=\"question\">\n" +
                "<label for=\"no\">Отклонить вызов</label><br>\n" +
                "<input type = \"submit\" value=\"Ответить на вопрос\" name = \"takeACall\">\n" +
                "</form>");

        questions.put("loseAfterStart", "<p>Ты отклонил вызов. Поражение.</p>" +
                "<form method=\"post\">\n" +
                "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                "</form>");

        questions.put("climbOrNot", "<h1>Ты принял вызов</h1>\n" +
                "<p>     Поднимаешься на мостик к капитану?</p>" +
                "<form method=\"post\">\n" +
                "<input id=\"yes\" value=\"climb\" type=\"radio\" name=\"question\">\n" +
                "<label for=\"yes\">Поднятся на мостик</label><br>\n" +
                "<input id=\"no\" value=\"dontClimb\" type=\"radio\" name=\"question\">\n" +
                "<label for=\"no\">Отказаться подниматься на мостик</label><br>\n" +
                "<input type = \"submit\" value=\"Ответить на вопрос\" name = \"takeACall\">\n" +
                "</form>");

        questions.put("loseAfterNotClimb", "<p>Ты не пошел на переговоры. Поражение.</p>" +
                "<form method=\"post\">\n" +
                "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                "</form>");

        questions.put("lieOrNot", "<h1>Ты поднялся на мостик</h1>\n" +
                "<p>     Ты кто?</p>" +
                "<form method=\"post\">\n" +
                "<input id=\"yes\" value=\"dontLie\" type=\"radio\" name=\"question\">\n" +
                "<label for=\"yes\">Рассказать правду о себе</label><br>\n" +
                "<input id=\"no\" value=\"lie\" type=\"radio\" name=\"question\">\n" +
                "<label for=\"no\">Соглать о себе</label><br>\n" +
                "<input type = \"submit\" value=\"Ответить на вопрос\" name = \"takeACall\">\n" +
                "</form>");

        questions.put("loseAfterLie", "<p>Твою ложь разоблачили. Поражение.</p>" +
                "<form method=\"post\">\n" +
                "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                "</form>");

        questions.put("win", "<h1>Тебя вернули домой</h1>\n" +
                "<p>     ПОБЕДА</p>" +
                "<form method=\"post\">\n" +
                "<input type = \"submit\" value=\"Начать заново\" name = \"restart\">\n" +
                "</form>");

    }
}
