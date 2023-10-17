package zdenko.entity.filter;

import lombok.Data;

@Data
public class MovieFilter {
    private long directorID = -1;
    private long actorID = -1;
    private String genre = "";
    private Integer fromYear;
    private Integer toYear;
    private Integer limit = 10;

}
