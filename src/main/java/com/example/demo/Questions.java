package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Questions {

    public final Map<String, Map<String, String>> questionsMap = new HashMap<>();

    {
        Map<String, String> defQuestMap = new HashMap<>();
        defQuestMap.put("header", "Вы находитесь в темном лесу.");
        defQuestMap.put("img", "src='images/startImage.jpg' width='632' height='415'");
        defQuestMap.put("question", "Вокруг тишина, только свистят ветви и шуршат листья под вашими ногами. Перед вами развилка. Куда пойдете?");
        defQuestMap.put("answer1", "value='Пойти налево' name='turnLeft'");
        defQuestMap.put("answer2", "value='Пойти направо' name='turnRight'");
        questionsMap.put("defaultQuestion", defQuestMap);

        Map<String, String> turnLeftNextQuest = new HashMap<>();
        turnLeftNextQuest.put("header", "Вы свернули налево.");
        turnLeftNextQuest.put("img", "src='images/riverInForest.jpg' width='632' height='415'");
        turnLeftNextQuest.put("question", "И прошли немного, пока не увидели ручей. Что вы будете делать?");
        turnLeftNextQuest.put("answer1", "<input type = 'submit' value='Попытаться перепрыгнуть через ручей.' name='jumpInto'");
        turnLeftNextQuest.put("answer2", "<input type = 'submit' value='Сделать обход и найти другой путь.' name='getBack'");
        questionsMap.put("turnLeftNextQuestion", turnLeftNextQuest);

        Map<String, String> questionAfterJump = new HashMap<>();
        questionAfterJump.put("header", "Вы попытались перепрыгнуть через ручей.");
        questionAfterJump.put("img", "src='images/riverInForest.jpg' width='632' height='415'");
        questionAfterJump.put("question", "Но упали в воду и промокли до нитки. Что будете делать дальше?");
        questionAfterJump.put("answer1", "value='Продолжить свой путь, игнорируя мокрую одежду.' name='continueOnYourWay'");
        questionAfterJump.put("answer2", "value='Вернуться назад и найти другой путь.' name='goBackAnotherWay'");
        questionsMap.put("questionAfterJump", questionAfterJump);

        Map<String, String> continueWayWithWin = new HashMap<>();
        continueWayWithWin.put("header", "Вы продолжили свой путь.");
        continueWayWithWin.put("p1", "И в итоге нашли выход из леса.");
        continueWayWithWin.put("p2", "Поздравляем, вы справились с заданием!");
        continueWayWithWin.put("restartBtn", "value='Начать заново' name='restart'");
        questionsMap.put("continueWayWithWin", continueWayWithWin);

        Map<String, String> getBackWithLose = new HashMap<>();
        getBackWithLose.put("header", "Вы решили вернуться назад.");
        getBackWithLose.put("p1", "Но заблудились и не смогли найти выход");
        getBackWithLose.put("p2", "Вы потерялись в лесу");
        getBackWithLose.put("restartBtn", "value='Начать заново' name='restart'");
        questionsMap.put("getBackWithLose", getBackWithLose);

        Map<String, String> getBackBeforeRiver = new HashMap<>();
        getBackBeforeRiver.put("header", "Вы нашли другой путь и продолжили его.");
        getBackBeforeRiver.put("img", "src='images/pathInForest.jpg' width='632' height='415'");
        getBackBeforeRiver.put("question", "Что будете делать дальше?");
        getBackBeforeRiver.put("answer1", "value='Попытаться построить палатку и остаться на ночь' name='buildATent'");
        getBackBeforeRiver.put("answer2", "value='Продолжить путь, не останавливаясь' name='dontStop'");
        questionsMap.put("getBackBeforeRiver", getBackBeforeRiver);

        Map<String, String> loseAfterBuild = new HashMap<>();
        loseAfterBuild.put("header", "Вы построили палатку.");
        loseAfterBuild.put("img", "<img src='images/tentInForest.jpg' width='632' height='415'>");
        loseAfterBuild.put("p1", "Но ночью на вас напали дикие звери и вы не смогли защитить себя.");
        loseAfterBuild.put("p2", "Игра окончена");
        loseAfterBuild.put("restartBtn", "value='Начать заново' name='restart'");
        questionsMap.put("loseAfterBuild", loseAfterBuild);

        Map<String, String> turnRightNextQuestion = new HashMap<>();
        turnRightNextQuestion.put("header", "Вы свернули направо и пошли по лесной тропе.");
        turnRightNextQuestion.put("img", "src='images/bushInForest.jpg' width='632' height='415'");
        turnRightNextQuestion.put("question", "Вы услышали странный звук в кустах. Что вы будете делать?");
        turnRightNextQuestion.put("answer1", "value='Идти дальше, игнорируя звук.' name='ignore' name='buildATent'");
        turnRightNextQuestion.put("answer2", "value='Проверить, что там находится' name='checkTheBushes'");
        questionsMap.put("turnRightNextQuestion", turnRightNextQuestion);

        Map<String, String> dontCheckWithLose = new HashMap<>();
        dontCheckWithLose.put("header", "Вы продолжили путь.");
        dontCheckWithLose.put("img", "<img src='images/bearInForest.jpg' width='632' height='415'>");
        dontCheckWithLose.put("p1", "Но вскоре на вас напал медведь.");
        dontCheckWithLose.put("p2", "Игра окончена");
        dontCheckWithLose.put("restartBtn", "value='Начать заново' name='restart'");
        questionsMap.put("dontCheckWithLose", dontCheckWithLose);

        Map<String, String> questionAfterCheckBushes = new HashMap<>();
        questionAfterCheckBushes.put("header", "Вы подошли к кустам.");
        questionAfterCheckBushes.put("img", "src='images/houseInForest.jpg' width='632' height='415'");
        questionAfterCheckBushes.put("question", "И обнаружили заброшенную хижину. Что вы будете делать?");
        questionAfterCheckBushes.put("answer1", "Войти в хижину и исследовать ее.' name='checkHouse'");
        questionAfterCheckBushes.put("answer2", "value='Пройти мимо хижины и продолжить свой путь.' name='ignore'");
        questionsMap.put("questionAfterCheckBushes", questionAfterCheckBushes);

        Map<String,String> questionAfterCheckHouse = new HashMap<>();
        questionAfterCheckHouse.put("header", "Вы вошли в хижину");
        questionAfterCheckHouse.put("img", "src='images/insideHouse.jpg' width='632' height='415'");
        questionAfterCheckHouse.put("question", "И обнаружили там много интрересных вещей. В углу стоял старый сундук, который вы решили открыть. Что вы обнаружили внутри?");
        questionAfterCheckHouse.put("answer1", "value='Ключ от следующей комнаты.' name='findKey'");
        questionAfterCheckHouse.put("answer2", "value='Старую книгу со странными символами' name='findBook' name='ignore'");
        questionsMap.put("questionAfterCheckHouse",questionAfterCheckHouse);

        Map<String,String> questionAfterKey = new HashMap<>();
        questionAfterKey.put("header", "Вы нашли ключ.");
        questionAfterKey.put("img", "src='images/doorsInHouse.jpg' width='632' height='415'");
        questionAfterKey.put("question", "Перед вами 2 двери, к которым подходит этот ключ. Какую откроете?");
        questionAfterKey.put("answer1", "value='Открыть дверь налево.' name='openLeft'");
        questionAfterKey.put("answer2", "value='Открыть дверь направо.' name='openRight'");
        questionsMap.put("questionAfterKey",questionAfterKey);

        Map<String,String> questionAfterLeftDoor = new HashMap<>();
        questionAfterLeftDoor.put("header", "Вы открыли дверь налево.");
        questionAfterLeftDoor.put("img", "src='images/winRoom.jpg' width='632' height='415'");
        questionAfterLeftDoor.put("p1","И обнаружили комнату с сокровищами.");
        questionAfterLeftDoor.put("p2","Поздравляем, вы справились с заданием!");
        questionAfterLeftDoor.put("restartBtn","value='Начать заново' name='restart'");
        questionsMap.put("questionAfterLeftDoor",questionAfterLeftDoor);

        Map<String,String> questionAfterRightDoor = new HashMap<>();
        questionAfterRightDoor.put("header", "Вы открыли дверь направо.");
        questionAfterRightDoor.put("p1","И попали в комнату с ловушками.");
        questionAfterRightDoor.put("p2","Игра окончена");
        questionAfterRightDoor.put("restartBtn","value='Начать заново' name='restart'");
        questionsMap.put("questionAfterRightDoor",questionAfterRightDoor);

        Map<String,String> questionAfterBook = new HashMap<>();
        questionAfterBook.put("header", "Вы нашли старую книгу.");
        questionAfterBook.put("img", "src='images/oldBook.jpg'");
        questionAfterBook.put("question", "Она вся наполнена странными симвалоами. Что будете делать дальше?");
        questionAfterBook.put("answer1", "value='Открыть книгу и изучить ее содержимое.' name='openBook'");
        questionAfterBook.put("answer2", "value='Оставить книгу на месте и продолжить свой путь.' name='ignore'");
        questionsMap.put("questionAfterBook",questionAfterBook);

        Map<String,String> questionAfterOpen = new HashMap<>();
        questionAfterOpen.put("header", "Вы открыли книгу.");
        questionAfterOpen.put("img", "src='images/oldBook.jpg'");
        questionAfterOpen.put("question", "И обнаружили, что это книга заклинаний. Что вы будете делать дальше?");
        questionAfterOpen.put("answer1", "value='Использовать заклинания для своих целей.' name='useSpells'");
        questionAfterOpen.put("answer2", "value='Оставить книгу на месте и продолжить свой путь.' name='dontUseSpells'");
        questionsMap.put("questionAfterOpen",questionAfterOpen);

        Map<String,String> winAfterSpells = new HashMap<>();
        winAfterSpells.put("header", "Вы использовали заклинания.");
        winAfterSpells.put("p1","И стали очень могущественным магом.");
        winAfterSpells.put("p2","Поздравляем, вы справились с заданием!");
        winAfterSpells.put("restartBtn","value='Начать заново' name='restart'");
        questionsMap.put("winAfterSpells",winAfterSpells);

        Map<String,String> winAfterNotSpells = new HashMap<>();
        winAfterNotSpells.put("header", "Вы оставили книгу на месте.");
        winAfterNotSpells.put("p1","И продолжили свой путь. В итоге вы нашли выход из леса");
        winAfterNotSpells.put("p2","Поздравляем, вы справились с заданием!");
        winAfterNotSpells.put("restartBtn","value='Начать заново' name='restart'");
        questionsMap.put("winAfterNotSpells",winAfterNotSpells);
    }
}
