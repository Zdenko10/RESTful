package zdenko.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zdenko.constant.RoleType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    @NotNull
    @JsonProperty("_id")
    private long id;
    @NotBlank
    private String name;
    @NotNull
    private Date birthDate;
    @NotNull
    private String country;
    @NotNull
    private String biography;
    @NotNull
    private RoleType role;

}
