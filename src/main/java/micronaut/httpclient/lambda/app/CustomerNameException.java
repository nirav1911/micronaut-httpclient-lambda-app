package micronaut.httpclient.lambda.app;

public class CustomerNameException extends RuntimeException{
    public CustomerNameException(String message) {
        super(message);
    }
}
