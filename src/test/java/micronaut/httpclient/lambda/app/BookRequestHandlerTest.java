package micronaut.httpclient.lambda.app;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookRequestHandlerTest {

    private static BookRequestHandler bookRequestHandler;

    @BeforeAll
    public static void setupServer() {
        bookRequestHandler = new BookRequestHandler();
    }

    @AfterAll
    public static void stopServer() {
        if (bookRequestHandler != null) {
            bookRequestHandler.getApplicationContext().close();
        }
    }

    @Test
    public void testHandler() {
        Book book = new Book();
        book.setName("Building Microservices");
        book.setCustomerId("John123");
        book.setLocationId("");
        book.setToken("Token123");
        BookSaved bookSaved = bookRequestHandler.execute(book);
    }

    @Test
    public void testCustomExceptionHandler() {
        Book book = new Book();
        book.setName("Building Microservices");
        book.setCustomerId("Test123");
        book.setLocationId("Location123");
        book.setToken("Token123");
        BookSaved bookSaved = bookRequestHandler.execute(book);
    }
}
