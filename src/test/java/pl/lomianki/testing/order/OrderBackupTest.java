package pl.lomianki.testing.order;

import org.junit.jupiter.api.*;
import pl.lomianki.testing.Meal;
import pl.lomianki.testing.order.Order;
import pl.lomianki.testing.order.OrderBackup;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {
    private static OrderBackup orderBackup;

    @BeforeAll
     static void setup() throws FileNotFoundException {
        orderBackup=new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException{
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendAtTheEndOfTheLine() throws IOException{
        orderBackup.getWriter().append(" backed up.");
    }

    @Tag("fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal= new Meal(7, "Fries");
        pl.lomianki.testing.order.Order order= new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order: "+order.toString() + " backup up.");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

}
