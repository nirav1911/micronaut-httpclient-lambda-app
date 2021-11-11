package micronaut.httpclient.lambda.app;
import java.net.URI;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;

@Singleton
public class BookLowLevelClient {
    @Client("${book.url}/api")
    private final HttpClient httpClient;
    public BookLowLevelClient(@Client("${book.url}/api") HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public HttpRequest buildHttpRequest(String customerId, String locationId, String token, Book request){
        URI uri = UriBuilder.of("/Customers")
                .path(customerId)
                .path("locations")
                .path(locationId)
                .build();
        HttpRequest<?> req = HttpRequest.PUT(uri,request)
                .header("Authorization", token)
                .header("ACCEPT", "application/json");
        return req;
    }

    BookSaved updateBook(HttpRequest request){
        return httpClient.toBlocking().retrieve(request, Argument.of(BookSaved.class) );
    }
}
