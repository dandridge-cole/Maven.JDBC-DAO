package utility;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class ConnectionFactoryTest {

    @Test
    public void getConnection() {
        Connection conn = ConnectionFactory.getConnection();
        Assert.assertNotNull(conn);
    }
}