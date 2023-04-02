package ru.quest;

import java.util.HashMap;
import java.util.Map;

public class Questions {

    private final Map<String, Map<String, String>> questionsMap = new HashMap<>();

    {
        Map<String, String> defQuestMap = new HashMap<>();
        defQuestMap.put("header", "Вы находитесь в темном лесу.");
        defQuestMap.put("img", "src='images/startImage.jpg' width='632' height='415'");
        defQuestMap.put("question", "Вокруг тишина, только свистят ветви и шуршат листья под вашими ногами. Перед вами развилка. Куда пойдете?");
        defQuestMap.put("answer1", "turnLeft");
        defQuestMap.put("answer2", "turnRight");
        defQuestMap.put("btnName1","Пойти налево");
        defQuestMap.put("btnName2","Пойти направо");
        questionsMap.put("defaultQuestion", defQuestMap);

        Map<String, String> turnLeftNextQuest = new HashMap<>();
        turnLeftNextQuest.put("header", "Вы свернули налево.");
        turnLeftNextQuest.put("img", "src='images/riverInForest.jpg' width='632' height='415'");
        turnLeftNextQuest.put("question", "И прошли немного, пока не увидели ручей. Что вы будете делать?");
        turnLeftNextQuest.put("answer1", "jumpInto");
        turnLeftNextQuest.put("answer2", "getBack");
        turnLeftNextQuest.put("btnName1","Попытаться перепрыгнуть через ручей.");
        turnLeftNextQuest.put("btnName2","Сделать обход и найти другой путь.");
        questionsMap.put("turnLeftNextQuestion", turnLeftNextQuest);

        Map<String, String> questionAfterJump = new HashMap<>();
        questionAfterJump.put("header", "Вы попытались перепрыгнуть через ручей.");
        questionAfterJump.put("img", "src='images/riverInForest.jpg' width='632' height='415'");
        questionAfterJump.put("question", "Но упали в воду и промокли до нитки. Что будете делать дальше?");
        questionAfterJump.put("answer1", "continueOnYourWay");
        questionAfterJump.put("answer2", "goBackAnotherWay");
        questionAfterJump.put("btnName1","Продолжить свой путь, игнорируя мокрую одежду.");
        questionAfterJump.put("btnName2","Вернуться назад и найти другой путь.");
        questionsMap.put("questionAfterJump", questionAfterJump);

        Map<String, String> continueWayWithWin = new HashMap<>();
        continueWayWithWin.put("header", "Вы продолжили свой путь.");
        continueWayWithWin.put("p1", "И в итоге нашли выход из леса.");
        continueWayWithWin.put("p2", "Поздравляем, вы справились с заданием!");
        questionsMap.put("continueWayWithWin", continueWayWithWin);

        Map<String, String> getBackWithLose = new HashMap<>();
        getBackWithLose.put("header", "Вы решили вернуться назад.");
        getBackWithLose.put("p1", "Но заблудились и не смогли найти выход");
        getBackWithLose.put("p2", "Вы потерялись в лесу");
        questionsMap.put("getBackWithLose", getBackWithLose);

        Map<String, String> getBackBeforeRiver = new HashMap<>();
        getBackBeforeRiver.put("header", "Вы нашли другой путь и продолжили его.");
        getBackBeforeRiver.put("img", "src='images/pathInForest.jpg' width='632' height='415'");
        getBackBeforeRiver.put("question", "Что будете делать дальше?");
        getBackBeforeRiver.put("answer1", "buildATent");
        getBackBeforeRiver.put("answer2", "dontStop");
        getBackBeforeRiver.put("btnName1","Попытаться построить палатку и остаться на ночь");
        getBackBeforeRiver.put("btnName2","Продолжить путь, не останавливаясь");
        questionsMap.put("getBackBeforeRiver", getBackBeforeRiver);

        Map<String, String> loseAfterBuild = new HashMap<>();
        loseAfterBuild.put("header", "Вы построили палатку.");
        loseAfterBuild.put("img", "<img src='images/tentInForest.jpg' width='632' height='415'>");
        loseAfterBuild.put("p1", "Но ночью на вас напали дикие звери и вы не смогли защитить себя.");
        loseAfterBuild.put("p2", "Игра окончена");
        questionsMap.put("loseAfterBuild", loseAfterBuild);

        Map<String, String> turnRightNextQuestion = new HashMap<>();
        turnRightNextQuestion.put("header", "Вы свернули направо и пошли по лесной тропе.");
        turnRightNextQuestion.put("img", "src='images/bushInForest.jpg' width='632' height='415'");
        turnRightNextQuestion.put("question", "Вы услышали странный звук в кустах. Что вы будете делать?");
        turnRightNextQuestion.put("answer1", "ignore");
        turnRightNextQuestion.put("answer2", "checkTheBushes");
        turnRightNextQuestion.put("btnName1","Идти дальше, игнорируя звук.");
        turnRightNextQuestion.put("btnName2","Проверить, что там находится");
        questionsMap.put("turnRightNextQuestion", turnRightNextQuestion);

        Map<String, String> dontCheckWithLose = new HashMap<>();
        dontCheckWithLose.put("header", "Вы продолжили путь.");
        dontCheckWithLose.put("img", "<img src='images/bearInForest.jpg' width='632' height='415'>");
        dontCheckWithLose.put("p1", "Но вскоре на вас напал медведь.");
        dontCheckWithLose.put("p2", "Игра окончена");
        questionsMap.put("dontCheckWithLose", dontCheckWithLose);

        Map<String, String> questionAfterCheckBushes = new HashMap<>();
        questionAfterCheckBushes.put("header", "Вы подошли к кустам.");
        questionAfterCheckBushes.put("img", "src='images/houseInForest.jpg' width='632' height='415'");
        questionAfterCheckBushes.put("question", "И обнаружили заброшенную хижину. Что вы будете делать?");
        questionAfterCheckBushes.put("answer1", "checkHouse");
        questionAfterCheckBushes.put("answer2", "ignore");
        questionAfterCheckBushes.put("btnName1","Войти в хижину и исследовать ее.");
        questionAfterCheckBushes.put("btnName2","Пройти мимо хижины и продолжить свой путь.");
        questionsMap.put("questionAfterCheckBushes", questionAfterCheckBushes);

        Map<String,String> questionAfterCheckHouse = new HashMap<>();
        questionAfterCheckHouse.put("header", "Вы вошли в хижину");
        questionAfterCheckHouse.put("img", "src='images/insideHouse.jpg' width='632' height='415'");
        questionAfterCheckHouse.put("question", "И обнаружили там много интрересных вещей. В углу стоял старый сундук, который вы решили открыть. Что вы обнаружили внутри?");
        questionAfterCheckHouse.put("answer1", "findKey");
        questionAfterCheckHouse.put("answer2", "findBook");
        questionAfterCheckHouse.put("btnName1","Ключ от следующей комнаты.");
        questionAfterCheckHouse.put("btnName2","Старую книгу со странными символами");
        questionsMap.put("questionAfterCheckHouse",questionAfterCheckHouse);

        Map<String,String> questionAfterKey = new HashMap<>();
        questionAfterKey.put("header", "Вы нашли ключ.");
        questionAfterKey.put("img", "src='images/doorsInHouse.jpg' width='632' height='415'");
        questionAfterKey.put("question", "Перед вами 2 двери, к которым подходит этот ключ. Какую откроете?");
        questionAfterKey.put("answer1", "openLeft");
        questionAfterKey.put("answer2", "openRight");
        questionAfterKey.put("btnName1","Открыть дверь налево.");
        questionAfterKey.put("btnName2","Открыть дверь направо.");
        questionsMap.put("questionAfterKey",questionAfterKey);

        Map<String,String> questionAfterLeftDoor = new HashMap<>();
        questionAfterLeftDoor.put("header", "Вы открыли дверь налево.");
        questionAfterLeftDoor.put("img", "<img src='images/winRoom.jpg' width='632' height='415'>");
        questionAfterLeftDoor.put("p1","И обнаружили комнату с сокровищами.");
        questionAfterLeftDoor.put("p2","Поздравляем, вы справились с заданием!");
        questionsMap.put("questionAfterLeftDoor",questionAfterLeftDoor);

        Map<String,String> questionAfterRightDoor = new HashMap<>();
        questionAfterRightDoor.put("header", "Вы открыли дверь направо.");
        questionAfterRightDoor.put("p1","И попали в комнату с ловушками.");
        questionAfterRightDoor.put("p2","Игра окончена");
        questionsMap.put("questionAfterRightDoor",questionAfterRightDoor);

        Map<String,String> questionAfterBook = new HashMap<>();
        questionAfterBook.put("header", "Вы нашли старую книгу.");
        questionAfterBook.put("img", "src='images/oldBook.jpg'");
        questionAfterBook.put("question", "Она вся наполнена странными симвалоами. Что будете делать дальше?");
        questionAfterBook.put("answer1", "openBook");
        questionAfterBook.put("answer2", "ignore");
        questionAfterBook.put("btnName1","Открыть книгу и изучить ее содержимое.");
        questionAfterBook.put("btnName2","Оставить книгу на месте и продолжить свой путь.");
        questionsMap.put("questionAfterBook",questionAfterBook);

        Map<String,String> questionAfterOpen = new HashMap<>();
        questionAfterOpen.put("header", "Вы открыли книгу.");
        questionAfterOpen.put("img", "src='images/oldBook.jpg'");
        questionAfterOpen.put("question", "И обнаружили, что это книга заклинаний. Что вы будете делать дальше?");
        questionAfterOpen.put("answer1", "useSpells");
        questionAfterOpen.put("answer2", "dontUseSpells");
        questionAfterOpen.put("btnName1","Использовать заклинания для своих целей.");
        questionAfterOpen.put("btnName2","Оставить книгу на месте и продолжить свой путь.");
        questionsMap.put("questionAfterOpen",questionAfterOpen);

        Map<String,String> winAfterSpells = new HashMap<>();
        winAfterSpells.put("header", "Вы использовали заклинания.");
        winAfterSpells.put("p1","И стали очень могущественным магом.");
        winAfterSpells.put("p2","Поздравляем, вы справились с заданием!");
        questionsMap.put("winAfterSpells",winAfterSpells);

        Map<String,String> winAfterNotSpells = new HashMap<>();
        winAfterNotSpells.put("header", "Вы оставили книгу на месте.");
        winAfterNotSpells.put("p1","И продолжили свой путь. В итоге вы нашли выход из леса");
        winAfterNotSpells.put("p2","Поздравляем, вы справились с заданием!");
        questionsMap.put("winAfterNotSpells",winAfterNotSpells);
    }

    public String getRequiredAttribute(String mapName,String requiredAttribute){
        return questionsMap.get(mapName).getOrDefault(requiredAttribute, null);
    }
}
