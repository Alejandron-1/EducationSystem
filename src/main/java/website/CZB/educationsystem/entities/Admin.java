package website.CZB.educationsystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {


    private String adminPhone;

    private String password;

    private String adminName;
}
