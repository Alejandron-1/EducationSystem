package website.CZB.educationsystem.entities;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {


    private String userPhone;

    private String password;

    private String userName;

    private String familyId;
}

