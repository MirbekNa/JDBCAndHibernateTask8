package peaksoft.util;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Job jobId;

}
