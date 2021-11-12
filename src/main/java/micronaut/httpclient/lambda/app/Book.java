package micronaut.httpclient.lambda.app;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotBlank;

@Introspected
public class Book {

    @NotBlank
    private String customerId;

    public Book() {
    }

    @NotBlank
    private String locationId;

    @NotBlank
    private String token;

    public String getCustomerId() {

        return customerId;
    }

    public void setCustomerId(@NonNull String customerId) {

        this.customerId = customerId;
    }

    public String getLocationId() {

        return locationId;
    }

    public void setLocationId(@NonNull String locationId) {

        this.locationId = locationId;
    }

    public String getToken() {

        return token;
    }

    public void setToken(@NonNull String token) {

        this.token = token;
    }

    public String getName() {

        return name;
    }

    public void setName(@NonNull String name) {

        this.name = name;
    }

    @NotBlank
    private String name;


}
