import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by diovani on 10/21/15.
 */
public class MultiUserChatServerTest {
    MultiUserChatServer server;

    @Before
    public void setUp() {
        server = new MultiUserChatServer();
    }

    @Test
    public void testGetClients() {
        assertEquals(0, server.getClients().size());
    }
}