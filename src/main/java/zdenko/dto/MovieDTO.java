package zdenko.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    @NotNull
    @JsonProperty("_id")
    private long id;
    @NotBlank
    private String name;
    @NotNull
    private Long directorID;
    @NotNull
    private List<@Positive Long> actorIDs;
    @NotNull
    private boolean isAvailable;
    @NotNull
    private List<String> genres;
    @NotNull
    @Positive
    private Integer year;

    private Date dateAdded;
    private PersonDTO director;
    private List<PersonDTO> actors;

    @JsonProperty("isAvailable")
    public boolean isAvailable() {
        return isAvailable;
    }

}