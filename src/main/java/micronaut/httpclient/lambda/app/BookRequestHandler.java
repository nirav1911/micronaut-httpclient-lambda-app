package micronaut.httpclient.lambda.app;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import io.micronaut.http.HttpRequest;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import java.util.UUID;

import javax.validation.Valid;

@Introspected
@Validated
public class BookRequestHandler extends MicronautRequestHandler<Book, BookSaved> {
    @Inject  private BookApiClient bookApiClient;
    @Inject
    ApplicationContext context;
    //@Inject private BookLowLevelClient bookLowLevelClient;

    public BookRequestHandler(){
    }
    public BookRequestHandler(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public BookSaved execute(@Valid Book input) {
        //HttpRequest request = bookLowLevelClient.buildHttpRequest(input.getCustomerId(),input.getLocationId(), input.getToken(), input);
        //BookSaved bookSaved = bookLowLevelClient.updateBook(request);
        if(input.getCustomerId().startsWith("Test")){
            throw new CustomerNameException("Wrong Customer:"+ input.getCustomerId());
        }
        BookSaved bookSaved = bookApiClient.updateBook(input.getToken(),input.getCustomerId(),input.getLocationId(), input);
        return bookSaved;
    }
}
