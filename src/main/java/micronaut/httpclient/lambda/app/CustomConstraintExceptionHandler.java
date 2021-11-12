package micronaut.httpclient.lambda.app;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Primary;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.validation.exceptions.ConstraintExceptionHandler;
import jakarta.inject.Singleton;
import io.micronaut.http.server.exceptions.ExceptionHandler;


@Produces
@Singleton
@Replaces(ConstraintExceptionHandler.class)
@Primary
@Requires(classes = { ConstraintViolationException.class, ExceptionHandler.class})
public class CustomConstraintExceptionHandler implements ExceptionHandler<ConstraintViolationException, HttpResponse<ErrorModel>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomConstraintExceptionHandler.class);


    @Override
    public HttpResponse<ErrorModel> handle(HttpRequest request, ConstraintViolationException exception) {
        LOGGER.info("*********** Inside Exception Handler *************");

        ErrorModel error = new ErrorModel();
        error.setErrorCode("404");
        error.setErrorMessage(exception.getMessage());
        return HttpResponse.status(HttpStatus.NOT_FOUND)
                .body(error);
    }


}
