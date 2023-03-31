import com.example.demo.MainServlet;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MainServletTest {

    @Test
    public void startTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        String header = "Вы находитесь в темном лесу.";
        when(request.getParameter("header1")).thenReturn(header);
        when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);
        new MainServlet().doGet(request, response);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void questionsTest() throws ServletException, IOException {
        String[] headers = new String[]{"Вы свернули налево.", "Вы попытались перепрыгнуть через ручей.", "Вы нашли другой путь и продолжили его.", "Вы свернули направо и пошли по лесной тропе.",
                "Вы подошли к кустам.", "Вы вошли в хижину", "Вы нашли ключ.", "Вы нашли старую книгу.", "Вы открыли книгу."};
        String[] answers = new String[]{"turnLeft", "jumpInto", "getBack", "turnRight", "checkTheBushes", "checkHouse", "findKey", "findBook", "openBook"};
        for (int i = 0; i < headers.length; i++) {
            HttpServletRequest request = mock(HttpServletRequest.class);
            HttpServletResponse response = mock(HttpServletResponse.class);
            RequestDispatcher dispatcher = mock(RequestDispatcher.class);
            MainServlet servlet = new MainServlet();
            servlet.answer = answers[i];
            when(request.getParameter("header1")).thenReturn(headers[i]);
            when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);
            servlet.doPost(request, response);
            verify(dispatcher).forward(request, response);
        }
    }

    @Test
    public void restartTest() throws ServletException, IOException {
        String[] headers = new String[]{"Вы продолжили свой путь.", "Вы решили вернуться назад.", "Вы построили палатку.", "Вы продолжили путь.", "Вы открыли дверь налево.",
                "Вы открыли дверь направо.", "Вы использовали заклинания.", "Вы оставили книгу на месте."};
        String[] answers = new String[]{"continueOnYourWay", "goBackAnotherWay", "buildATent", "ignore", "openLeft", "openRight", "useSpells", "dontUseSpells"};
        for (int i = 0; i < headers.length; i++) {
            HttpServletRequest request = mock(HttpServletRequest.class);
            HttpServletResponse response = mock(HttpServletResponse.class);
            RequestDispatcher dispatcher = mock(RequestDispatcher.class);
            MainServlet servlet = new MainServlet();
            servlet.answer = answers[i];
            when(request.getParameter("header1")).thenReturn(headers[i]);
            when(request.getRequestDispatcher("/restart.jsp")).thenReturn(dispatcher);
            servlet.doPost(request, response);
            verify(dispatcher).forward(request, response);
        }
    }

}
