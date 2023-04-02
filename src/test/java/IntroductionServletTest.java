import org.mockito.Mockito;
import ru.quest.IntroductionServlet;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IntroductionServletTest{

    String path = "/introduction.jsp";
    IntroductionServlet introductionServlet = new IntroductionServlet();
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);


    @Test
    public void startTest() throws ServletException, IOException {
        Mockito.when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        introductionServlet.doGet(request,response);

        Mockito.verify(request, Mockito.times(1)).getRequestDispatcher(path);
        Mockito.verify(dispatcher).forward(request,response);
    }

    @Test
    public void redirectTest() throws IOException {
        introductionServlet.doPost(request,response);

        Mockito.verify(response, Mockito.times(1)).sendRedirect("/game");
    }
}
