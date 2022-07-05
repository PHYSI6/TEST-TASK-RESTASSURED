package pojos;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private String firstName;
    private String lastName;
}
