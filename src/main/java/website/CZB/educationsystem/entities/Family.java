package website.CZB.educationsystem.entities;

import lombok.Data;
import java.io.Serializable;
@Data
public class Family implements Serializable {
    private Integer familyId;

    private String familyName;
}
