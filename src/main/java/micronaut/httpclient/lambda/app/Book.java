package micronaut.httpclient.lambda.app;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotBlank;

@Introspected
public class Book {

    @NonNull
    @NotBlank
    private String customerId;

    public Book() {
    }

    @NonNull
    @NotBlank
    private String locationId;

    @NonNull
    @NotBlank
    private String token;

    @NonNull
    public String getCustomerId() {

        return customerId;
    }

    public void setCustomerId(@NonNull String customerId) {

        this.customerId = customerId;
    }

    @NonNull
    public String getLocationId() {

        return locationId;
    }

    public void setLocationId(@NonNull String locationId) {

        this.locationId = locationId;
    }

    @NonNull
    public String getToken() {

        return token;
    }

    public void setToken(@NonNull String token) {

        this.token = token;
    }

    @NonNull
    public String getName() {

        return name;
    }

    public void setName(@NonNull String name) {

        this.name = name;
    }

    @NonNull
    @NotBlank
    private String name;


}
