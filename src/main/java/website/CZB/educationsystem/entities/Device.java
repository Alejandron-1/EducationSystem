package website.CZB.educationsystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Device implements Serializable {

    private String deviceId;

    private String deviceDesc;

}
