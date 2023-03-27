package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Questions {

    public final Map<String, String> questions = new HashMap<>();

    {
        questions.put("defaultQuestion","<h1>Вы находитесь в темном лесу.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/startImage.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>Вокруг тишина, только свистят ветви и шуршат листья под вашими ногами. Перед вами развилка. Куда пойдете?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Пойти налево' name='turnLeft' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Пойти направо' name='turnRight' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("turnLeftNextQuestion","<h1>Вы свернули налево.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/riverInForest.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>И прошли немного, пока не увидели ручей. Что вы будете делать?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Попытаться перепрыгнуть через ручей.' name='jumpInto' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Сделать обход и найти другой путь.' name='getBack' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("questionAfterJump","<h1>Вы попытались перепрыгнуть через ручей.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/riverInForest.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>Но упали в воду и промокли до нитки. Что будете делать дальше?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Продолжить свой путь, игнорируя мокрую одежду.' name='continueOnYourWay' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Вернуться назад и найти другой путь.' name='goBackAnotherWay' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("continueWayWithWin","<h1>Вы продолжили свой путь.</h1>\n" +
                "<p>И в итоге нашли выход из леса.</p>" +
                "<p>Поздравляем, вы справились с заданием!</p>" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");

        questions.put("getBackWithLose","<h1>Вы решили вернуться назад.</h1>\n" +
                "<p>Но заблудились и не смогли найти выход</p>" +
                "<p>Вы потерялись в лесу</p>" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");

        questions.put("getBackBeforeRiver","<h1>Вы нашли другой путь и продолжили его.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/pathInForest.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>Что будете делать дальше?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Попытаться построить палатку и остаться на ночь' name='buildATent' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Продолжить путь, не останавливаясь' name='dontStop' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("loseAfterBuild","<h1>Вы построили палатку.</h1>\n" +
                "<img src='images/tentInForest.jpg' width='632' height='415'>\n" +
                "<p>Но ночью на вас напали дикие звери и вы не смогли защитить себя.</p>\n" +
                "<p>Игра окончена</p>\n" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");

        questions.put("turnRightNextQuestion","<h1>Вы свернули направо и пошли по лесной тропе.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/bushInForest.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>Вы услышали странный звук в кустах. Что вы будете делать?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Идти дальше, игнорируя звук.' name='ignore' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Проверить, что там находится' name='checkTheBushes' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("dontCheckWithLose","<h1>Вы продолжили путь.</h1>\n" +
                "<img src='images/bearInForest.jpg' width='632' height='415'>\n" +
                "<p>Но вскоре на вас напал медведь.</p>\n" +
                "<p>Игра окончена</p>\n" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");

        questions.put("questionAfterCheckBushes","<h1>Вы подошли к кустам.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/houseInForest.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>И обнаружили заброшенную хижину. Что вы будете делать?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Войти в хижину и исследовать ее.' name='checkHouse' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Пройти мимо хижины и продолжить свой путь.' name='ignore' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("questionAfterCheckHouse","<h1>Вы вошли в хижину</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/insideHouse.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>И обнаружили там много интрересных вещей. В углу стоял старый сундук, который вы решили открыть. Что вы обнаружили внутри?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Ключ от следующей комнаты.' name='findKey' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Старую книгу со странными символами' name='findBook' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("questionAfterKey","<h1>Вы нашли ключ.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/doorsInHouse.jpg' width='632' height='415'></td></tr>\n" +
                "<tr><td colspan='2'>Перед вами 2 двери, к которым подходит этот ключ. Какую откроете?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Открыть дверь налево.' name='openLeft' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Открыть дверь направо.' name='openRight' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("questionAfterLeftDoor","<h1>Вы открыли дверь налево.</h1>\n" +
                "<img src='images/winRoom.jpg' width='632' height='415'>\n" +
                "<p>И обнаружили комнату с сокровищами.</p>\n" +
                "<p>Поздравляем, вы справились с заданием!</p>\n" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");

        questions.put("questionAfterRightDoor","<h1>Вы открыли дверь направо.</h1>\n" +
                "<p>И попали в комнату с ловушками.</p>\n" +
                "<p>Игра окончена</p>\n" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");

        questions.put("questionAfterBook","<h1>Вы нашли старую книгу.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/oldBook.jpg'></td></tr>\n" +
                "<tr><td colspan='2'>Она вся наполнена странными симвалоами. Что будете делать дальше?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Открыть книгу и изучить ее содержимое.' name='openBook' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Оставить книгу на месте и продолжить свой путь.' name='ignore' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("questionAfterOpen","<h1>Вы открыли книгу.</h1>\n" +
                "<table border='1'>\n" +
                "<tbody>\n" +
                "<tr><td colspan='2'><img src='images/oldBook.jpg'></td></tr>\n" +
                "<tr><td colspan='2'>И обнаружили, что это книга заклинаний. Что вы будете делать дальше?</td></tr>\n" +
                "<tr><td><form method='post'>\n" +
                "<input type = 'submit' value='Использовать заклинания для своих целей.' name='useSpells' class='input-filter'>\n</td>" +
                "<td>\n" +
                "<input type = 'submit' value='Оставить книгу на месте и продолжить свой путь.' name='dontUseSpells' class='input-filter'>\n" +
                "</form></td></tr></tbody></table>");

        questions.put("winAfterSpells","<h1>Вы использовали заклинания.</h1>\n" +
                "<p>И стали очень могущественным магом.</p>" +
                "<p>Поздравляем, вы справились с заданием!</p>" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");

        questions.put("winAfterNotSpells","<h1>Вы оставили книгу на месте.</h1>\n" +
                "<p>И продолжили свой путь. В итоге вы нашли выход из леса</p>" +
                "<p>Поздравляем, вы справились с заданием!</p>" +
                "<form method='post'>\n" +
                "<input type='submit' value='Начать заново' name='restart'>\n</form>");
    }
}
