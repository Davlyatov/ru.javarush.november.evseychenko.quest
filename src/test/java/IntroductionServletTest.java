import com.example.demo.IntroductionServlet;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class IntroductionServletTest{

    String path = "/introduction.jsp";
    IntroductionServlet introductionServlet = new IntroductionServlet();
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    RequestDispatcher dispatcher = mock(RequestDispatcher.class);


    @Test
    public void startTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        introductionServlet.doGet(request,response);

        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request,response);
    }

    @Test
    public void redirectTest() throws IOException {
        introductionServlet.doPost(request,response);

        verify(response,times(1)).sendRedirect("/game");
    }
}
