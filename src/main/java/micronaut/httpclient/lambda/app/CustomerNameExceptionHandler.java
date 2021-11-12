package micronaut.httpclient.lambda.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = { CustomerNameException.class, ExceptionHandler.class})
public class CustomerNameExceptionHandler implements ExceptionHandler<CustomerNameException, HttpResponse<ErrorModel>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomConstraintExceptionHandler.class);


    @Override
    public HttpResponse<ErrorModel> handle(HttpRequest request, CustomerNameException exception) {
        LOGGER.info("*********** Inside Exception Handler *************");

        ErrorModel error = new ErrorModel();
        error.setErrorCode("404");
        error.setErrorMessage(exception.getMessage());
        return HttpResponse.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
