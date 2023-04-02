package ru.quest;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Attributes {
    private final String ip;
    private final String name;
    private String answer;
    private int gameCount;

    public Attributes() throws UnknownHostException {
        String[] ipAndName = String.valueOf(Inet4Address.getLocalHost()).split("/");
        this.ip = ipAndName[1];
        this.name = ipAndName[0];
        this.answer = "";
        this.gameCount = 1;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
