package pl.lomianki.testing.order;

import org.junit.jupiter.api.Test;
import pl.lomianki.testing.order.Order;
import pl.lomianki.testing.order.OrderBackup;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {
    @Test
    void callingBackupWithoutCreatingAFileShouldThrowException() throws IOException {
        //given
        OrderBackup orderBackup = new OrderBackup();

        //then
        assertThrows(IOException.class,()->orderBackup.backupOrder(new Order()));
    }
}
