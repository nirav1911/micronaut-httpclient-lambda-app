package micronaut.httpclient.lambda.app;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import io.micronaut.http.HttpRequest;
import jakarta.inject.Inject;

import java.util.UUID;

@Introspected
public class BookRequestHandler extends MicronautRequestHandler<Book, BookSaved> {
    //@Inject  private BookApiClient bookApiClient;
    @Inject
    ApplicationContext context;
    @Inject private BookLowLevelClient bookLowLevelClient;

    public BookRequestHandler(){
    }
    public BookRequestHandler(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public BookSaved execute(Book input) {
        HttpRequest request = bookLowLevelClient.buildHttpRequest(input.getCustomerId(),input.getLocationId(), input.getToken(), input);
        BookSaved bookSaved = bookLowLevelClient.updateBook(request);
        //BookSaved bookSaved = bookApiClient.updateBook(input.getToken(),input.getCustomerId(),input.getLocationId(), input);
        return bookSaved;
    }
}
