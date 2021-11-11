package micronaut.httpclient.lambda.app;

import static io.micronaut.http.HttpHeaders.ACCEPT;

import javax.validation.constraints.NotBlank;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;

@Client("${book.url}/api/Customers") // <1>
@Header(name = ACCEPT, value = "application/json") // <3>
public interface BookApiClient {
    @Put("/{customerId}/locations/{locationId}") // <4>
    BookSaved updateBook(@Header("Authorization") String token, @PathVariable @NotBlank String customerId, @PathVariable @NotBlank String locationId , @Body Book input); // <5>

}