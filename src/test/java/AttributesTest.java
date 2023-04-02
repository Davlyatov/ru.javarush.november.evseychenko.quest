import org.junit.jupiter.api.Test;
import ru.quest.Attributes;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttributesTest {

    @Test
    void getIp_shouldReturnYourIp() throws UnknownHostException {
        Attributes attributes = new Attributes();
        String[] temp = String.valueOf(Inet4Address.getLocalHost()).split("/");
        String ip = temp[1];
        assertEquals(attributes.getIp(), ip);
    }

    @Test
    void getName_ShouldReturnYourComputerName() throws UnknownHostException {
        Attributes attributes = new Attributes();
        String[] temp = String.valueOf(Inet4Address.getLocalHost()).split("/");
        String name = temp[0];
        assertEquals(attributes.getName(), name);
    }

    @Test
    void getGameCount_shouldReturn_1() throws UnknownHostException {
        Attributes attributes = new Attributes();
        assertEquals(attributes.getGameCount(), 1);
    }
}
