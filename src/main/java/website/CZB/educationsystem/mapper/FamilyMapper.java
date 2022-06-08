package website.CZB.educationsystem.mapper;


import org.apache.ibatis.annotations.Mapper;
import website.CZB.educationsystem.entities.Family;

import java.util.List;

@Mapper
public interface FamilyMapper {
    Family getByFamilyName(String familyName);

    void addFamily(Family family);

    void deleteFamily(Family family);

    void changeFamily(Family family);

    List<Family> familyList();
}
