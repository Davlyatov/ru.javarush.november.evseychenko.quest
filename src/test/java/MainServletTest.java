import ru.quest.MainServlet;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MainServletTest {

    @Test
    void doGet_shouldForwardWithDefaultQuestion() throws IOException, ServletException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        String defaultHeader = "Вы находитесь в темном лесу.";
        when(request.getParameter("header1")).thenReturn(defaultHeader);
        when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);
        new MainServlet().doGet(request, response);
        verify(dispatcher).forward(request, response);
    }

    @Test
    void doPost_shouldHaveTurnLeftNextQuestionHeader_whenAnswerIsTurnLeft() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        String turnLeftNextQuestionAnswer = "Вы повернули налево.";
        MainServlet servlet = new MainServlet();
        servlet.setAnswer("turnLeft");
        when(request.getParameter("header1")).thenReturn(turnLeftNextQuestionAnswer);
        when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);
        servlet.doPost(request, response);
        verify(dispatcher).forward(request, response);
        assertEquals(request.getParameter("header1"), turnLeftNextQuestionAnswer);
    }

    @Test
    void doPost_shouldHaveRestartHeader_whenForwardToRestart() throws IOException, ServletException {
        String headerValue = "Вы продолжили свой путь.";
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        MainServlet servlet = new MainServlet();
        servlet.setAnswer("continueOnYourWay");
        when(request.getAttribute("header1")).thenReturn(headerValue);
        when(request.getRequestDispatcher("/restart.jsp")).thenReturn(dispatcher);
        servlet.doPost(request, response);
        verify(dispatcher).forward(request, response);
        assertEquals(request.getAttribute("header1"), headerValue);
    }

    @Test
    void doPost_shouldHaveRequiredHeader_whenQuestionChange() throws IOException, ServletException {
        String[] headers = new String[]{"Вы свернули налево.", "Вы попытались перепрыгнуть через ручей.",
                "Вы нашли другой путь и продолжили его.", "Вы свернули направо и пошли по лесной тропе.",
                "Вы подошли к кустам.", "Вы вошли в хижину", "Вы нашли ключ.",
                "Вы нашли старую книгу.", "Вы открыли книгу."};
        String[] answers = new String[]{"turnLeft", "jumpInto", "getBack",
                "turnRight", "checkTheBushes", "checkHouse",
                "findKey", "findBook", "openBook"};
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher;
        MainServlet servlet = new MainServlet();
        for (int i = 0; i < headers.length; i++) {
            dispatcher = mock(RequestDispatcher.class);
            servlet.setAnswer(answers[i]);
            when(request.getAttribute("header1")).thenReturn(headers[i]);
            when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);
            servlet.doPost(request, response);
            verify(dispatcher).forward(request, response);
            assertEquals(request.getAttribute("header1"), headers[i]);
        }
    }
}
